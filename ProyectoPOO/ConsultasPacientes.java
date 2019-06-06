import java.util.*;
public class ConsultasPacientes {  
    
    operArchPaciente archPacientes;
    ArrayList<Paciente> pacientes;
    
    public ConsultasPacientes(){
        this.archPacientes = new operArchPaciente("pacientes.txt");
        this.archPacientes.Abrir("r");
        int numPacientes = this.archPacientes.numReg();
        this.pacientes = new ArrayList<Paciente>();
        for(int i = 0; i < numPacientes; i++)
            this.pacientes.add(this.archPacientes.Leer(i));
    }
    
    public ArrayList<Paciente> getPacientes(){
        return this.pacientes;
    }
    
    public Paciente getPaciente(String nomPaciente){
        String nom;
        for (Paciente paciente : this.pacientes) {
            nom = paciente.getNombre();
            if (nom.equals(nomPaciente))
                return paciente;
        }
        return null;
    }

    public int Total() {
        return pacientes.size();
    }

    public boolean Existe(String nomPaciente){
        String nom;
        for (Paciente Paciente : this.pacientes){
            nom = Paciente.getNombre();
            if (nom.equals(nomPaciente))
                return true;
        }
        return false;
    }

    public void Nombres(){
        for (Paciente Paciente : this.pacientes)
            System.out.println(Paciente.getIdPaciente()+" "+Paciente.getNombre());
    }

    public int idPaciente(String nomPaciente){
        String nom;
        for (Paciente Paciente : this.pacientes) {
            nom = Paciente.getNombre();
            if (nom.equals(nomPaciente)) 
                return Paciente.getIdPaciente();
        }
        return 0;
    }

    public void Cerrar()
    {
        this.archPacientes.Cerrar();
    }
}