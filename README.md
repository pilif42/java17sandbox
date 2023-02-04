# To build
mvn clean install

# To run the application
## Cmd Line
mvn spring-boot:run

## IntelliJ
Right-click on DemoApplication.
Choose Run 'DemoApplication.main()'

# To test
http://localhost:8080

# TODO
Add a health check endpoint displaying the GitHub tag
Add some mapping DTO <-> model objects: https://www.baeldung.com/java-performance-mapping-frameworks
Add HATEOAS
Go through https://www.baeldung.com/java-17-new-features
