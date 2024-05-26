package EjemploBBDD;

public class Usuario {
    private String dni;
    private String nombre;
    private String pais;

    public Usuario(String dni, String nombre, String pais) {
        this.dni = dni;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}' + '\n';
    }
}
