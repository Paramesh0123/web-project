pipeline {
agent any 
stages {
  stage('checkout') {
    steps { 
      git credentialsId: 'git_credentials', url: 'https://github.com/Paramesh0123/web-project.git', branch: 'main'
    }
  }
  stage('build') {
    steps {
      sh 'mvn clean install'
    }
  }
  stage('deploy') {
    steps {
      sshagent(['tomcat_deploy_creds']) {
        sh "scp -o StrictHostKeyChecking=no target/hello-world-webapp.war paramesh@localhost:/home/paramesh/apache-tomcat-10.1.39/webapps"
      }
    }
  }
}
}
  
