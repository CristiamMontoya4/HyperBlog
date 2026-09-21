package entities;

import java.util.List;

public class Curso {
    private double codigo;
    private String nombre;
    private int creditos;
    private String horario;
    private Departamento departamento;
    private Profesor profesor;
    private List<Estudiante> estudiantesMatriculados;

    public Curso(double codigo, String nombre, int creditos, String horario, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    public void matricularEstudiante(Estudiante estudiante){
        estudiantesMatriculados.add(estudiante);
    }
    
    
    
}
