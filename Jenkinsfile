pipeline{

    agent any
    tools{
        maven "maven"
    }

    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nthraj1989/my-ci-cd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("Build Image"){
            steps{
                script{
                    bat 'docker build -t niitrajnish/spring-ci-cd:1.0 .'
                }
            }
        }
        
        stage('push image to hub'){
           steps{
              script{
                 withCredentials([usernamePassword(credentialsId: 'niitrajnish', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                  bat 'docker login -u ${USERNAME} -p ${PASSWORD}'
                  bat 'docker push niitrajnish/spring-ci-cd:1.0'
                  }
              }
           }
        }
        
    }
}
