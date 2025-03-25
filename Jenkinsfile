pipeline {
agent any 
stages {
  stage('checkout') {
  steps { 
    sh 'git pull https://github.com/Paramesh0123/web-project.git'
  }
  }
  stage('build') {
  steps {
    sh 'mvn clean install'
  }
  }
}
}
  
