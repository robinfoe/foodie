# Getting started

Foodie is a simple food provider that allow user to perform online booking and track the progress of the order. The services consist of 
- Consumer Service
- Restaurant Service
- Order Service 
- Kitchen Service

## Tech stack 

Foodie consist of 
- Writtern in java 11
- Springboot as main bootstrap point 
- Maven as building tools 
- Postgres and Kafka as persistance  layer 


## Diagrams 
![Foo](foodie.png)





## Build instructions

### tools 
- buildpack
- skaffold 
- 

## Deployment 


Deployment , statefulset, configmaps

scenario 1
 - consumer and restaurant service + postgresql

Scenario 2 
 - kafka 


Scenario 3 
 - order and kitchen services 


// set HPA  ?? 


Docker compose


start PG admin

docker run -d \
	-e POSTGRES_USER=foodie \
	-e POSTGRES_PASSWORD=foodie \
	-e POSTGRES_DB=foodie \
	-p 5432:5432 \
	postgres:13
