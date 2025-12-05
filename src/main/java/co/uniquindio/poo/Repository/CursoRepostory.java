package co.uniquindio.poo.Repository;

import co.uniquindio.poo.bd.Conexion;
import co.uniquindio.poo.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoRepostory {

    public void insertarCurso(Curso curso){

        String sql ="INSERT INTO curso (titulo,descripcion,id_categoria_fk) values(?,?,?)";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1 , curso.getTitulo());
            preparedStatement.setString(2 , curso.getDescripcion());
            preparedStatement.setInt(3 , curso.getId_categoria_fk());
            preparedStatement.executeUpdate();

            System.out.println("Curso insertado Correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Curso> listarCurso(){

        String sql = "SELECT * FROM  curso" ;
        List<Curso> cursos =new ArrayList<>();

        try(Connection connection = Conexion.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                cursos.add(new Curso(
                        resultSet.getInt("id_curso"),
                        resultSet.getString("titulo"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("id_categoria_fk")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cursos;
    }

    public Curso ConsultarCurso(int id){
        String sql = "SELECT * FROM curso WHERE id_curso=?";
        Curso curso = null;
        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                curso=(new Curso(
                        resultSet.getInt("id_curso"),
                        resultSet.getString("titulo"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("id_categoria_fk")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return curso;
    }

    public void actualizarCurso(Curso curso){
        String sql = "UPDATE curso SET titulo=?,descripcion=?,id_categoria_fk=? WHERE=id_curso";

        try (Connection connection = Conexion.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , curso.getTitulo());
            preparedStatement.setString(2 , curso.getDescripcion());
            preparedStatement.setInt(3 , curso.getId_categoria_fk());
            preparedStatement.setInt(4,curso.getId_curso());
            preparedStatement.executeUpdate();
            System.out.println("Curso actualizado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void eliminarCurso(Curso curso){
        String sql = "DELETE FROM curso WHERE id_curso=?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,curso.getId_curso());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
