package entities;

import java.util.List;

public class Departamento {
    private String nombre;
    private String oficina;
    private float presupuesto;
   // private Universidad universidad;
    private List<Curso> cursos;
    private List<Profesor> profesores;

    public Departamento(String nombre, String oficina, float presupuesto) {
        this.nombre = nombre;
        this.oficina = oficina;
        this.presupuesto = presupuesto;
    }
    
    public void agregarCurso(double codigo, String nombre, int creditos, String horario, Profesor profesor){
        Curso cur1 = new Curso(codigo, nombre, creditos, horario, profesor);
        cursos.add(cur1);
    }
    
    public void agregarProfesor(Profesor profesor){
        profesores.add(profesor);
    }
    
    
}
