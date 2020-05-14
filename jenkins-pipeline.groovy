pipeline {
    agent any

    options {
        timeout(time: 1, unit: 'HOURS') 
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
                withGradle {
                    sh 'chmod +x gradlew'
                    sh './gradlew clean build'
                }
            }  
        }
    }
}
