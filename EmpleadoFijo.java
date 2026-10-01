package modelo;

public class EmpleadoFijo extends Empleado {
    private double bonificacion;

    public EmpleadoFijo(int id, String nombre, double salarioBase, double bonificacion) {
        super(id, nombre, salarioBase);
        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + this.bonificacion;
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + " | Tipo: Fijo | Bonificación: " + bonificacion + " | Salario Total: " + calcularSalario();
    }

    public double getBonificacion() { return bonificacion; }
    public void setBonificacion(double bonificacion) { this.bonificacion = bonificacion; }
}
