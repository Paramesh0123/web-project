@Library("shared_libraries") _
pipeline {
agent any
stages {
  stage('checkout') {
    steps { 
      script {
        checkout-web-project()
      }
    }
  }
  stage('build') {
    steps {
      script {
        mavenbuild()
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
  
