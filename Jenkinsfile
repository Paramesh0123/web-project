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
    stage('Publish Build Info') {
      steps {
        rtPublishBuildInfo (
          serverId: 'jfrog'
        )
      }
    }
    stage('deploy') {
      steps {
        sshagent(['tomcat_creds']) {
          sh "scp -o StrictHostKeyChecking=no target/hello-world-webapp.war ubuntu@13.233.17.19:/home/ubuntu/apache-tomcat-10.1.39/webapps"
        }
      }
    }
  }
}  
