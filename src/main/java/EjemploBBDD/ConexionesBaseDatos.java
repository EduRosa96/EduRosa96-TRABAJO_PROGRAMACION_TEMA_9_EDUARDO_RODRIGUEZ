package EjemploBBDD;

import java.sql.Connection;
import java.util.ArrayList;

public interface ConexionesBaseDatos {
    public void insertarUsuario(String dni, String nombre, String pais);

    public Connection conectar();

    public void modificarUsuario(String dni, String nuevoNombre, String nuevoPais);

    public void borrarUsuario(String dni);

    public ArrayList<Usuario> obtenerUsuariosPorPais(String pais);

    public String crearBaseDatos();
}
