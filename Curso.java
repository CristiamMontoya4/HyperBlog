package entities;

import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;
    private String horario;
    private Departamento departamento;
    private Profesor profesor;
    private List<Estudiante> estudiantesMatriculados;

    public Curso(String codigo, String nombre, int creditos, String horario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horario = horario;
        this.estudiantesMatriculados = new ArrayList<>();
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void matricularEstudiante(Estudiante estudiante) {
        if (!this.estudiantesMatriculados.contains(estudiante)) {
            this.estudiantesMatriculados.add(estudiante);
            estudiante.get２Cursos().add(this); // Nota: asegúrate del nombre del método en Estudiante
        }
    }
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public Profesor getProfesor() { return profesor; }
    public List<Estudiante> getEstudiantesMatriculados() { return estudiantesMatriculados; }
    
    
}

