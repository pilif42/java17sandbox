# To build
mvn clean install

# To run the application
## Cmd Line
mvn spring-boot:run

## IntelliJ
Right-click on DemoApplication.
Choose Run 'DemoApplication.main()'

# To test
## Browser
http://localhost:8080

## Curl
curl localhost:8080
curl localhost:8080/actuator/health

# TODO
Get HelloControllerIT included on a cmd line build with a flag so we can easily decide if we want to run these IT tests
Add a health check endpoint displaying the GitHub tag: https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#actuator.endpoints
Add some mapping DTO <-> model objects: https://www.baeldung.com/java-performance-mapping-frameworks
Add HATEOAS
Go through https://www.baeldung.com/java-17-new-features
