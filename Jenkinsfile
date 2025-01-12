pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	triggers {
		pollSCM '* * * * *'
    }


	stages {

		stage('Build') {
			steps {
				echo "Building.."
                sh '''
            		mvn clean install -DskipTests
                '''
			}
		}

		stage('Test') {
			steps {
				echo "Test..."
				sh '''
				mvn test
				'''
			}
		}

	}

}