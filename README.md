# ApiRest_MicroFront_Microelectrónica (En Desarrollo)

* Microservicio Api Rest para el Micro FrontEnd Microelectrónica implementado con Spring Boot, Spring MVC, Spring Data JPA, SpringFox, Swagger UI, Maven, Lombok, Postman, Log4j, Git, SQLDeveloper, Oracle XE 21c y Otras Tecnologías.
* Para este Microservicio no se implementa la capa de seguridad, es posible realizarlo con Spring Security (visualizar otras Api's Rest en mi perfíl de github).
* Se incluye documentación con Swagger 2 / Spring Fox para cada recurso junto con los códigos de respuesta Http más usados. Además se agrega doc junto con validaciones para cada Bean.
* Los Objetos de Búsqueda se trabajan como paginados, incluyendo algunos de tipo CRUD. Se implementa manejos de Excepciones con clases específicas para su control.
* Entre Otros.

</br>

* Repositorio App_MicroFront_Microelectronica_React_Oracle : https://github.com/andresWeitzel/App_MicroFront_Microelectronica_React_Oracle
* Repositorio db_microElectronica : https://github.com/andresWeitzel/db_microElectronica_OracleXE
* PlayList Api Rest : https://www.youtube.com/playlist?list=PLCl11UFjHurDnmm7zqPOgpPu0fAuOHa9S



</br>

## EndPoint y Recursos. Vista Swagger UI

### EndPoint
* http://localhost:8096/api/v1/componentes/

* Algunos de los recursos del endpoint se muestran en las siguientes imágenes.

</br>

</hr>

</br>

### Tecnologías Implementadas

| **Tecnologías** | **Versión** | **Finalidad** |               
| ------------- | ------------- | ------------- |
| Java |   12.0.2 | JDK |
| Spring Tool Suite 4 | 4.9.0  | IDE |
| Spring Boot |   2.6.4  | Framework |
| Spring Boot Data JPA  | 2.6.3 | Mapeo de objetos y persistencia en la db |
| Spring Validation  | 2.7 | Anotations para Validaciones |
| Lombok | 1.18.22 | Automatización de Código | 
| SpringFox | 3.0.0 | Documentación de la Api | 
| UI Swagger | 1.6.4 | Visualización y Gestión de la Api | 
| Maven |  4.0.0 | Gestor de Proyectos |
| Oracle XE 21c | 21.4.1 | Sistema de Gestión de Bases de Datos |
| SQL Developer | 21.4.1  | Editor de Base de Datos |
| CMD | 10 | Símbolo del Sistema para linea de comandos | 
| GNU bash / Terminal | 4.4.23  | Bash / Terminal para el manejo e implementación de Git integrado al Spring Tool Suite |
| Git | 2.29.1  | Control de Versiones |


</br>

### Descarga y Documentacion de las Tecnologías Implementadas

| **Tecnología**  | **Descarga** | **Documentación** |               
| ------------- | ------------- | ------------- |
| Java-JDK 12 | https://www.oracle.com/java/technologies/javase/jdk12-archive-downloads.html |  https://docs.oracle.com/en/ |
| Spring Tool Suite 4 |https://spring.io/tools | https://spring.io/guides |
| Lombok | https://projectlombok.org/download | https://projectlombok.org/download |
| Spring Fox |https://open-ui.org/ | https://open-ui.org/ |
| Maven Repository | https://mvnrepository.com/ | https://mvnrepository.com/ | 
| Oracle | https://www.oracle.com/database/technologies/oracle21c-windows-downloads.html | https://www.oracle.com/database/technologies/oracle21c-windows-downloads.html|
| SQL Developer | https://www.oracle.com/tools/downloads/sqldev-downloads.html | https://www.oracle.com/tools/downloads/sqldev-downloads.html |
| Git  | https://git-scm.com/downloads |  https://git-scm.com/docs |

</br>

### Patrones de Diseño Implementados

| **Patrón de Diseño** | **Finalidad** |               
| ------------- | ------------- |
| DAO | Uso de interfaces entre la aplicación y el almacenamiento de datos. |
| MVC | Separación y Representación de los Datos, Manejo de errores, Escalabilidad, etc  |
| DTO | Transferencia de objectos separando la capa de acceso a datos  |
| Dependency Inyection | Uso de funcionalidades requeridas de clases a través de inyección |
| Otros | Otros |


</br>

### Dependencias Implementadas

| **Dependencia Maven**  | **Versión** | **Finalidad** |             
| ------------- | ------------- | ------------- |
| spring-boot-starter-data-jpa | 2.6.7 | Api de JpaRepository para el manejo de métodos | 
| spring-boot-starter-test | 2.6.7 | Para Testing | 
| spring-boot-starter-web | 2.6.7 | Se agrega toda la configuración web automáticamente de Maven a Spring | 
| spring-boot-starter-validation | 2.7.0 | Validación de Annotations |
| spring-boot-devtools | 2.6.7 | Herramientas para el Manejo de Spring Boot | 
| springfox-boot-starter | 3.0.0 | Doc Api |
| springfox-swagger-ui | 3.0.0 | Doc Api |
| spring-boot-starter-data-mongodb | 2.6.7 | Manejo de SpringDataMongoDB con los métodos del Repository y anotations  |
| springdoc-openapi-ui | 1.6.4 | Plantillas para el Front |
| spring-boot-devtools | 2.6.7 | Herramientas para el Manejo de Spring Boot | 
| spring-boot-devtools | 2.6.4 | Herramientas para el Manejo de Spring Boot | 
| ojdbc8 | 21.3.0.0 | Driver para el SGDB Oracle | 
| lombok | 1.18.22 |  Dependencia para la automatización de Código |




