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
}
}
  
