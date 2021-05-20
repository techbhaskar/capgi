# Task#1 - Read CSV File and store in mysql database


## Run application

Please update these details in application.properties

spring.datasource.url= jdbc:mysql://localhost:3306/{database-goes-here}?useSSL=false

spring.datasource.username= {username-goes-here}

spring.datasource.password= {password-goes-here}

after, use below command to run the application
```
mvn spring-boot:run
```

### After running application

http://localhost:8080/ - [upload a CSV File](http://localhost:8080/)

http://localhost:8080/api/csv/tutorials - [get List of items in table](http://localhost:8080/api/csv/tutorials)


# Task#2 - List of folder after reading from xml file

## Run as Java Program

```
java com.capgi.spring.files.csv.helper.ListFolders
```