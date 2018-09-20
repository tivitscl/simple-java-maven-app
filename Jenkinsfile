pipeline {
    stages {
	stage('SCM Checkout') {
		steps {
			git 'https://github.com/tivitscl/simple-java-maven-app'
		}
	}
   	 stage('Build') { 
	    def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
		steps {
		// comentario
		sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
        	}  
      	}	 
    }
}
