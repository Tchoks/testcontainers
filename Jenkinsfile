pipeline {
	agent any

	environment {
		MAVEN_ARGS = " -B -e -U"
	}

	stages {

		stage('Build') {
			steps {
				withMaven(maven: 'maven-3') {
					echo "Building.."
                	sh '''
            			mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true ${MAVEN_ARGS}
                	'''
				}

			}
		}

		stage('Unit Tests') {
			steps {
				withMaven(maven: 'maven-3') {
					echo "Unit Tests..."
					sh '''
						mvn clen test-compile surefire:test ${MAVEN_ARGS}
					'''
				}
			}
		}

		stage('Integration Tests') {
			steps {
				withMaven(maven: 'maven-3') {
					echo "Integration Tests..."
					sh '''
					   mvn clean verify -Dskip.unit.tests=true ${MAVEN_ARGS}
					'''
				}
			}
			post {
				success {
					junit allowEmptyResults: true, testResults: '**/**reports/*.xml'
				}
			}
		}

		stage('Code Quality - Sonar') {
			steps {
				sh '''
					echo "Running Sonar Analysis"
				'''
			}
		}

		stage('OWASP Dependency-Check vulnerabilities') {
			steps {
				sh '''
					echo "OWASP Dependency-Check vulnerabilities"
				'''
			}
		}
	}

}