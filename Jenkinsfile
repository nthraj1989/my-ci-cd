pipeline{

    agent any
    tools{
        maven "maven"
    }

//     environment{
//                APP_NAME = "spring-ci-cd"
//                RELEASE_NO= "1.0.0"
//                DOCKER_USER= "niitrajnish"
//                IMAGE_NAME= "${DOCKER_USER}"+"/"+"${APP_NAME}"
//                IMAGE_TAG= "${RELEASE_NO}-${BUILD_NUMBER}"
//         }

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
                 withCredentials([string(credentialsId: 'docker-cred', variable: 'dc')]) {
                  bat 'docker login -u niitrajnish -p ${dc}'
                  bat 'docker push niitrajnish/spring-ci-cd:1.0'
                  }
              }
           }
        }
    }
}
