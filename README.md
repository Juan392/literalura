# 🐉 Literalura 📚  
_Proyecto de consola en Java que consume libros desde la API de Gutendex, los almacena en una base de datos relacional y permite consultar información sobre autores, idiomas y generar resúmenes usando inteligencia artificial._

![Java](https://img.shields.io/badge/Java-17+-red?style=for-the-badge&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?style=for-the-badge&logo=springboot)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)  
![API REST](https://img.shields.io/badge/API-Gutendex-orange?style=for-the-badge)  
![Gemini AI](https://img.shields.io/badge/Gemini%20AI-Resumenes%20inteligentes-purple?style=for-the-badge&logo=google)

---

## 🌟 Descripción

Literalura es una aplicación educativa de consola en Java que te permite:

- Buscar libros mediante [Gutendex](https://gutendex.com/)
- Almacenar libros y autores en una base de datos PostgreSQL (o cualquier otra que configures)
- Consultar libros por idioma o autores por período de vida
- Generar resúmenes con IA usando **Gemini AI**

---

## 📚 Funcionalidades del menú

㊝Este programa te permite:

🐉1 - Agregar un libro.

🐉2 - Mostrar Libros Agregados.

🐉3 - Mostrar Autores Agregados.

🐉4 - Mostrar Autores vivos de determinado tiempo.

🐉5 - Mostrar Libros Por Idioma.

🐉6 - Hacer un resumen sobre un libro.

🐉7 - Salir.


##🚀 Tecnologías utilizadas
☕ Java 17+

⚙ Spring Boot 3.5.3

🗃 Spring Data JPA

🐘 PostgreSQL (puedes cambiarlo por H2, MySQL, etc.)

🌐 API REST: Gutendex

🧠 Gemini AI (resúmenes)

📦 Maven

##⚙️ Instalación y ejecución
1. Clona el repositorio

git clone https://github.com/tu-usuario/literalura.git
cd literalura
3. Configura tu base de datos
Edita el archivo src/main/resources/application.properties:

properties

# Configuración de PostgreSQL (puedes cambiarla más abajo)
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔄 Cambiar la base de datos (por ejemplo, a MySQL o H2)
✅ MySQL
properties

spring.datasource.url=jdbc:mysql://localhost:3306/literalura
spring.datasource.username=root
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
Asegúrate de incluir el driver de MySQL en el pom.xml.

✅ H2 (base de datos en memoria para pruebas)
properties
spring.datasource.url=jdbc:h2:mem:literalura
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.h2.console.enabled=true
3. Ejecuta el proyecto
💻 Con Maven desde la terminal:
bash
./mvnw spring-boot:run
🧠 Desde un IDE como IntelliJ o Eclipse:
Ejecuta la clase LiteraluraApplication.java

🤖 Uso de Gemini AI para resúmenes
La opcion 1 usa Gemini AI (de Google) para traducir las sinopsis/resenia del libro.
La opción 6 del menú genera un resumen de un libro usando Gemini AI (de Google).

📌 Cómo configurarlo:
Ve a Google AI Studio

Crea una clave de API desde:
https://aistudio.google.com/app/apikey

![image](https://github.com/user-attachments/assets/d4c03c18-4ad2-4681-ae25-4b2ee58acaf6)


Guarda tu clave como variable de entorno:

En Linux/macOS:

export GEMINI_API_KEY=tu_clave
En Windows (CMD):

set GEMINI_API_KEY=tu_clave
En el código Java, asegúrate de obtener la clave así:

String apiKey = System.getenv("GEMINI_API_KEY");
Envía el texto a la API usando tu cliente (por ejemplo, usando la librería de Google Generative AI para Java).

🗃️ Estructura del proyecto

![image](https://github.com/user-attachments/assets/9a696a09-f9b3-482a-8a35-a8384d8e22ac)


Seleccione una opción:
1
🔍 Escribe el nombre del libro: The Time Machine

✅ Libro agregado con éxito: The Time Machine (H. G. Wells)
NullPointerException en la API de Gemini O DB
➤ Asegúrate de que la clave de API esté correctamente cargada desde las variables de entorno.

✨ Créditos
Proyecto realizado por Juan Pablo Martínez Reyes
Desarrollado como parte del programa Oracle Next Education (ONE) y cursos de Alura Latam.

📜 Licencia
Este proyecto está bajo la Licencia MIT.
Puedes usarlo, copiarlo y modificarlo libremente con fines educativos o personales.
