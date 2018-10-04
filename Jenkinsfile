pipeline {
	agent any
	environment {
	//mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'	 
	mvnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'	 
	PATH = "${mvnHome}/bin:${env.PATH}"
	sonarHOME = tool name: 'sonarQubeScanner-3.0.0.702', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	//sonarHOME = tool name: 'sonarServer', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
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
			
			//sh "mvn -B clean install" 


		}  
      	}
	
	   stage('Sonarqube Analysis') {
		   
		   
		      steps {
			echo '--------------------------SONARQUBE ANALIST---------------------------------------'
			
			//withSonarQubeEnv('SonarQube Scanner') { No lo encontro
			 //withSonarQubeEnv('sonarQubeScanner-3.0.0.702') { // defined in this job (sonarQubeScanner-3.0.0.702) does not match any configured installationesta definido en tool			
			  //sh 'sonar-scanner'
			withSonarQubeEnv('sonarServer') { // definido en admin jenkins : SOnarWube servers
			 sh "${sonarHOME}/bin/sonar-scanner"
			//sh "sonar-scanner"
			 }
			}
	        
		/*steps {
			echo '----------------------------------------------------------------------------------'
			echo '--------------------------SONARQUBE ANALIST---------------------------------------'
			echo '----------------------------------------------------------------------------------'
		*/	// sh 'mvn sonar:sonar'
			
			/*def scannerHome = tool 'sonarQubeScanner-3.0.0.702'
			withSonarQubeEnv('sonarServer')
			sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=fr.demo:my-project -Dsonar.sources=.- -Dsonar.java.binaries=.""
			*/
		//}
	}
	/*
			// verificar sonnar con estado de la calidad 
			  script {
			    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
			    echo '----> SONAR - CHECK - status Analyst'
			    echo '-----       status: ${qg.status}'
			    if (qg.status != 'OK') {
			      error "Pipeline aborted due to quality gate failure: ${qg.status}"
			    }    
	  */  
	stage("Quality Gate 1") {
            steps {
		 echo '----> SONAR - CHECK - status Analyst: '
		 timeout(time: 3, unit: 'MINUTES') {
		    script{
		def qualitygate = waitForQualityGate()
		      if (qualitygate.status != "OK") {
			 error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
		      }
		    }
		 }
                //waitForQualityGate abortPipeline: true
            }
        }
	stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
	 stage('Deliver') {
            steps {
		sh 'pwd'
		 sh 'whoami'
		   sh 'chmod 775 -R ./jenkins/scripts/'
		sh 'ls -la ./jenkins/scripts/'
               // sh './jenkins/scripts/deliver.sh'
            }
        }
	   
	stage ('Starting job deploy webapp') {
            steps {
		echo "--------------------------------------- call job build ------------------------"
    		build ('app-build1')

	    }
	}
	//    stage ('Testing') {
	//	    steps {
	//	    	sh 'mvn test'
	//		//junit 'reports/**/*.xml'
		/*	junit 'simple-java-maven-app/reports/*.xml'
		    }    
	    }
	  */  
	 /*   stage ('Deploy') {
		    when {
			    expression {
			    currentBuild.result == null || currentBuild.result == 'SUCCESS'
			    }
		    }
		    steps {
		    	sh 'mvn deploy'
			
		    }    
	    }
	    */
	    
    }
	post {
		success {
		     
		      emailext (
			  subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
			  body: """Ejecuci&oacute;n de job en jenkins fue SUCCESSFUL:<br> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':
			    <br>Verificar la consola ${env.BUILD_URL}' """,
			      to: "fernandop2007@gmail.com",
			  recipientProviders: [[$class: 'DevelopersRecipientProvider']]
			  
			)
		    }

		failure {
			emailext body: "Ocurrio un error en job de ejenkins FAILED: <br>Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'  <br>(${env.BUILD_URL})" 	, subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]"  , to: "fernandop2007@gmail.com"
		}
	}
	
}
