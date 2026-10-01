package modelo;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHoras(int id, String nombre, double salarioBase, int horasTrabajadas, double valorHora) {
        super(id, nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return this.horasTrabajadas * this.valorHora;
    }

    @Override
    public String mostrarDetalles() {
        return "ID: " + id + " | Nombre: " + nombre + " | Horas: " + horasTrabajadas + " | Valor Hora: " + valorHora + " | Salario Total (Horas): " + calcularSalario();
    }

    public int getHorasTrabajadas() { return horasTrabajadas; }
    public void setHorasTrabajadas(int horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }
}
