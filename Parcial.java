
package parcial;

import entities.Departamento;
import entities.Universidad;
import entities.Profesor;
import entities.Curso;
import entities.Estudiante;

class Vista {
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n[SISTEMA]: " + mensaje);
    }

    public void mostrarInformacionGeneral(Universidad uni) {
        System.out.println("\n========================================");
        System.out.println(" INFORMACIÓN GENERAL DE LA UNIVERSIDAD: " + uni.getNombre());
        System.out.println("=========================================");
        
        for (Departamento d : uni.getDepartamentos()) {
            System.out.println("\nDepartamento: " + d.getNombre() + " (Oficina: " + d.getOficina() + ")");
            System.out.println("  -> Profesores adscritos:");
            for (Profesor p : d.getProfesores()) {
                System.out.println("     - " + p.getNombre() + " (Especialidad: " + p.getEspecialidad() + ")");
            }
            System.out.println("  -> Cursos ofrecidos:");
            for (Curso c : d.getCursos()) {
                String profesorAsignado = (c.getProfesor() != null) ? c.getProfesor().getNombre() : "Sin asignar";
                System.out.println("     - [" + c.getCodeOrCodigo() + "] " + c.getNombre() + " | Profesor: " + profesorAsignado);
                System.out.println("       Estudiantes matriculados: " + c.getEstudiantesMatriculados().size());
            }
        }
        System.out.println("\n========================================\n");
    }
}

class Controlador {
    private Universidad universidad;
    private List<Profesor> profesoresIndependientes;
    private List<Estudiante> estudiantesGlobales;
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.profesoresIndependientes = new ArrayList<>();
        this.estudiantesGlobales = new ArrayList<>();
    }

    public void ejecutarSimulacion() {
        // 11. Cree una universidad.
        universidad = new Universidad("Universidad Distrital", "Cra 7 # 40-53", "1948");
        vista.mostrarMensaje("Se ha creado la universidad: " + universidad.getNombre());

        // 12. Cree 2 departamentos y relaciónelos con la universidad.
        Departamento depSistemas = new Departamento("Ingeniería de Sistemas", "Edificio A", 500000.0);
        Departamento depCiencias = new Departamento("Ciencias Básicas", "Edificio B", 300000.0);
        universidad.agregarDepartamento(depSistemas);
        universidad.agregarDepartamento(depCiencias);
        vista.mostrarMensaje("Se crearon y asociaron 2 departamentos a la universidad.");

        // 13. Cree 3 profesores: 2 asignados a departamentos y 1 profesor independiente.
        Profesor prof1 = new Profesor("Ana Gómez", "P001", "Desarrollo Software", 3500);
        Profesor prof2 = new Profesor("Carlos Ruiz", "P002", "Matemáticas Discretas", 3200);
        Profesor prof3Independiente = new Profesor("Elena Vargas", "P003", "Inteligencia Artificial", 4000);
        
        depSistemas.agregarProfesor(prof1);
        depCiencias.agregarProfesor(prof2);
        // prof3Independiente se queda sin departamento por ahora (profesor independiente)
        profesoresIndependientes.add(prof3Independiente);
        vista.mostrarMensaje("Se crearon 3 profesores (2 en departamentos, 1 independiente).");

        // 14. Cree 4 cursos distribuidos entre los departamentos.
        Curso curso1 = new Curso("IS-101", "Programación Orientada a Objetos", 4, "Lunes 8-10");
        Curso curso2 = new Curso("IS-102", "Estructuras de Datos", 3, "Martes 10-12");
        Curso curso3 = new Curso("CB-201", "Cálculo Diferencial", 4, "Miércoles 7-9");
        Curso curso4 = new Curso("CB-202", "Álgebra Lineal", 3, "Jueves 9-11");

        depSistemas.agregarCurso(curso1);
        depSistemas.agregarCurso(curso2);
        depCiencias.agregarCurso(curso3);
        depCiencias.agregarCurso(curso4);
        vista.mostrarMensaje("Se crearon 4 cursos y se distribuyeron en los departamentos.");

        // 15. Asigne los profesores correspondientes a los cursos.
        curso1.setProfesor(prof1);
        curso2.setProfesor(prof3Independiente); // Un profesor independiente puede dictar cursos
        curso3.setProfesor(prof2);
        curso4.setProfesor(prof2);
        vista.mostrarMensaje("Profesores asignados a los cursos exitosamente.");

        // 16. Cree 5 estudiantes.
        Estudiante est1 = new Estudiante("Juan Pérez", "E001", "Sistemas", 3);
        Estudiante est2 = new Estudiante("María López", "E002", "Sistemas", 3);
        Estudiante est3 = new Estudiante("Andrés Torres", "E003", "Industrial", 2);
        Estudiante est4 = new Estudiante("Laura Díaz", "E004", "Sistemas", 4);
        Estudiante est5 = new Estudiante("David Castro", "E005", "Civil", 1);

        estudiantesGlobales.add(est1);
        estudiantesGlobales.add(est2);
        estudiantesGlobales.add(est3);
        estudiantesGlobales.add(est4);
        estudiantesGlobales.add(est5);

        for(Estudiante e : estudiantesGlobales) {
            universidad.registrarEstudiante(e);
        }
        vista.mostrarMensaje("Se crearon 5 estudiantes vinculados a la universidad.");

        // 17. Matricule los estudiantes en diferentes cursos.
        curso1.matricularEstudiante(est1);
        curso1.matricularEstudiante(est2);
        curso2.matricularEstudiante(est1);
        curso3.matricularEstudiante(est3);
        curso4.matricularEstudiante(est4);
        curso4.matricularEstudiante(est5);
        vista.mostrarMensaje("Estudiantes matriculados en los cursos.");

        // 18. Muestre la información general.
        vista.mostrarInformacionGeneral(universidad);

        // 19. Demuestre qué ocurre con los departamentos cuando se elimina la universidad.
        vista.mostrarMensaje("DEMOSTRACIÓN 19: Eliminando la Universidad...");
        universidad.limpiarDepartamentos();
        universidad = null; // Destrucción del objeto Universidad
        System.out.println("-> Universidad eliminada. Departamentos actuales en la U: " + 
            (universidad == null ? "La Universidad ya no existe, sus departamentos fueron destruidos (Composición)." : ""));

        // 20. Demuestre qué ocurre con los cursos cuando se elimina un departamento.
        vista.mostrarMensaje("DEMOSTRACIÓN 20: Creando un departamento temporal y eliminándolo con sus cursos...");
        Departamento depTemporal = new Departamento("Dep Temporal", "Oficina X", 1000);
        Curso cursoTemp = new Curso("TMP-99", "Curso Temporal", 2, "Viernes");
        depTemporal.agregarCurso(cursoTemp);
        
        System.out.println("Cursos en depTemporal antes de eliminar: " + depTemporal.getCursos().size());
        depTemporal.limpiarCursos(); // Simula destrucción en cascada
        System.out.println("Cursos en depTemporal después de eliminar departamento: " + depTemporal.getCursos().size());

        // 21. Demuestre que el profesor independiente continúa existiendo.
        vista.mostrarMensaje("DEMOSTRACIÓN 21: Verificando profesor independiente.");
        System.out.println("El profesor " + prof3Independiente.getNombre() + 
            " con especialidad en " + prof3Independiente.getEspecialidad() + 
            " sigue existiendo y operando aunque su departamento sea nulo (Departamento actual: " + 
            (prof3Independiente.getDepartamento() == null ? "Ninguno / Independiente" : "Asignado") + ")");

        // 22. Demuestre que los estudiantes continúan existiendo independientemente.
        vista.mostrarMensaje("DEMOSTRACIÓN 22: Verificando persistencia de estudiantes fuera de la universidad.");
        System.out.println("La universidad principal fue eliminada, pero los estudiantes siguen en memoria:");
        for(Estudiante e : estudiantesGlobales) {
            System.out.println(" - Estudiante: " + e.getNombre() + " (Carrera: " + e.getUnicaCarreraOCo() + ") sigue existiendo.");
        }
    }
}


                                         }
public class Parcial {

    
    public static void main(String[] args) {
        
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        
        vista.mostrarMensaje("Iniciando Sistema de Gestión Universitaria...");
        controlador.ejecutarSimulacion();
    }
    
}
