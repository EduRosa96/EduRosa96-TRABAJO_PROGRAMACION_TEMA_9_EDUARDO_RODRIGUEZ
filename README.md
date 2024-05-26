# EJERCICIO DE BASE DE DATOS PARA JAVA

Este proyecto es un ejemplo de aplicación en Java que interactúa con una base de datos MySQL para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) en una tabla `usuarios`.

## Tabla de Contenidos

- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Requisitos

- Java 8 o superior
- MySQL 5.7 o superior
- Conector JDBC para MySQL (MySQL Connector/J)

## Instalación

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/tu_usuario/EjemploBBDD.git
    cd EjemploBBDD
    ```

2. **Configura la base de datos MySQL:**

    - Crea una base de datos llamada `mibasedatos` (o ajusta el nombre en el archivo `Conexion.java`).
    - Asegúrate de que MySQL esté ejecutándose en el puerto 3307 (o ajusta el puerto en el archivo `Conexion.java`).

    ```sql
    CREATE DATABASE mibasedatos;
    ```

3. **Configura las credenciales de MySQL:**

    - Asegúrate de que el archivo `Conexion.java` tiene las credenciales correctas para conectarse a tu base de datos MySQL.
    - Las credenciales predeterminadas son:
        - Usuario: `root`
        - Contraseña: `1234`

    ```java
    private static final String URL = "jdbc:mysql://localhost:3307/mibasedatos?allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";
    ```

4. **Compila y ejecuta el programa:**

    ```bash
    javac -d bin -sourcepath src src/EjemploBBDD/Main.java
    java -cp bin EjemploBBDD.Main
    ```

## Uso

1. **Crear la base de datos:**

   El programa te pedirá que confirmes si deseas crear la base de datos de usuarios.

2. **Operaciones CRUD:**

    - Crear un usuario: Proporciona el DNI, nombre y país.
    - Modificar un usuario: Proporciona el DNI del usuario a modificar y los nuevos valores para nombre y país.
    - Borrar un usuario: Proporciona el DNI del usuario a borrar.
    - Obtener usuarios por país: Proporciona el nombre del país para listar los usuarios.

3. **Salir:**

   Selecciona la opción 6 para salir del programa.

## Estructura del Proyecto

```plaintext
EjemploBBDD/
├── src/
│   ├── EjemploBBDD/
│   │   ├── Conexion.java
│   │   ├── ConexionesBaseDatos.java
│   │   ├── Usuario.java
│   │   ├── Main.java
├── README.md
