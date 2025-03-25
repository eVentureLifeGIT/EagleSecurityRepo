@ECHO OFF
CLS
IF NOT DEFINED JAVA_HOME GOTO ERROR_JAVA_HOME

ECHO ==================================
ECHO Build Options
ECHO ==================================
ECHO 1 = Run
ECHO 2 = Compile Project Jar.
ECHO 3 = Docker Image Create
ECHO 4 = Database Initialization
ECHO ==================================

SET /P MODULE=Please Enter Option [Valid Input: 1-4]: 
IF NOT DEFINED MODULE SET MODULE=1

IF "%MODULE%"=="1"   GOTO RUN_ALL
IF "%MODULE%"=="2"   GOTO COMPILE_ALL
IF "%MODULE%"=="3"   GOTO DOCKER_IMAGE
IF "%MODULE%"=="4"   GOTO DATABASE_INITIALIZE

CLS
ECHO INVALID OPTION SELECTED, PLEASE TRY AGAIN [Valid Input: 1-2].........
GOTO SELECT_MODULE

:RUN_ALL
CLS
mvnw spring-boot:run
GOTO END

:COMPILE_ALL
CLS
mvnw clean package
GOTO END

:DOCKER_IMAGE
docker build . --platform=windows/amd64
docker build . --platform=windows/amd64 -t pocapp-backend-services
GOTO END

:DATABASE_INITIALIZE
mysql -u root -p < "../db-script/dbscript.sql"
GOTO END

:ERROR_JAVA_HOME
ECHO Please Define Environment Variable JAVA_HOME to JDK 17 installation.......
GOTO END

:MYSQL_NOT_FOUND
ECHO You must add the directory containing mysql.exe (Your MySQL installation) to your Windows Environment Variable PATH.......
GOTO END

:END