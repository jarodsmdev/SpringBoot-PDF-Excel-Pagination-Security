# Proyecto SpringBoot con Thymeleaf, Spring Security y Conectividad con Base de Datos MySQL

Este proyecto es una aplicación web desarrollada utilizando el framework SpringBoot y las tecnologías Thymeleaf, Spring Security y conectividad con bases de datos MySQL. Proporciona una funcionalidad para gestionar una lista de empleados con información detallada, como nombre, apellido, email, fecha y teléfono. Además, cuenta con la capacidad de exportar los datos en formato PDF o Excel a través de un solo botón, lo que permite a los usuarios descargar el archivo y utilizarlo según sus necesidades.

## Características del Proyecto

- Desarrollado utilizando el framework SpringBoot.
- Utiliza Thymeleaf como motor de plantillas para la generación de vistas HTML.
- Implementa Spring Security para la autenticación y autorización de usuarios.
- Conectividad con una base de datos MySQL para almacenar y recuperar información de empleados.
- Permite visualizar una lista de empleados con información detallada, como nombre, apellido, email, fecha y teléfono.
- Exporta los datos de la lista en formato PDF o Excel con un solo clic.
- Descarga el archivo generado para que el usuario pueda utilizarlo según sus necesidades.

## Requisitos de Instalación

Para ejecutar este proyecto en tu máquina local, debes asegurarte de tener instalado lo siguiente:

- Java Development Kit (JDK) versión 8 o superior.
- Maven para gestionar las dependencias del proyecto.
- Un servidor de base de datos MySQL y las credenciales de acceso correspondientes.

## Configuración

Sigue los siguientes pasos para configurar y ejecutar el proyecto en tu entorno local:

1. Clona este repositorio en tu máquina local o descarga el código fuente.
2. Importa el proyecto en tu IDE preferido como un proyecto Maven existente.
3. Abre el archivo de configuración `application.properties` y actualiza las siguientes propiedades con los detalles de tu base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
spring.datasource.username=nombre_usuario
spring.datasource.password=contraseña
```

4. Guarda los cambios y ejecuta la aplicación desde tu IDE o utilizando el siguiente comando Maven:

```bash
mvn spring-boot:run
```

5. La aplicación se ejecutará en `http://localhost:8080`. Abre esta URL en tu navegador web para acceder a la aplicación.

## Uso

Una vez que hayas configurado y ejecutado la aplicación, podrás realizar las siguientes acciones:

- Inicia sesión con tus credenciales de usuario.
- Visualiza la lista de empleados con sus respectivos detalles, como nombre, apellido, email, fecha y teléfono.
- Exporta la lista de empleados a formato PDF o Excel haciendo clic en el botón "Exportar".
- Descarga el archivo generado y úsalo según tus necesidades.

Si tienes un rol de "ADMIN", también tendrás acceso a las siguientes funcionalidades adicionales:

- Edita la información de un empleado existente.
- Elimina un empleado de la lista.

## Credenciales de Usuario

La aplicación viene preconfigurada con dos usuarios y sus respectivos roles:

- Usuario: jarod
  - Contraseña: 12345
  - Rol: USER (Acceso de solo lectura a la lista de empleados)

- Usuario: admin
  - Contraseña: 12345
  - Rol: ADMIN (Acceso completo a la lista de empleados, incluyendo edición y eliminación de empleados)

Puedes utilizar estas credenciales para iniciar sesión y probar las diferentes funcionalidades de acuerdo a los roles asignados.

## Contribución

Si deseas contribuir a este proyecto, puedes seguir los siguientes pasos:

1. Realiza un fork de este repositorio y clónalo en tu máquina local.
2. Crea una nueva rama para realizar tus cambios: `git checkout -b mi-rama`
3. Realiza las modificaciones necesarias y realiza los commits: `git commit -m "Descripción de los cambios"`
4. Envía tus cambios a tu repositorio remoto: `git push origin mi-rama`
5. Abre una solicitud de extracción en este repositorio.

## Soporte

Si necesitas soporte o tienes alguna pregunta relacionada con este proyecto, puedes contactar al equipo de desarrollo a través de los siguientes canales:

- **Correo electrónico**: [lbriones.dev@gmail.com](mailto:lbriones.dev@gmail.com)
- **Página de GitHub**: [https://github.com/jarodsmdev/SpringBoot-PDF-Excel-Pagination-Security](https://github.com/jarodsmdev/SpringBoot-PDF-Excel-Pagination-Security)

No dudes en comunicarte con nosotros si encuentras algún problema, tienes sugerencias o simplemente quieres compartir tus comentarios. ¡Estamos aquí para ayudarte!

---

¡Gracias por utilizar nuestro proyecto! Esperamos que sea útil y cumpla con tus necesidades. Si tienes alguna pregunta adicional, no dudes en contactarnos. ¡Disfruta de la aplicación!
