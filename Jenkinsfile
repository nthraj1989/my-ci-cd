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
                    bat 'docker build -t spring-ci-cd:1.0 .'
                }
            }
        }
        stage('run docker image') {
            steps {
                script{
                    bat 'docker run -d spring-ci-cd:1.0'
                }
            }
         }
    }
}
