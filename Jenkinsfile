pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'java-21'
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