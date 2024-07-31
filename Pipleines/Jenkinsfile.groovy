pipeline {
    agent any

    environment {
        // Define environment variables if needed
        DOCKER_REGISTRY = 'your-docker-registry'
        APP_IMAGE = 'your-webapp-image'
        DB_IMAGE = 'your-database-image'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git url: 'https://github.com/your-repository.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Build Docker images for the web application and database
                    sh 'docker build -t ${DOCKER_REGISTRY}/${APP_IMAGE}:latest ./webapp'
                    sh 'docker build -t ${DOCKER_REGISTRY}/${DB_IMAGE}:latest ./database'
                }
            }
        }

        stage('Push') {
            steps {
                script {
                    // Push Docker images to the registry
                    sh 'docker push ${DOCKER_REGISTRY}/${APP_IMAGE}:latest'
                    sh 'docker push ${DOCKER_REGISTRY}/${DB_IMAGE}:latest'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Pull the latest Docker images
                    sh 'docker pull ${DOCKER_REGISTRY}/${APP_IMAGE}:latest'
                    sh 'docker pull ${DOCKER_REGISTRY}/${DB_IMAGE}:latest'

                    // Run the database container
                    sh '''
                    docker run -d --name mydatabase \
                    -e POSTGRES_USER=myuser \
                    -e POSTGRES_PASSWORD=mypassword \
                    -e POSTGRES_DB=mydb \
                    ${DOCKER_REGISTRY}/${DB_IMAGE}:latest
                    '''

                    // Run the web application container, linking it to the database container
                    sh '''
                    docker run -d --name mywebapp \
                    --link mydatabase:db \
                    -p 80:80 \
                    ${DOCKER_REGISTRY}/${APP_IMAGE}:latest
                    '''
                }
            }
        }
    }

    post {
        always {
            // Clean up workspace
            cleanWs()
        }

        success {
            // Notify of successful deployment
            echo 'Deployment succeeded!'
        }

        failure {
            // Notify of failed deployment
            echo 'Deployment failed!'
        }
    }
}
