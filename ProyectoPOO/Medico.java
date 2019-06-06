import java.util.*;
public class Medico{

    Random R=new Random();

    private String nombre;
    private String direccion;
    private String rfc;
    private int edad;
    private int idMedico;
    private int idArea;
    private boolean borrado;
    static int tam = 100;

    public Medico()
    {
        this.nombre=" ";
        this.direccion=" ";
        this.rfc=" ";
        this.edad=0;
        this.borrado=false;
        this.idMedico=0;
        this.idArea=0;
    }
    
    public Medico(String n,String d,String r,int e,String nomarea)    {
        ConsultasAreas consultaArea =  new ConsultasAreas();
        Area objArea = consultaArea.getArea(nomarea);
        this.nombre=n;
        this.direccion=d;
        this.rfc=r;
        this.edad=e;
        this.borrado=false;
        this.idMedico = 1000 + R.nextInt(9000);
        this.idArea = objArea.idArea;
        consultaArea.Cerrar();
    }
    
    public boolean Eliminado()
	{
		return this.borrado;
	}
    
    public void Eliminar(boolean e)
    {
    	this.borrado=e;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public String getRFC()
    {
        return this.rfc;
    }

    public int getEdad()
    {
        return this.edad;
    }

    public int getIdMedico()
    {
        return this.idMedico;
    }

    public int getIdArea()
    {
        return this.idArea;
    }

    public void putNombre(String n)
    {
        this.nombre=n;
    }

    public void putDireccion(String d)
    {
        this.direccion=d;
    }

    public void putRFC(String r)
    {
        this.rfc=r;
    }

    public void putEdad(int n)
    {
        this.edad=n;
    }

    public void putIdMedico()
    {
        int id = 1000 + R.nextInt(9000);
        this.idMedico = id;
        System.out.println("Nuevo id: "+id);
    }

    public void putIdMedico(int id) 
    {
        if(id < 1000){
            System.out.println("Id invalido");
            this.putIdMedico();
        }else
            this.idMedico = id;
    }

    public void putIdArea(int id){
        this.idArea = id;
    }
    
    public String toString()
    {
    	return this.idMedico+" - "+this.nombre+" - "+this.idArea; 
    }
}



