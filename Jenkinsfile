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

        environment{
        DOCKERHUB_CREDENTIAL = credentials('docker-cred')
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

        stage('login to docker hub'){
           steps{
              script{
                  bat 'docker login -u $DOCKERHUB_CREDENTIAL_USR --password-stdin'
                }
           }
        }

        stage('push image to docker hub'){
           steps{
              script{
                  bat 'docker push niitrajnish/spring-ci-cd:1.0'
                }
           }
        }

    }
}
