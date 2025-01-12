pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        sh '''
            		mvn clean install -DskipTests
                '''
      }
    }

    stage('Test') {
      steps {
        echo 'Test...'
        sh '''
				mvn test
				'''
      }
    }

  }
  environment {
    mavenHome = 'jenkins-maven'
  }
  triggers {
    pollSCM('* * * * *')
  }
}