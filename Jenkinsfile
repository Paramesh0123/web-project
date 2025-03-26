pipeline {
agent {
  node {
    label 'agent_template'
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
        sh "scp -o StrictHostKeyChecking=no target/hello-world-webapp.war ubuntu@43.204.111.135:/home/ubuntu/apache-tomcat-10.1.39/webapps"
      }
    }
  }
}
}
  
