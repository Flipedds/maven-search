@echo off
rem Verify if JAVA_HOME is configured
if "%JAVA_HOME%"=="" (
    echo JAVA_HOME is not configured.
    exit /b 1
)

rem Use the JAVA_HOME to run the program
"%JAVA_HOME%\bin\java" -jar "build/libs/maven-search-0.0.1-SNAPSHOT.jar" %*

rem Pause to see the output before closing
pause