import java.util.ArrayList;

/**
 * ubicacion
 */
public class ubicacion {
    static public int posicion(int id){
        ConsultasAreas objConsultasArea = new ConsultasAreas();
        ArrayList<Area> areas= objConsultasArea.getAreas();
        int cont = 0;
        for (Area area : areas) {
            cont+=1;
            if (id == area.getIdArea()) {
                return cont;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        System.out.println(posicion(7767));
    }
}