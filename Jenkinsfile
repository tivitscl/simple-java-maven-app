pipeline {
	agent any
	
	
	
    stages {
	 stage ('Initialize') {
		 steps {
	     def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
		echo " var env ${env.PATH} "
		echo " var mvn ${mvnHome} "
	    env.PATH = "${mvnHome}/bin:${env.PATH}"
		 }
	}
	stage('SCM Checkout') {
		steps {
			git 'https://github.com/tivitscl/simple-java-maven-app'
		}
	}
	
	    
   	 stage('Build') {
		
		 
		steps {
			// comentario
			echo "variable env.PATH = '${env.PATH}'"
			//sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
			sh "mvn -B -DskipTests clean package" 
        	}  
      	}
    }
}
