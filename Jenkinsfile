pipeline {
    stages {
	stage('SCM Checkout') {
		steps {
			git 'https://github.com/tivitscl/simple-java-maven-app'
		}
	}
   	 stage('Build') {
		 env.PATH = "${mvnHome}/bin/:${env.PATH}"
		 echo "variable env.PATH = '${env.PATH}'"
		steps {
			// comentario
			def mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
			//sh "${mvnHome}/bin/mvn -B -DskipTests clean package" 
			sh "mvn -B -DskipTests clean package" 
        	}  
      	}
    }
}
