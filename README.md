# JavaCalismalari
java calisma


------ USE EXTERNAL JAR FILES IN MAVEN --------
create local-repository from exernal jar in maven
- create folder as named local-repo
- run below command 
mvn install:install-file -Dfile=./jarFiles/test.jar -DgroupId=local-repo-group -DartifactId=test-model -Dversion=0.1 -Dpackaging=jar -DlocalRepositoryPath=./local-repo
- add below configuration to pom.xml
		      <repository>
			<id>local-repo</id>
			<name>local-repo</name>
			<url>file://${project.basedir}/local-repo</url>
		      </repository>
      
		<dependency>
			<groupId>local-repo-group</groupId>
			<artifactId>test-model</artifactId>
			<version>0.1</version>
		</dependency>


