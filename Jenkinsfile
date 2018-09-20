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
			 
			sh "mvn -B -DskipTests clean install" 
        	}  
      	}
	stage('Sonarqube Analysis') {
		def scannerHome = tool 'sonarQubeScanner-3.0.0.702'
		withSonarQubeEnv('sonarServer')
		sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=fr.demo:my-project -Dsonar.sources=.- -Dsonar.java.binaries=.""
	}
	    
	//    stage ('Testing') {
	//	    steps {
	//	    	sh 'mvn test'
	//		//junit 'reports/**/*.xml'
		/*	junit 'simple-java-maven-app/reports/*.xml'
		    }    
	    }
	  */  
	    stage ('Deploy') {
		    when {
			    expression {
			    currentBuild.result == null || currentBuild.result == 'SUCCESS'
			    }
		    }
		    steps {
		    	sh 'mvn deploy'
			
		    }    
	    }
    }
	
	
}
