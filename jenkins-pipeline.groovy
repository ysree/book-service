pipeline {
    agent any

    options {
        timeout(time: 30, unit: 'MINUTES') 
    }
    
    triggers {
        pollSCM 'H/10 * * * *'
    }
    
    stages {
        stage('checkout') {
            steps {
                deleteDir()
                 
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/ysree/book-service.git']]
                ])
            }      
        }

        stage('build') {
            steps {
                if (isUnix()) {
                    sh 'chmod +x gradlew'
                    sh './gradlew clean build'
                } else {
                    bat 'gradlew.bat clean build'
                }
            }  
        }
    }
}