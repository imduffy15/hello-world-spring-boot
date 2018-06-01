@Library('github.com/noreilly/jenkins-pipeline@master')

def pipeline = new com.noreilly.Pipeline()

pipeline.baseTemplate {
    node('jenkins-pipeline') {
        sh "git config --global http.sslVerify false"
        checkout scm
        stage('Compile') {
            container('mvn') {
                sh "mvn clean package"
            }
        }
        stage('Test') {
            container('mvn') {
                sh "mvn test"
            }
        }
        stage('Application Security Scan') {
            container('mvn') {
                sh "mvn dependency-check:check"
            }
        }
    }
}

