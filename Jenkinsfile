pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/leandrocprates/springTransactional.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install -DskipTests=true"

            }

        }

        stage('Sonar analysis') {
            steps {
                // Run Maven on a Unix agent.
				sh "mvn clean verify sonar:sonar \
				  -Dsonar.projectKey=springTransactional \
				  -Dsonar.host.url=http://ec2-18-231-111-125.sa-east-1.compute.amazonaws.com:9000 \
				  -Dsonar.login=sqp_e1610f8682e0b381ea913dcb8a2e21732a2ffd55"  

		   }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t lprates/aplicacao ."
            }
        }

        stage('Docker Push - DockerHub') {
            steps {
                sh "docker tag lprates/aplicacao leandroprates/springtransactional "
              	withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                	sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push leandroprates/springtransactional:latest'
                }            
            }
        }

        
    }
}



