@ECHO OFF

ECHO Executing under directory %CD%
set jarpath="webapp\\jar\\apichallenges.jar"
java -jar %jarpath%

PAUSE