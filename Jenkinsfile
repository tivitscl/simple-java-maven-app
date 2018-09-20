pipeline {
	agent any
    stages {
	
        stage('Build') { 
	    def svnHome = tool name: 'maven-3.5.0-jenkins', type: 'maven'
            steps {
		    // comentario
		    sh '${svnHome}/bin/mvn -B -DskipTests clean package' 
	    
            }
        }
    }
}

