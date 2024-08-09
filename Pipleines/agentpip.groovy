pipeline {
    agent {
        node {
            label "dev"
        }
    }
    stages {
        stage("Code") {
            steps {
                echo "Code Cloned Successfully"
            }
        }
        stage("Build") {
            steps {
                echo "Image has been created through Docker Build"
            }
        }
        stage("Test") {
            steps {
                echo "Tests were run in Docker Build"
            }
        }
        stage("Deploy") {
            steps {
                echo "Docker Run Command has been executed successfully"
            }
        }
    }
}
