package models;

public class Usuario {
    private String nombre;
    private String apellido;
    private String contrasenia;

    public Usuario(String nombre, String apellido, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }
    public Usuario(){}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
