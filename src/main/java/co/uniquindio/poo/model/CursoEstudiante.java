package co.uniquindio.poo.model;

public class CursoEstudiante {
    private  int id_estudiante;
    private  int curso_id;

    public CursoEstudiante(int id_estudiante, int cuso_id) {
        this.id_estudiante = id_estudiante;
        this.cuso_id = cuso_id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getCurso_id() {
        return cuso_id;
    }

    public void setCurso_id(int cuso_id) {
        this.cuso_id = cuso_id;
    }
}
