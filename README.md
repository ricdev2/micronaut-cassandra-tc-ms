# Microservice - Micronaut, Cassandra & TestContainers

This project expose an API Rest about locations of Department Stores in New York.

## Getting Started

This project run on docker containers, also use a page web to show the locations using google maps so that will need
get a API key from Google Maps Platform website.

### Prerequisites
  
Technologies:

```
- Java JDK8
- Maven 3.5
- Docker 2.0.0.3 (mac)
- Node 8.10.0
- Angular 7.1.4
```

### Installing

For run the application use the next command:

```
$ ./start.sh
```

For stop

```
$ ./stop.sh
```


Make sure that you have install all the prerequisites and up.

### Running the tests

This project use [Testcontainers](https://www.testcontainers.org) for start a database of cassandra and run a set of tests.

```
$ mvn clean test
```

### Break down into end to end tests

All the test are required for check the correct interactivity with the database. Testcontainers is a java library that support JUnit test, 
have many images to use.

## Deployment

For deploy this services it needs have an api key from [Google Maps Platform](https://developers.google.com/maps/documentation/embed/get-api-key)
and add to `app.module.ts` file in project (ag-dashboard-cli).

```angularjs
...

  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({apiKey : 'HERE_YOUR_API_KEY'})
  ],
...

```

The run the shell to start `./start.sh`

## Versioning

For the versions available, see the [tags on this repository](https://github.com/ricdev2/micronaut-cassandra-tc-ms/tags). 

## Authors

* **Ricardo Lopez** - [GitHub Account](https://github.com/ricdev2)
