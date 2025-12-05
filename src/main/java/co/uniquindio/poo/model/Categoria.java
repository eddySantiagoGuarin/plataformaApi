package co.uniquindio.poo.model;

import java.util.Scanner;

public class Categoria {

    private int id_categoria;
    private String nombre;

    public Categoria(int id_categoria, String nombre) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    Scanner scanner = new Scanner(System.in);

    public  Categoria CreaCategoria(){
        System.out.print("Ingrese la nueva categoria por favor: ");
        String categoriaText = scanner.nextLine();
        Categoria categoria= new Categoria(categoriaText);
        return categoria;
    }

}
