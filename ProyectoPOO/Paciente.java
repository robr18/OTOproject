package ProyectoPOO;

import java.util.Random;

public class Paciente {

	Random R=new Random();
	private String nombre;
	private String tipSangre;
	private boolean alta;
	private String padecimiento;
	private int edad;
	private char sexo;
	private String rfc;
	private int idP;
	
	public Paciente()
	{
		nombre=" ";
		tipSangre=" ";
		alta=false;
		padecimiento=" ";
		edad=0;
		sexo=' ';
		rfc=" ";
		idP=0; //Que el numero de id nos lo de un random
	}
	
	public Paciente(String n,String ts,String p,int e,char s,String r)
	{
		nombre=n;
		tipSangre=ts;
		alta=true;
		padecimiento=p;
		edad=e;
		sexo=s;
		rfc=r;
		idP=R.nextInt(100);
	}
	
	public void putNombre(String n)
	{
		nombre=n;
	}
	
	public void putSangre(String ts)
	{
		tipSangre=ts;
	}
	
	public void putPadecimiento(String p)
	{
		padecimiento=p;
	}
	
	public void putEdad(int e)
	{
		edad=e;
	}
	
	public void putRfc(String r)
	{
		rfc=r;
	}
	
	public void putID(int id)
	{
		idP=id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getSangre()
	{
		return tipSangre;
	}
	
	public boolean getAlta()
	{
		return alta;
	}
	
	public String getPadecimiento()
	{
		return padecimiento;
	}
}
