package entities;


public class Estudiante {
    private String id;
    private String nombre;
    private String carrera;
    private int semestre;
    private List<Curso> cursosMatriculados;

    public Estudiante(String nombre, String id, String carrera, int semestre) {
        this.nombre = nombre;
        this.id = id;
        this.carrera = carrera;
        this.semestre = semestre;
        this.cursosMatriculados = new ArrayList<>();
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
}
