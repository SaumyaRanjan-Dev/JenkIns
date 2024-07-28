pipeline {
    stages {
        stage('Code') {
            steps {
                echo 'Code Cloned Successfully'
            }
        }
        stage('Build') {
            steps {
                echo 'Image has been Done Through Docker Build'
            }
        }
        stage('Test') {
            steps {
                echo 'Tests were there in Docker Build'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Docker Run Command has been successfully worked'
            }
        }
    }
}
