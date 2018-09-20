pipeline {
	agents {
	stage('SCM Checkout') {
		git 'https://github.com/tivitscl/simple-java-maven-app'
	}
      stage('Build') { 
	    def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
	    // comentario
	    sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
	    
          
      }
	}
}

