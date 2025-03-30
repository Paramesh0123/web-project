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
  stage('deploy') {
    steps {
      sshagent(['deploy_creds']) {
        sh "scp -o StrictHostKeyChecking=no target/hello-world-webapp.war ubuntu@35.154.24.43:/home/ubuntu/apache-tomcat-10.1.39/webapps"
      }
    }
  }
}
}
  
