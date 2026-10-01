package vista;

import java.util.Scanner;

public class VistaControlador {
    private Scanner scanner;

    public VistaControlador() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nSistema gestión empleados");
        System.out.println("1. Agregar empleado fijo");
        System.out.println("2. Agregar empleado por hora");
        System.out.println("3. Agregar empleado contratista");
        System.out.println("4. Mostrar todos los empleados");
        System.out.println("5. Calcular la nómina");
        System.out.println("6. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
            }
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número decimal válido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
