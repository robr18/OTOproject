package ProyectoPOO;
import java.util.*;

public class Medico{

    Random R=new Random();

    private String nombre;
    private String direccion;
    private String rfc;
    private int edad;
    private int idEmpleado;
    static int tam = 100;

    public Medico()
    {
        this.nombre=" ";
        this.direccion=" ";
        this.rfc=" ";
        this.edad=0;
        this.idEmpleado=0;
    }
    
    public Medico(String n,String d,String r,int e)
    {
        this.nombre=n;
        this.direccion=d;
        this.rfc=r;
        this.edad=e;
        this.idEmpleado = 100 + R.nextInt(900);
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
        return this.idEmpleado;
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
        this.idEmpleado=100 + R.nextInt(900);
    }

    public void putIdMedico(int id) 
    {
        if(id < 100){
            System.out.println("Id invalido");
            this.putIdMedico();
        }else{
            this.idEmpleado = id;
        }

    }

}



