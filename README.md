# caterwings-project

to build and run the project, perform the following steps:
  1- `mvn clean package`
  2- `mvn tomcat7:deploy` to deploy to tomcat server. the tomcat server configuration can be provided in the root `pom.xml` file.
  the following configuration is set by default:
  ```<plugin>
                    <groupId>org.apache.tomcat.maven</groupId>
                    <artifactId>tomcat7-maven-plugin</artifactId>
                    <version>2.2</version>
                    <configuration>
                        <url>http://localhost:8080/manager/text</url>
                        <server>tomcat</server>
                        <username>admin</username>
                        <password>admin</password>
                        <path>/${project.artifactId}</path>
                        <update>true</update>
                    </configuration>
                </plugin>```
  3- after deployment, the following url pattern can be used to run the rest service:
  `http://localhost:8080/rest-service/rest/product/read/{title}` to read by title name.(GET REQUEST)
  `http://localhost:8080/rest-service/rest/product/read-all` to read all products.(GET REQUEST)
  `http://localhost:8080/rest-service/rest/product/delete/{id}` to delete product by id.(GET REQUEST)
  `http://localhost:8080/rest-service/rest/product/create` to create product. it takes parameter in the request body. (PUT REQUEST)
   `http://localhost:8080/rest-service/rest/product/update` to update product. it takes parameter in the request body. (POST REQUEST)
