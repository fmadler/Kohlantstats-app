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
$./start-kls-backend.sh 
```
### development in ember
Starts ember server on http://localhost:4400/


With local data pointing to the local backend 
```sh
$./start-kls-ember-dev.sh 
```

With remote data
```sh
$./start-kls-ember.sh 
```

### Tests 
Unit tests 

```sh
$./start-kls-test.sh 
```
Cypress functional tests 

```sh
$./start-kls-cypress.sh 
```

## Setup development 
### DB Modeling
Mysql DB is used to store data

DB migrations are store under ./MODEL/migration 

Migrations are executed by Flyway.


### Business code 
Written in java based on reverse engineering DB structure and sql statements. 

100% of the Backend rest service code is done by minuteproject generating REST and GRAPHQL API as well as stub for ember data.


## Kohlantstats microservices ecosystem
### Property microservices

### Quizz microservices
