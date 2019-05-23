package ProyectoPOO;
import java.util.*;

public class Area{

    private String nombre;
    private String descAct;
    private int piso;
    private String direccion;
    int idA;

    public Area()
    {
        nombre=" ";
        descAct=" ";
        piso=0;
        direccion=" ";
        idA=0;
    }

    public String getNombreA()
    {
        return nombre;
    }

    public String getDescA()
    {
        return descAct;
    }

    public int getPiso()
    {
        return piso;
    }

    public String getDireccionA()
    {
        return direccion;
    }

    public int getIdA()
    {
        return idA;
    }

}