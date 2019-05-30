package ProyectoPOO;
import java.util.*;

public class Area{

    Random R=new Random();

    private String nombre;
    private String descAct;
    private int piso;
    private String direccion;
    private boolean borrado;
    int idArea;
    static int tam = 100;

    public Area()
    {
        nombre=" ";
        descAct=" ";
        piso=0;
        direccion=" ";
        idArea=0;
    }
    public Area(String n, String desc, int p, String dir)
    {
        nombre=n;
        descAct=desc;
        piso=p;
        direccion=dir;
        idArea= 100 + R.nextInt(900);;
    }
    
    public boolean Eliminado()
   	{
   		return borrado;
   	}
       
    public void Eliminar(boolean e)
    {
    	borrado=e;
    }

    public String getNombreArea()
    {
        return this.nombre;
    }

    public String getDescA()
    {
        return this.descAct;
    }

    public int getPiso()
    {
        return this.piso;
    }

    public String getDireccionA()
    {
        return this.direccion;
    }

    public int getIdArea()
    {
        return this.idArea;
    }

    public void putNombre(String n) 
    {
        this.nombre = n;
    }

    public void putDescAct(String desc) 
    {
        this.descAct = desc;
    }

    public void putPiso(int p) 
    {
        this.piso = p;
    }

    public void putDireccion(String dir) 
    {
        this.direccion = dir;
    }

    public void putIdArea() 
    {
        this.idArea = 100 + R.nextInt(900);
    }

    public void putIdArea(int id) 
    {
        if(id < 100){
            System.out.println("Id invalido");
            this.putIdArea();
        }else{
            this.idArea = id;
        }

    }

}