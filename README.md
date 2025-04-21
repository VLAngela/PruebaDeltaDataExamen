# Examen Práctico: Desarrollo de una Herramienta de Registro de Créditos

Este es un proyecto Java utilizando Maven, desarrollado en NetBeans. Se conecta a una base de datos en Oracle SQL Developer.

## Tecnologías usadas

- Java 8
- Maven
- JavaScript
- Chart JS
- Thymeleaf
- NetBeans
- Oracle SQL Developer

## Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/VLAngela/PruebaDeltaData.git

2. Abre el proyecto con NetBeans:
3. Configura la conexion a base de datos en la clase /src/main/java/com/AVazquez/PruebaDeltaData/Configuration
  /DataSourceConfig.java
4. Ejecuta en en Maven.

## Base de Datos 

La base de datos activa en este proyecto se utiliza en Oracle SQL Feveloper. 
Asi mismo internamente Se tiene Una tabla con los siguientes campos:

id int,
cliente VARCHAR(50),
monto REAL,
tasa_interes REAL,
plazo int,
fecha_otorgamiento DATE 

## Autor

Angela Monserrat Vazquez Leon. @VLAngela

