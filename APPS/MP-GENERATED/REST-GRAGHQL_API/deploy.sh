. ~/DEV/set-env.sh
mvn clean package -Ptomcat-embedded-ds
cp ./REST/target/scoreKendoUiApp.war ~/DEV/GITHUB/fmadler/MicroServices/MicroServices/game_score/APPS/__RELEASES/tomcat