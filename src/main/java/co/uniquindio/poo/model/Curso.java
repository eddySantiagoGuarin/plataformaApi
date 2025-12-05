package co.uniquindio.poo.model;

import java.util.Scanner;

public class Curso {

    private int id_curso ;
    private  String titulo ;
    private String descripcion ;
    private int id_categoria_fk ;

    public Curso(int id_curso, String titulo, String descripcion, int id_categoria_fk) {
        this.id_curso = id_curso;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_categoria_fk = id_categoria_fk;
    }

    public Curso(String titulo, String descripcion, int id_categoria_fk) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_categoria_fk = id_categoria_fk;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria_fk() {
        return id_categoria_fk;
    }

    public void setId_categoria_fk(int id_categoria_fk) {
        this.id_categoria_fk = id_categoria_fk;
    }

    Scanner scanner = new Scanner(System.in);

    /*public Curso CrearCurso(){
        System.out.println("Ingrese el titulo del curso: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese la descripcion del curso: ");
        System descripcion =scanner.nextLine();
        System.out.println("Ingrese le ID de la categoria del curso: ");

    }*/
}
