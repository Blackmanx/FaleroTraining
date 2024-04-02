Falero Training

Run:

```
./mvnw spring-boot:run


```

Then go to [localhost:portassigned (default 8085)](localhost:8085)

### Using your own database:

Modify `application.properties:`

```
spring.datasource.url=your jdbc database url
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driverClassName= Whichever driver you use for your SQL database
spring.jpa.properties.hibernate.dialect = Hibernate driver
server.port= Whichever port you want the app to run with. Default 8080, although current configuration uses 8085

```
