pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        sh 'git pull https://github.com/Paramesh0123/web-project.git'
      }
    }
    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('sonar') {
          sh 'mvn sonar:sonar'
        }
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Publish Artifacts to Jfrog Artifactory') {
      steps {
        rtUpload (
          serverId: 'jfrog',
          spec: '''{
                "files": [
                   {
                     "pattern": "target/hello-world-webapp.war",
                     "target": "libs-release-local"
                   }
                ]
          }'''      
        )  
      }
    }
    stage('Docker Build') {
      steps {
          sh "sudo docker build -t sample-deploy ."
      }
    }
  }
}
