package entities;

import java.util.List;

public class Profesor {
    private double id;
    private String nombre;
    private String especialidad;
    private double salario;
    private Departamento departamento; 
    private List<Curso> cursosImpartidos;

    public Profesor(String nombre, String id, String especialidad, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.especialidad = especialidad;
        this.salario = salario;
        this.cursosImpartidos = new ArrayList<>();
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
 }
