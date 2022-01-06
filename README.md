# hazelcast-jpa-demo

## Getting started
This sample application demonstrates read-through and write-through functionality of Hazelcast using [spring-data-hazelcast](https://github.com/hazelcast/spring-data-hazelcast) and [spring-data-jpa](https://spring.io/projects/spring-data-jpa)


Please run this app as Spring Boot application.

Deploying locally:
```
gradlew clean bootRun
```

You may spin-up additional Hazelcast member by deploying in a new terminal and see it forming a cluster.
Just make sure to specify another `server.port`. Default is 8080:
```
gradlew clean bootRun --args='--server.port=8081'
```


H2 is used as an in memory relational database for simplicity.
H2 console has been enabled to conveniently see what entries are read-through and that changes to the cache are written-through the data store.
```http://localhost:8080/h2-console```

Sample Calls:
```
# Yes, all these are GET and is not proper for all the endpoints.

# Add new record
curl -X GET http://localhost:8080/store?id=1&name=Paul

# Query a record
curl -X GET http://localhost:8080/query?name=Paul

# Query all
curl -X GET http://localhost:8080/query-all
```