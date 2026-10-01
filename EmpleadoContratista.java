package modelo;

public class EmpleadoContratista extends Empleado {
    private String nombreEmpresa;

    public EmpleadoContratista(int id, String nombre, double salarioBase, String nombreEmpresa) {
        super(id, nombre, salarioBase);
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario(); // Retorna el salarioBase exacto
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + " | Tipo: Contratista | Empresa: " + nombreEmpresa + " | Salario Total: " + calcularSalario();
    }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
}
