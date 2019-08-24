Steps to run locally -
 
1. Set up JAVA_HOME.
 
2. Verify if JAVA_HOME set up correctly by running the following 2 commands –
    a. echo %JAVA_HOME%
    b. java -version

3. Set up MAVEN_HOME.

4. Verify if MAVEN_HOME set up correctly by running the following 2 commands -
    a. echo %MAVEN_HOME%
    b. mvn -version

5. Clone the Git repository - https://github.com/Shreyasc27/reddit-ui-test.git

6. Execute command - cd reddit-ui-test

7. Execute command - mvn clean compile package install test

8. Execute command - cd target/surefire-reports

9. Open following 2 Html Reports -
    a. emailable-report.html
    b. Reddit-Ui-Test.html.html

Integration with CircleCI -

reddit-ui-test execution is integrated with CircleCI.

Execution job can be viewed at - 
https://circleci.com/gh/Shreyasc27/reddit-ui-test/30

Execution result can be viewed at -
https://30-161029561-gh.circle-artifacts.com/0/home/circleci/reddit-ui-test/target/surefire-reports/emailable-report.html

CircleCI can be triggered for execution by clicking Rerun workflow - Rerun workflow





