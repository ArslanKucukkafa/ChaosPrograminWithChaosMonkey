pipeline {
    agent any
    tools {
        jdk 'jdk17-preview'
        maven '3.9.6'

    }
    stages {
        stage("build project") {
            steps {
                echo "Java VERSION"
                sh 'java -version'
                echo "Maven VERSION"
                sh 'mvn -version'
                echo 'building project...'
                sh "mvn compile"
                sh "mvn package"
                sh "mvn clean install"
            }
        }
    }
}