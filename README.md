# JavaCalismalari
java calisma


------ USE EXTERNAL JAR FILES IN MAVEN --------
- create local-repository from exernal jar in maven
- create folder as named local-repo
- run below commannd
	
	mvn install:install-file -Dfile=./jarFiles/test.jar -DgroupId=local-repo-group -DartifactId=test-model -Dversion=0.1 -Dpackaging=jar -DlocalRepositoryPath=./local-repo


- add below configuration to pom.xml

      
		<dependency>
			<groupId>local-repo-group</groupId>
			<artifactId>test-model</artifactId>
			<version>0.1</version>
		</dependency>
		<repository>
			<id>local-repo</id>
			<name>local-repo</name>
			<url>file://${project.basedir}/local-repo</url>
		 </repository>


# Concurrency vs Parallelisim

if you jhave two threads 

Concurrency                
(Single-Core CPU)           
 ___                         
| th1 |                       
|     |                       
|___  | ___                    
      | th2 |                   
 ___  | ___ |                   
| th1 |                       
| ___ | ___                    
      | th2 |
    
 Concurrency + parallelism
(Multi-Core CPU)
 ___  ___
| th1 | th2|
|     | ___ |
|     | ___
|___  | th2 |
 ___  | ___ |
| th1 |
|     | ___
|     | th2|


    
Parallelism is simultaneous execution of processes on a multiple cores per CPU or multiple CPUs (on a single motherboard).
Concurrency is when Parallelism is achieved on a single core/CPU by using scheduling algorithms that divides the CPU’s time (time-slice). Processes are interleaved.
    
    
