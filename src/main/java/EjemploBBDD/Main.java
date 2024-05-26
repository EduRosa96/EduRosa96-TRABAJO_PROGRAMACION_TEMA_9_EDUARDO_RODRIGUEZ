package EjemploBBDD;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Scanner scanner = new Scanner(System.in);
        conexion.crearBaseDatos();

        while (true) {
            System.out.println("1. Crear base de datos");
            System.out.println("2. Crear usuario");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Borrar usuario");
            System.out.println("5. Obtener usuarios por pais");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Quieres crear la baase de datos de usuarios? (S/N): ");
                    if (scanner.next().equalsIgnoreCase("N")) {
                        break;
                    } else if (scanner.next().equalsIgnoreCase("S") && !conexion.crearBaseDatos().equals("Base de datos creada")) {
                        System.out.println("La base de datos ya existe");
                    } else {
                        System.out.println(conexion.crearBaseDatos());
                        System.out.println("Base de datos creada");
                    }
                    break;

                case 2:
                    System.out.print("Introduce el DNI del usuario: ");
                    String dni = scanner.next();
                    System.out.print("Introduce el nombre del usuario: ");
                    String nombre = scanner.next();
                    System.out.print("Introduce el país del usuario: ");
                    String pais = scanner.next();
                    conexion.insertarUsuario(dni, nombre, pais);
                    break;

                case 3:
                    System.out.print("Introduce el DNI del usuario a modificar: ");
                    String dniModificar = scanner.next();
                    System.out.print("Introduce el nuevo nombre del usuario: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Introduce el nuevo país del usuario: ");
                    String nuevoPais = scanner.next();
                    conexion.modificarUsuario(dniModificar, nuevoNombre, nuevoPais);
                    break;

                case 4:
                    System.out.print("Introduce el DNI del usuario a borrar: ");
                    String dniBorrar = scanner.next();
                    conexion.borrarUsuario(dniBorrar);
                    break;

                case 5:
                    System.out.println("Introduce el país para obtener los usuarios: ");
                    String paisObtener = scanner.next();
                    System.out.println("Listado de usuarios: \n" + conexion.obtenerUsuariosPorPais(paisObtener));
                    break;

                case 6:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
