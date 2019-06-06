import java.util.*;
public class ConsultasMedicos {  
    
    operArchMedico archMedicos;
    ArrayList<Medico> medicos;
    
    public ConsultasMedicos(){
        this.archMedicos = new operArchMedico("medicos.txt");
        this.archMedicos.Abrir("r");
        int numMedicos = this.archMedicos.numReg();
        this.medicos = new ArrayList<Medico>();
        for(int i = 1; i < numMedicos; i++)
            this.medicos.add(this.archMedicos.Leer(i));
    }
    
    public ArrayList<Medico> getMedicos(){
        return this.medicos;
    }
    
    public Medico getMedico(String nomMedico){
        String nom;
        for (Medico medico : this.medicos) {
            nom = medico.getNombre();
            if (nom.equals(nomMedico))
                return medico;
        }
        return null;
    }

    public int Total() {
        System.out.println("Numero de Medicos: "+ medicos.size());
        return medicos.size();
    }

    public boolean Existe(String nomMedico){
        String nom;
        for (Medico medico : this.medicos){
            nom = medico.getNombre();
            if (nom.equals(nomMedico))
                return true;
        }
        return false;
    }

    public void Nombres(){
        for (Medico medico : this.medicos)
            System.out.println(medico.getIdMedico()+" "+medico.getNombre());
    }

    public void Cerrar()
    {
        this.archMedicos.Cerrar();
    }

    public static void main(String[] args) {
        ConsultasMedicos objConsultasMedico = new ConsultasMedicos();
        for (Medico medico : objConsultasMedico.getMedicos()) {
            System.out.println(medico);
        } 
    }
}