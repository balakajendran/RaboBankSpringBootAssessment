# RaboBankSpringBootAssessment
Demo Application of Customer Transaction Report
Download the Apache ActiveMQ 
*****************************
Step 1: URL - http://activemq.apache.org/activemq-5111-release.html
Step 2: Download the version - apache-activemq-5.11.1-bin.zip
Step 3: Unzip and put it in your machine.
Step 4: Make sure the unzipped file have all the access.
Step 5: Traverse into the folder using cmd prompt and run the activemq.bat file.
Traverse into the Path - apache-activemq-5.11.1-bin\bin\win32 or win64\
Step 7: Run cmd ->  activemq
Step 8: Open the below mentioned URL to check the ActiveMQ is available
URL - http://localhost:8161/admin/
User Name/Password - admin/admin
Step 9: Select the Queues tab in menu list
Step 10: Create the Queue with Queue Name – customerTransactionQueue
Download the Source from Github
*****************************
Step 11: Download the project zip file from github.com
Github location - https://github.com/balakajendran/RaboBankSpringBootAssessment
Step 12: Unzip the file and rename the file name as RaboBankSpringBootAssessment
Download the Apache Maven 
*****************************
Step 13: Download the Apache Maven software from below mentioned path.
Apache Maven - https://maven.apache.org/download.cgi
Download binary zip file of apache-maven-3.5.4-bin.zip 
Step 14: Unzip the file in your machine
Step 15: Add both M2_HOME and MAVEN_HOME variables in the Windows environment, and point it to your Maven folder.
Example - 
Name - M2_HOME
Value - E:\officelap\CTS-assignment\apache-maven-3.5.4

Name - MAVEN_HOME
Value - E:\officelap\CTS-assignment\apache-maven-3.5.4

Step 16: Update the M2_HOME property into path variable
M2_HOME property - %M2_HOME%\bin

Step 17: Run the following cmd in cmd prompt to check maven installed properly.
cmd -> mvn -version
It will return the maven installation details.
Deploy the Spring boot Application
*****************************
Step 18: Traverse into your unzipped project location to build the application
For Example 
Project location - E:\CTS-assignment\RaboBankSpringBootAssessment
Traverse up to project location and run the following cmd
cmd -> mvn clean install -Dmaven.test.skip=true

Step 19: Once Deployment success then run the application starting cmd
cmd -> mvn spring-boot:run
This cmd will start your spring boot application

Note: The Spring boot application is process the CSV formatted data and validates the Transaction details and log the error transaction details
Download the Angular JS application from GitHub
******************************************
Step 20: Download the angular js application to view the error transaction details
github location - https://github.com/balakajendran/CTS-AssignementAngularApp

Step 21: Unzip the angular Js application into your location machine

Step 22: Run the html page in your browser to view the error transaction details.
Note: Make sure spring boot must be running in your machine to view the error transaction.
Output screen shot attached with this angular JS application with name of - CTS-assignment-result.png to validate the code in case any problem occurred in deploy the application.

Input File Path available in project location - > RaboBankSpringBootAssessment\src\main\resources\templates\records.csv


Please reach out to me if any clarification required

