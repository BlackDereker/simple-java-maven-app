pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v ./root:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Archive Tests') {
      steps {
        junit(testResults: 'target/test-reports/*.xml', allowEmptyResults: true, skipPublishingChecks: true)
      }
    }

    stage('Deliver') {
      steps {
        sh './jenkins/scripts/deliver.sh'
      }
    }

  }
}