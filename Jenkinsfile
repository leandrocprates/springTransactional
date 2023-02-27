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

        stage('Docker Build') {
            steps {
                sh "docker build -t lprates/aplicacao ."
            }
        }

        stage('Docker Push - DockerHub') {
            steps {
                sh "docker tag lprates/aplicacao leandroprates/springtransactional "
              	withCredentials([usernamePassword(credentialsId: 'dockerhub-credencial', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                	sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push leandroprates/springtransactional:latest'
                }            
            }
        }

        
    }
}



