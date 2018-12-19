pipeline {
  agent any
  stages {
    stage('Make Environment') {
      parallel {
        stage('Touch local.properties') {
          steps {
            sh 'echo "sdk.dir=/opt/android-sdk-linux" >> local.properties'
          }
        }
        stage('Display directory') {
          steps {
            sh 'ls -la'
          }
        }
      }
    }
    stage('permission') {
      steps {
        sh 'chmod 777 gradlew'
      }
    }
    stage('assembleDebug') {
      steps {
        sh './gradlew --no-daemon assembleDebug --stacktrace'
      }
    }
  }
  environment {
    GOOGLE_SERVICES_JSON = ''
  }
}