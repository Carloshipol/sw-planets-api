## Configuration Database

To configure the database, create a copy of the `application-example.properties` file and rename it to `application.properties`. Replacing placeholder values ​​with actual data:

```bash
cp application-example.properties application.properties
```
In the application.properties file, update the following variables with your local settings:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```