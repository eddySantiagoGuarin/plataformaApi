package co.uniquindio.poo.Repository;

import co.uniquindio.poo.bd.Conexion;
import co.uniquindio.poo.model.Curso;
import co.uniquindio.poo.model.CursoEstudiante;
import co.uniquindio.poo.model.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoEstudianteRepository {

    public void insertarEstudiante(Estudiante estudiante , Curso curso){

        String sql ="INSERT INTO curso_estudiante (id_estudiante,curso_id) values(?,?)";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , estudiante.getId_estudiante());
            preparedStatement.setInt(2 ,curso.getId_curso());
            preparedStatement.executeUpdate();


            System.out.println("inscripcion realizada Correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Estudiante> listarEstudiantesXCurso(Curso curso){

        String sql = "SELECT e.id_estudiante, e.nombre, e.email FROM curso_estudiante ce JOIN estudiante e ON e.id_estudiante = ce.id_estudiante WHERE ce.curso_id = ?";
        List<Estudiante> cursoEstudiantes =new ArrayList<>();

        try(Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,curso.getId_curso());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante(
                resultSet.getInt("id_estudiante"),
                resultSet.getString("nombre"),
                resultSet.getString("email"));

                cursoEstudiantes.add(estudiante);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cursoEstudiantes;
    }

    public List<Curso> ConsultarCursosEstudiante(Estudiante estudiante){
        String sql = "SELECT c.id_curso, c.titulo, c.descripcion, c.id_categoria_fk  curso_estudiante ce JOIN curso c ON c.id_curso = ce.curso_id WHERE ce.id_estudiante = ?";

        List<Curso> cursosEstudiante = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,estudiante.getId_estudiante());

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Curso curso = new Curso(
                        resultSet.getInt("id_curso"),
                        resultSet.getString("titulo"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("id_categoria_fk")
                );

                cursosEstudiante.add(curso);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cursosEstudiante;
    }

    public void actualizarCursoEstudiante(CursoEstudiante cursoEstudiante){
        String sql = "UPDATE curso_estudiante curso_id = ? WHERE id_estudiante = ? AND curso_id = ?";

        try (Connection connection = Conexion.getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , cursoEstudiante.getId_estudiante());
            preparedStatement.setInt(2,cursoEstudiante.getCurso_id());
            preparedStatement.executeUpdate();
            System.out.println("inscripcion actualizado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void eliminarCursoEstudiante(Estudiante estudiante){
        String sql = "DELETE FROM curso_estudiante WHERE id_estudiante=? AND curso_id";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,estudiante.getId_estudiante());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
