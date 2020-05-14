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
                System.setProperty("org.jenkinsci.plugins.durabletask.BourneShellScript.HEARTBEAT_CHECK_INTERVAL", "86400")
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }  
        }
    }
}
