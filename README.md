# Examen Práctico: Desarrollo de una Herramienta de Registro de Créditos
Este es un proyecto Java utilizando Maven, desarrollado en NetBeans. Se conecta a una base de datos en Oracle SQL Developer.

## Tecnologías usadas
Java 8
Maven
JavaScript
Chart JS
Thymeleaf
NetBeans
Oracle SQL Developer

## Cómo ejecutar

Clona el repositorio:
git clone https://github.com/VLAngela/PruebaDeltaDataExamen.git
Abre el proyecto con NetBeans:
Configura la conexion a base de datos en la clase /src/main/java/com/AVazquez/PruebaDeltaData/Configuration /DataSourceConfig.java
Ejecuta en en Maven.

## Base de Datos
La base de datos activa en este proyecto se utiliza en Oracle SQL Developer. Asi mismo internamente Se tiene Una tabla con los siguientes campos:

id int, cliente VARCHAR(50), monto REAL, tasa_interes REAL, plazo int, fecha_otorgamiento DATE

Consecuentemente para el uso del apartado de las gráficas implementadas con Chart.Js se consumiron funciones dentro de la base de datos lo cual corresponden a las mosntradas en el documento "FuncionesSQL.txt". Estas son consumidas internamente por los servios de los controladores (Controller y RestController).

## Autor
Angela Monserrat Vazquez Leon. @VLAngela
