package EjemploBBDD;

import java.sql.*;
import java.util.ArrayList;

public class Conexion implements ConexionesBaseDatos {
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/mibasedatos?allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";

    public void insertarUsuario(String dni, String nombre, String pais) {
        Connection conexion = null;
        try {
            conexion = conectar();
            PreparedStatement stm = conexion.prepareStatement("INSERT INTO usuarios (DNI, nombre, pais) VALUES (?, ?, ?)");
            stm.setString(1, dni);
            stm.setString(2, nombre);
            stm.setString(3, pais);
            stm.executeUpdate();
            obtenerUsuariosPorPais(pais).add(new Usuario(dni, nombre, pais));

            System.out.println("Usuario creado");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario");
            e.printStackTrace();
        }
    }

    public Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return conexion;
    }

    public void modificarUsuario(String dni, String nuevoNombre, String nuevoPais) {
        Connection conexion = null;
        try {
            conexion = conectar();
            PreparedStatement stm = conexion.prepareStatement("UPDATE usuarios SET nombre = ?, pais = ? WHERE DNI = ?");
            stm.setString(1, nuevoNombre);
            obtenerUsuariosPorPais(nuevoPais).add(new Usuario(dni, nuevoNombre, nuevoPais));
            stm.setString(2, nuevoPais);
            stm.setString(3, dni);
            int numFilas = stm.executeUpdate();
            if (numFilas == 1) {
                System.out.println("Usuario modificado");
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar usuario");
            e.printStackTrace();
        }
    }

    public void borrarUsuario(String dni) {
        Connection conexion = null;
        try {
            conexion = conectar();
            PreparedStatement stm = conexion.prepareStatement("DELETE FROM usuarios WHERE DNI = ?");
            stm.setString(1, dni);
            obtenerUsuariosPorPais(dni).clear();
            int numFilas = stm.executeUpdate();
            if (numFilas == 1) {
                System.out.println("Usuario borrado");
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar usuario");
            e.printStackTrace();
        }
    }


    public String crearBaseDatos() {
        Connection conexion = null;
        Statement statement = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conexion.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (DNI varchar(12) NOT NULL, nombre VARCHAR(45), pais VARCHAR(45), PRIMARY KEY (DNI))");
            return "Base de datos creada";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al crear la base de datos";
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Usuario> obtenerUsuariosPorPais(String pais) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conexion = null;
        try {
            conexion = conectar();
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM usuarios WHERE pais = ?");
            stm.setString(1, pais);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String paisActual = rs.getString("pais");
                Usuario usuario = new Usuario(dni, nombre, paisActual);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuarios por país");
            e.printStackTrace();
        }
        return usuarios;
    }
}

