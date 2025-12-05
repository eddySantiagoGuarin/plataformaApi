package co.uniquindio.poo.Repository;


import co.uniquindio.poo.bd.Conexion;
import co.uniquindio.poo.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {

    public void insertarCategoria(Categoria categoria){

        String sql ="INSERT INTO categoria (nombre) values(?)";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , categoria.getNombre());
            preparedStatement.executeUpdate();

            System.out.println("Categoria insertada Correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Categoria> listarCategorias(){

        String sql = "SELECT * FROM  categoria" ;
        List<Categoria> categorias =new ArrayList<>();

        try(Connection connection = Conexion.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                categorias.add(new Categoria(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categorias;
    }

    public Categoria ConsultarCategoria(int id){
        String sql = "SELECT * FROM categoria WHERE id=?";
        Categoria categoria = null;
        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                categoria= new Categoria(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return categoria;
    }

    public void actualizarCategoria(Categoria categoria){
        String sql = "UPDATE categoria SET nombre=? WHERE=id_categoria";

        try (Connection connection = Conexion.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,categoria.getNombre());
            preparedStatement.setInt(2,categoria.getId_categoria());
            preparedStatement.executeUpdate();
            System.out.println("Categoria actualizada con exito");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void eliminarCategoria(Categoria categoria){
        String sql = "DELETE FROM categoria WHERE id=?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,categoria.getId_categoria());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
