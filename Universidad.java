
package entities;

import java.util.List;


 
public class Universidad {
    private String nombre;
    private String direccion;
    private int fechaFuncdacion;
    private List<Departamento> departamentos;
    private List<Estudiante> estudiantes;

    public Universidad(String nombre, String direccion, int fechaFundacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaFuncdacion = fechaFundacion;
     this.departamentos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    
    public void agregarDepartamento(Departamento dept) {
        this.departamentos.add(dept);
        dept.setUniversidad(this);
    }

 public void eliminarDepartamento(Departamento dept) {
        this.departamentos.remove(dept);
        dept.setUniversidad(null);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }
 
    public String getNombre() { return nombre; }
    public List<Departamento> getDepartamentos() { return departamentos; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    
    public void limpiarDepartamentos() {
        this.departamentos.clear(); // Simula la eliminación de la universidad afectando a sus partes compuestas
    }
}
