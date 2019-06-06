import java.util.*;
public class ConsultasAreas {  
    
    operArchArea archAreas;
    ArrayList<Area> areas;
    
    public ConsultasAreas(){
        this.archAreas = new operArchArea("areas.txt");
        this.archAreas.Abrir("r");
        int numAreas = this.archAreas.numReg();
        this.areas = new ArrayList<Area>();
        for(int i = 1; i < numAreas; i++)
            this.areas.add(this.archAreas.Leer(i));
    }
    
    public ArrayList<Area> getAreas(){
        return this.areas;
    }
    
    public Area getArea(String nomArea){
        String nom;
        for (Area area : this.areas) {
            nom = area.getNombreArea();
            if (nom.equals(nomArea))
                return area;
        }
        return null;
    }

    public int getIdArea(String nomArea){
        String nom;
        for (Area area : this.areas) {
            nom = area.getNombreArea();
            if (nom.equals(nomArea))
                return area.getIdArea();
        }
        return -1;
    }

    public int Total() {
        return this.areas.size();
    }

    public boolean Existe(String nomArea){
        String nom;
        for (Area area : this.areas) {
            nom = area.getNombreArea();
            if (nomArea.equals(nom))
                return true;
        }
        return false;
    }

    public void Cerrar()
    {
        this.archAreas.Cerrar();
    }
    public static void main(String[] args) {
        ConsultasAreas objConsultas = new ConsultasAreas();
        for (Area area : objConsultas.getAreas()) {
            System.out.println(area);
        }
    }
}