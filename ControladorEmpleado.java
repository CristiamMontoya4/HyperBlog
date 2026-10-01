package controlador;

import modelo.*;
import vista.VistaControlador;
import java.util.ArrayList;

public class ControladorEmpleado {
    private ArrayList<Empleado> listaEmpleados;
    private VistaControlador vista;

    public ControladorEmpleado() {
        this.listaEmpleados = new ArrayList<>();
        this.vista = new VistaControlador();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    agregarEmpleadoFijo();
                    break;
                case 2:
                    agregarEmpleadoPorHoras();
                    break;
                case 3:
                    agregarEmpleadoContratista();
                    break;
                case 4:
                    mostrarEmpleados();
                    break;
                case 5:
                    calcularNominaTotal();
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void agregarEmpleadoFijo() {
        vista.mostrarMensaje("\n--- Registrar Empleado Fijo ---");
        int id = vista.leerEntero("Ingrese ID: ");
        String nombre = vista.leerTexto("Ingrese Nombre: ");
        double salarioBase = vista.leerDouble("Ingrese Salario Base: ");
        double bonificacion = vista.leerDouble("Ingrese Bonificación: ");

        Empleado emp = new EmpleadoFijo(id, nombre, salarioBase, bonificacion);
        listaEmpleados.add(emp);
        vista.mostrarMensaje("¡Empleado fijo agregado exitosamente!");
    }

    private void agregarEmpleadoPorHoras() {
        vista.mostrarMensaje("\n--- Registrar Empleado por Horas ---");
        int id = vista.leerEntero("Ingrese ID: ");
        String nombre = vista.leerTexto("Ingrese Nombre: ");
        double salarioBase = vista.leerDouble("Ingrese Salario Base: ");
        int horas = vista.leerEntero("Ingrese Horas Trabajadas: ");
        double valorHora = vista.leerDouble("Ingrese Valor por Hora: ");

        Empleado emp = new EmpleadoPorHoras(id, nombre, salarioBase, horas, valorHora);
        listaEmpleados.add(emp);
        vista.mostrarMensaje("¡Empleado por horas agregado exitosamente!");
    }

    private void agregarEmpleadoContratista() {
        vista.mostrarMensaje("\n--- Registrar Empleado Contratista ---");
        int id = vista.leerEntero("Ingrese ID: ");
        String nombre = vista.leerTexto("Ingrese Nombre: ");
        double salarioBase = vista.leerDouble("Ingrese Salario Base: ");
        String empresa = vista.leerTexto("Ingrese Nombre de la Empresa: ");

        Empleado emp = new EmpleadoContratista(id, nombre, salarioBase, empresa);
        listaEmpleados.add(emp);
        vista.mostrarMensaje("¡Empleado contratista agregado exitosamente!");
    }

    private void mostrarEmpleados() {
        vista.mostrarMensaje("\n--- Lista de Empleados ---");
        if (listaEmpleados.isEmpty()) {
            vista.mostrarMensaje("No hay empleados registrados.");
            return;
        }
        for (Empleado emp : listaEmpleados) {
            vista.mostrarMensaje(emp.mostrarDetalles());
        }
    }

    private void calcularNominaTotal() {
        double total = 0;
        for (Empleado emp : listaEmpleados) {
            total += emp.calcularSalario();
        }
        vista.mostrarMensaje("\nEl total de la nómina es: " + total);
    }
    }
