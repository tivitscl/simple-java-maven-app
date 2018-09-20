pipeline {
	agent any
    stages {
	
        stage('Build') { 
	    def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
            steps {
		    // comentario
		    sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
	    
            }
        }
    }
}

