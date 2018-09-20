pipeline {
	agent any
	environment {
	mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'	 
	PATH = "${mvnHome}/bin:${env.PATH}"
	}
	
    stages {

	stage('SCM Checkout') {
		steps {
			git 'https://github.com/tivitscl/simple-java-maven-app'
		}
	}
	    
   	 stage('Build') {
		steps {	
			echo " var env ${env.PATH} "
			echo " var mvn ${mvnHome} "
			// comentario
			echo "variable env.PATH = '${env.PATH}'"
			 
			sh "mvn -B -DskipTests clean package" 
        	}  
      	}
	    stage ('Testing') {
		    steps {
		    	sh 'mvn test'
			//junit 'reports/**/*.xml'
			junit 'simple-java-maven-app/reports/*.xml'
		    }    
	    }
	    
	    stage ('Deploy') {
		    steps {
		    	sh 'mvn deploy'
			
		    }    
	    }
    }
	
	
}
