pipeline {
    agent any

    environment {
        // Define environment variables
        JAVA_HOME = tool name: 'JDK11', type: 'jdk'
        MAVEN_HOME = tool name: 'Maven3', type: 'maven'
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
                // Build the application using Maven
                withEnv(["JAVA_HOME=$JAVA_HOME", "PATH+MAVEN=$MAVEN_HOME/bin"]) {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                withEnv(["JAVA_HOME=$JAVA_HOME", "PATH+MAVEN=$MAVEN_HOME/bin"]) {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application
                echo 'Deploying the application...'
                // Add deployment steps here, such as copying files to a server or running a deployment script
            }
        }
    }

    post {
        always {
            // Archive build artifacts
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true

            // Clean up workspace
            cleanWs()
        }

        success {
            // Notify of successful build
            echo 'Build succeeded!'
        }

        failure {
            // Notify of failed build
            echo 'Build failed!'
        }
    }
}
