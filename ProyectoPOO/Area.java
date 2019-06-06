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
        this.nombre=" ";
        this.descAct=" ";
        this.piso=0;
        this.direccion=" ";
        this.borrado=false;
        this.idArea= 1000 + R.nextInt(9000);
    }
    public Area(String n, String desc, int p, String dir)
    {
        this.nombre=n;
        this.descAct=desc;
        this.piso=p;
        this.direccion=dir;
        this.borrado=false;
        this.idArea= 1000 + R.nextInt(9000);
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

    public boolean Eliminado()
    {
        return this.borrado;
    }       
    
    public void Eliminado(boolean e)
    {
        this.borrado=e;
    }
    
    public void putNombreArea(String n) 
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
        int id = 1000 + R.nextInt(9000);
        this.idArea = id;
        System.out.println("Nuevo id: "+id);
    }

    public void putIdArea(int id) 
    {
        if(id < 1000){
            this.putIdArea();
            System.out.println("Id invalido");
        }else{
            this.idArea = id;
        }
    }

    public String toString()
	{
		return this.idArea+" - "+this.nombre;
	}
}