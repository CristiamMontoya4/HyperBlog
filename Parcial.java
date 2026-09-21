
package parcial;

import entities.Departamento;
import entities.Universidad;

public class Parcial {

    
    public static void main(String[] args) {
        
        Universidad ud = new Universidad("U Distrital", "Cra 8 # 40-70", 1950);
        ud.agregarDepartamento("inge", "admin 202", 500.0f);
        ud.agregarDepartamento("derecho", "admin 203", 200.0f);
        
    }
    
}
