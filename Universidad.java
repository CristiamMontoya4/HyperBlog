
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
    }
    
    public void agregarDepartamento(String nombre, String oficina, float presupuesto){
        Departamento dep = new Departamento(nombre, oficina, presupuesto);
        departamentos.add(dep);
    }
    
    
}
