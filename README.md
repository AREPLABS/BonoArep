# CRUD-AREP: Sistema de Gestión de Propiedades

## 📌 **Descripción del Proyecto**
CRUD-AREP es una aplicación web que permite la gestión de propiedades inmobiliarias mediante un sistema CRUD (Crear, Leer, Actualizar y Eliminar). La aplicación está desarrollada con **Spring Boot**, **Java**, **MySQL** y un **frontend basado en HTML, CSS y JavaScript**.

## 🚀 **Características Principales**
✅ Creación de nuevas propiedades con detalles como dirección, precio, tamaño y descripción.  
✅ Visualización de la lista de propiedades registradas.  
✅ Actualización de información de una propiedad existente.  
✅ Eliminación de propiedades.  
✅ Interfaz amigable y responsive con Bootstrap.  
✅ API REST desarrollada con Spring Boot.  
✅ Persistencia de datos con MySQL y JPA/Hibernate.  
✅ Contenedorización con Docker para facilitar el despliegue.

## 🏗 **Arquitectura del Proyecto**

📂 **src/main/java/eci/edu/crud**  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `Client.java` - Entidad Cliente.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `Properties.java` - Entidad Propiedad.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `ClientInterface.java` - Interfaz para operaciones CRUD sobre Clientes.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `PropertyInterface.java` - Interfaz para operaciones CRUD sobre Propiedades.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `PropertyController.java` - Controlador REST para gestionar propiedades.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `ControllerApp.java` - Clase principal para el arranque de la aplicación.

📂 **src/main/resources/static**  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `index.html` - Interfaz web de la aplicación.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `script.js` - Lógica frontend para comunicación con la API REST.

📂 **src/test/java/eci/edu/crud**  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `ClientTest.java` - Pruebas unitarias para la entidad Cliente.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `PropertyTest.java` - Pruebas unitarias para la entidad Propiedad.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `PropertyControllerTest.java` - Pruebas para el controlador de propiedades.  

📂 **Docker**  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `Dockerfile` - Archivo para construir la imagen Docker.  
&nbsp;&nbsp;&nbsp;&nbsp;📌 `docker-compose.yml` - Archivo para orquestar los contenedores de la aplicación y la base de datos.

## 🛠 **Tecnologías Utilizadas**
- **Backend:** Spring Boot, Java, JPA/Hibernate.  
- **Base de Datos:** MySQL.  
- **Frontend:** HTML, CSS, Bootstrap, JavaScript.  
- **API REST:** Spring Boot + JSON.  
- **Gestión de Dependencias:** Maven.  
- **Contenedorización:** Docker y Docker Compose.

## 🔧 **Configuración y Despliegue**
### **1️⃣ Clonar el Repositorio**
```bash
git clone https://github.com/usuario/CRUD-AREP.git
cd CRUD-AREP
```

### **2️⃣ Configurar la Base de Datos**
- Crear una base de datos MySQL llamada `crud_db`.
- Modificar `application.properties` en `src/main/resources` con tus credenciales:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
```

### **3️⃣ Construir y Ejecutar con Docker**
```bash
docker-compose up --build
```
Esto iniciará la aplicación junto con la base de datos MySQL en contenedores Docker.

### **4️⃣ Abrir en el Navegador**
La aplicación estará disponible en:  
🔗 `http://localhost:8080/`

## 📸 **Capturas de Pantalla**
(Agregar imágenes de la aplicación en funcionamiento aquí.)

## 📽 **Video de Demostración**
(Agregar enlace a un video donde se muestren las funcionalidades del sistema.)

## 💡 **Mejoras Futuras**
- Implementar autenticación de usuarios.
- Agregar filtros avanzados para búsqueda de propiedades.
- Desplegar la aplicación en AWS utilizando contenedores Docker.

📌 **Autor:** [Tu Nombre]  
📆 **Fecha:** [Año]  
📂 **Repositorio:** [GitHub Link]

