This file describes the framework being used and its internal functionality

About Framework:
1. This is a testNG based test automation framework
2. This is used to test the REST webservices of locally deployed (covered later) JAR named apichallenges.
    Credit: Jar is provided by Alan (eviltester.com) and can be downloaded at https://apichallenges.herokuapp.com/

3. Dependency: We need to start the apichallenge jar locally before executing any test
    This is achieved using @BeforeSuite annotation






################################TODO#######################################
Need to manage start jar path while running from fat jar. Right now it is not fetching correct path
Need to write code to stop the jar from running