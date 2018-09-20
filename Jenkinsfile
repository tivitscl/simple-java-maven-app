pipeline {
    stages {
	stage('SCM Checkout') {
		steps {
			git 'https://github.com/tivitscl/simple-java-maven-app'
		}
	}
   	 stage('Build') { 
	   
		steps {
		// comentario
		def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
		sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
        	}  
      	}	 
    }
}
