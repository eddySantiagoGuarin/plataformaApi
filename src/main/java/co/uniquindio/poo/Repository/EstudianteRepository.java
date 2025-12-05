package co.uniquindio.poo.Repository;

import co.uniquindio.poo.bd.Conexion;
import co.uniquindio.poo.model.Estudiante;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepository {

    public void insertarEstudiante(Estudiante estudiante){

        String sql ="INSERT INTO estudiante (documento,nombre,email) values(?,?,?)";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , estudiante.getDocumento());
            preparedStatement.setString(2 , estudiante.getNombre());
            preparedStatement.setString(3 , estudiante.getEmail());
            preparedStatement.executeUpdate();

            System.out.println("Estudiante insertado Correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Estudiante> listarEstudiantes(){

        String sql = "SELECT * FROM  estudiante" ;
        List<Estudiante> estudiantes =new ArrayList<>();

        try(Connection connection = Conexion.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                estudiantes.add(new Estudiante(
                        resultSet.getInt("id_estudiante"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return estudiantes;
    }

    public Estudiante ConsultarEstudiante(int id){
        String sql = "SELECT * FROM estudiante WHERE id_estudiante=?";
        Estudiante estudiante = null;
        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                estudiante=(new Estudiante(
                        resultSet.getInt("id_estudiante"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return estudiante;
    }

    public void actualizarEstudiate(Estudiante estudiante){
        String sql = "UPDATE estudiante SET documento=?,nombre=?,email=? WHERE=id_estudiante";

        try (Connection connection = Conexion.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , estudiante.getDocumento());
            preparedStatement.setString(2 , estudiante.getNombre());
            preparedStatement.setString(3 , estudiante.getEmail());
            preparedStatement.setInt(4,estudiante.getId_estudiante());
            preparedStatement.executeUpdate();
            System.out.println("Estudiante actualizado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void eliminarEstudiante(Estudiante estudiante){
        String sql = "DELETE FROM estudiante WHERE id_estudiante=?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,estudiante.getId_estudiante());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
