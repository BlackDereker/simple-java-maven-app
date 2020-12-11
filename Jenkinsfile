pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
      reuseNode true
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
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

    stage('Deploy') {
      steps {
        sh 'mv ./target/*.jar /target'
        sh 'mv ./target/test-reports /target'
      }
    }

  }
}