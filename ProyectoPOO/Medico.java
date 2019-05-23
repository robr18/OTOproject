package ProyectoPOO;
import java.util.*;

public class Medico{

    private String nombre;
    private String direccion;
    private String rfc;
    private int edad;
    private int idEmpleado;
    int tam;

    public Medico()
    {
        nombre=" ";
        direccion=" ";
        rfc=" ";
        edad=0;
        idEmpleado=0;
    }
    
    public Medico(String n,String d,String r,int e)
    {
        nombre=n;
        direccion=d;
        rfc=r;
        edad=e;
    }

    public String getName()
    {
        return nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getRfc()
    {
        return rfc;
    }

    public int edad()
    {
        return edad;
    }

    public int getIde()
    {
        return idEmpleado;
    }

    public void putName(String n)
    {
        nombre=n;
    }

    public void putDireccion(String d)
    {
        direccion=d;
    }

    public void putRfc(String r)
    {
        rfc=r;
    }

    public void putEdad(int n)
    {
        edad=n;
    }

    public void putIde()
    {
        Random R=new Random();
        idEmpleado=R.nextInt(100);
    }

}



