pipeline{

    agent any
    tools{
        maven "maven"
    }


    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/javatechie-devops/jenkins-ci-cd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }`

        stage("Build Image"){
            steps{
                script{
                    sh 'docker build -t spring-ci-cd:1.0 .'
                }
            }
        }
    }
}
