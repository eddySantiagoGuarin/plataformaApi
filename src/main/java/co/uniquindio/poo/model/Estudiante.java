package co.uniquindio.poo.model;

public class Estudiante {

    private int id_estudiante ;
    private int documento ;
    private String nombre ;
    private String  email ;

    public Estudiante(int id_estudiante, int documento, String nombre, String email) {
        this.id_estudiante = id_estudiante;
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
    }

    public Estudiante(int documento, String nombre, String email) {
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
