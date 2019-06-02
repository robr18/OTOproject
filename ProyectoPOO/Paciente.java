package ProyectoPOO;

import java.util.Random;

public class Paciente {

	Random R=new Random();

	private String nombre;
	private String tipoSangre;
	private boolean alta;
	private String padecimiento;
	private int edad;
	private char sexo;
	private String rfc;
	private boolean borrado;
	private int idP;
	static int tam = 100;
	
	public Paciente()
	{
		nombre=" ";
		tipoSangre=" ";
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
		tipoSangre=ts;
		alta=true;
		padecimiento=p;
		edad=e;
		sexo=s;
		rfc=r;
		idP= 100 + R.nextInt(900);
	}
	
	public boolean Eliminado()
	{
		return borrado;
	}
    
    public void Eliminar(boolean e)
    {
    	borrado=e;
    }

	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getTipoSangre()
	{
		return this.tipoSangre;
	}
	
	public boolean getAlta()
	{
		return this.alta;
	}
	
	public String getPadecimiento()
	{
		return this.padecimiento;
	}
	
	public int getEdad()
	{
		return edad;
	}

	public char getSexo()
	{
		return this.sexo;
	}
	
	public String getRFC()
	{
		return this.rfc;
	}
	public int getIdPaciente()
	{
		return this.idP;
	}

	public void putNombre(String n) 
	{
		nombre=n;
	}
	
	public void putTipoSangre(String ts)
	{
		this.tipoSangre=ts;
	}

	public void putPadecimiento(String p)
	{
		this.padecimiento=p;
	}
	
	public void putEdad(int e)
	{
		this.edad=e;
	}
	
	public void putRFC(String r)
	{
		this.rfc=r;
	}

	public void putIdPaciente()
	{
		this.idP = 100 + R.nextInt(900);
	}
	
	public void putIdPaciente(int id)
	{
		if(id < 100){
            System.out.println("Id invalido");
            this.putIdPaciente();
        }else{
            this.idP = id;
        }
	}
	
	public String toString()
	{
		return nombre+" "+edad;
	}

	public static void main(String[] args) {
		
		Paciente obj=new Paciente("Roberto","0+","Cancer",15,'M',"robet4546");
		obj.getEdad();
		System.out.println(obj);
		
	}
}
