# Kohlantstats development
## Setup environment
Setup docker containers 
### Backend
Start backend

It starts a docker composer which 
* start the DB 
* clean and reset data 
* start tomcat server
* deploy REST/graphQL API 
```sh
./start-kls-backend.sh 
```
### development of the model 
```sh
$docker pull mysql:latest
```
or 
```sh
$docker pull mysql:8.0
```
Instantiate image into container
```sh
docker run -d -e MYSQL_ROOT_PASSWORD=admin --name mysql_8_0 mysql:8.0 --lower_case_table_names=1
```

Start from an installed container 
```sh
docker start mysql_8_0
```

#### Change global 
https://stackoverflow.com/questions/23921117/disable-only-full-group-by

```sh
docker exec -it mysql_8_0 bash


apt-get update
Apt-get install nano
nano /etc/mysql/my.cnf

Copy at the end
[mysqld] 
sql_mode = "STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION"
log_bin_trust_function_creators = 1

$ service mysql restart
```

#### Get the IP address
```sh
docker inspect mysql_8_0 | grep -i ipaddress
```

#### Configure your IDE 
Configure mysqlworkbench 

#### Run flyway script via maven cmd
```sh
./migrate.sh 
```

### development in ember

#### Nvm check 
Regarding the version of ember it requires a certain nodejs version
To check node v14.21.1

```sh
nvm ls
nvm use 14.21.1
```

Starts ember server on http://localhost:4400/


With local data pointing to the local backend 
```sh
./start-kls-ember-dev.sh 
```

With remote data
```sh
./start-kls-ember.sh 
```

### Tests 
Unit tests 

```sh
./start-kls-test.sh 
```
Cypress functional tests 

```sh
./start-kls-cypress.sh 
```

## Setup development 
### DB Modeling
Mysql DB is used to store data

DB migrations are store under ./MODEL/migration 

Migrations are executed by Flyway.


### Business code 

Written in java based on reverse engineering DB structure and sql statements. 

100% of the Backend rest service code is done by minuteproject generating REST and GRAPHQL API as well as stub for ember data.

* Initiate DB instance 
```sh
docker start mysql_8_0
```
* Run DB scripts
In MODEL/migration
```sh
./migrate.sh 
```
* Minuteproject Generation 
** For KendoUI, ember stacks
```sh
java net.sf.minuteProject.application.ModelViewGenerator game-score-public-api.xml -DjdbcUrl=jdbc:mysql://172.19.0.2:3306/kohlantstats -Dusername=kls_crud -Dpassword=xxx -Dtarget=REST-Kendoui,Ember
```
** For graphql, ember stacks
```sh
java net.sf.minuteProject.application.ModelViewGenerator game-score-public-api.xml -DjdbcUrl=jdbc:mysql://172.19.0.2:3306/kohlantstats -Dusername=kls_crud -Dpassword=xxx -Dtarget=REST-GRAPHQL_API,Ember
```
* Build & deploy app for local development
In the generated folder of minuteproject (ex : minuteproject/product/game-score-public-api/REST-GRAPHQL_API)
```sh
mvn clean package -Ptomcat-embedded-ds 
cp REST/target/scoreGraphQLApp.war ${pathToKlsGitLocalRepository}/Kohlantstats-app/APPS/__RELEASES/tomcat/
```
** 2 apps 
** scoreKendoUiApp (http://localhost/scoreKendoUiApp/data/*)
** scoreGraphQLApp (http://localhost/scoreGraphQLApp/data/graphql/graphiql)

* Ember API adapters and services 
Minuteproject generates Ember stubs for adapters and services that can be copied in Ember adapter and services
Environment configuration of datasource is to be added in environment.js 

## Deployment
### Migrate DB script
On mysql cloud server perform migration
### REST API on tomcat 
#### Build without embedded datasource 
```sh
mvn clean package 
cp REST/target/scoreGraphQLApp.war to cloud tomcat server
```
Check URL API, graphql etc 
### Deploy Ember application
#### On surge
```sh
./surge-release.sh 
```
#### On Apache2 http server 
ember build --environment=prototype

Copy dist artifacts (ftp)


## Kohlantstats microservices ecosystem
### Property microservices

### Quizz microservices
