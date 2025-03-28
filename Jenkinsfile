pipeline {
agent {
  node {
    label 'jenkins_agent_1'
  }
}
stages {
  stage('checkout') {
    steps { 
      sh 'git clone https://github.com/Paramesh0123/web-project.git'
    }
  }
  stage('build') {
    steps {
      sh 'mvn clean install'
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
  
