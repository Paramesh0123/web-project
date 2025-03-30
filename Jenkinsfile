@Library("shared_libraries") _
pipeline {
agent any
stages {
  stage('checkout') {
    steps {
        checkout_web_project()
    }
  }
  stage('build') {
    steps {
        mavenbuild()
    }
  }
  stage('SonarQube Analysis') {
    steps {
      withSonarQubeEnv('sonar') {
        sh 'mvn sonar:sonar'
      }
    }
  }
  stage('deploy') {
    steps {
      sshagent(['deploy_creds']) {
        sh "scp -o StrictHostKeyChecking=no target/hello-world-webapp.war ubuntu@3.7.46.213:/home/ubuntu/apache-tomcat-10.1.39/webapps"
      }
    }
  }
}
}
  
