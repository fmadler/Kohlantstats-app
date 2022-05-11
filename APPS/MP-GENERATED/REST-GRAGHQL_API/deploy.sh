. ~/DEV/set-env.sh
mvn clean package -Ptomcat-embedded-ds
cp ./REST/target/scoreKendoUiApp.war ../../../APPS/__RELEASES/tomcat
