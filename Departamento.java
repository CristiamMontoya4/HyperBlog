package entities;

import java.util.List;

public class Departamento {
    private String nombre;
    private String oficina;
    private double presupuesto;
    private Universidad universidad;
    private List<Curso> cursos;
    private List<Profesor> profesores;

    public Departamento(String nombre, String oficina, double presupuesto) {
        this.nombre = nombre;
        this.oficina = oficina;
        this.presupuesto = presupuesto;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public void agregarProfesor(Profesor profesor) {
        if (!this.profesores.contains(profesor)) {
            this.profesores.add(profesor);
            profesor.setDepartamento(this);
        }
    }
    
    public void removerProfesor(Profesor profesor) {
        this.profesores.remove(profesor);
        if (profesor.getDepartamento() == this) {
            profesor.setDepartamento(null);
        }
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
        curso.setDepartamento(this);
    }
    public String getNombre() { return nombre; }
    public List<Profesor> getProfesores() { return profesores; }
    public List<Curso> getCursos() { return cursos; }
    
    public void limpiarCursos() {
        this.cursos.clear(); 
    }
}
