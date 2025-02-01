pipeline {
	agent any

	tools {
		jdk 'jdk-21'
		maven 'maven-3'
	}

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
						mvn clean test-compile surefire:test ${MAVEN_ARGS}
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
			withSonarQubeEnv('sonar') {
			withMaven(maven: 'maven-3') {
            					  sh '''
                                       echo "Running Sonar Analysis"
                                       mvn sonar:sonar -Dsonar.dependencyCheck.jsonReportPath=target/dependency-check-report.json -Dsonar.dependencyCheck.xmlReportPath=target/dependency-check-report.xml -Dsonar.dependencyCheck.htmlReportPath=target/dependency-check-report.html
                                  '''
            				}

			    }
		    }
	    }

	    stage("Quality Gate") {
                    steps {
                      timeout(time: 1, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: true
                      }
                    }
        }

		stage('OWASP Dependency-Check vulnerabilities') {
			steps {
				sh '''
					echo "OWASP Dependency-Check vulnerabilities"
					mvn dependency-check:check
				'''
				dependencyCheckPublisher pattern: '/target:dependency-check-report-xml'
			}
		}
	}

}