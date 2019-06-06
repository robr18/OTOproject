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
	private int idPaciente;
	private int idMedico;
	private int idArea;
	static int tam = 100;
	
	public Paciente()
	{
		this.nombre=" ";
		this.tipoSangre=" ";
		this.alta=false;
		this.padecimiento=" ";
		this.edad=0;
		this.sexo=' ';
		this.rfc=" ";
		this.idPaciente=0;
		this.idMedico=0;
		this.idArea=0;
	}
	
	public Paciente(String n,String ts,String p,int e,char s,String r,String np)
	{
		ConsultasMedicos objConsultaMedico= new ConsultasMedicos();
		Medico objMedico = objConsultaMedico.getMedico(np);
		this.nombre=n;
		this.tipoSangre=ts;
		this.alta=true;
		this.padecimiento=p;
		this.edad=e;
		this.sexo=s;
		this.rfc=r;
		this.idPaciente= 1000 + R.nextInt(9000);
		this.idMedico= objMedico.getIdMedico();
		this.idArea=objMedico.getIdArea();
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
		return this.idPaciente;
	}
	
	public int getIdMedico()
	{
		return this.idMedico;
	}
	
	public int getIdArea()
	{
		return this.idArea;
	}
	
	public boolean Eliminado()
	{
		return this.borrado;
	}
	
	public void Eliminar(boolean e)
	{
		this.borrado=e;
	}

	public void putNombre(String n) 
	{
		this.nombre=n;
	}
	
	public void putTipoSangre(String ts)
	{
		this.tipoSangre=ts;
	}

	public void putAlta(Boolean al)
	{
		this.alta=al;
	}

	public void putPadecimiento(String p)
	{
		this.padecimiento=p;
	}
	
	public void putEdad(int e)
	{
		this.edad=e;
	}

	public void putSexo(char sx)
	{
		this.sexo=sx;
	}
	
	public void putRFC(String r)
	{
		this.rfc=r;
	}

	public void putIdPaciente()
	{
		this.idPaciente = 1000 + R.nextInt(9000);
	}
	
	public void putIdPaciente(int id)
	{
		if(id < 1000){
            System.out.println("Id invalido");
            this.putIdPaciente();
        }else{
            this.idPaciente = id;
        }
	}
	
	public void putIdMedico(int idM)
	{
		this.idMedico = idM;
	}

	public void putIdArea(int idA)
	{
		this.idArea = idA;
	}	
	
	public String toString()
	{
		return this.idPaciente+" - "+this.nombre;
	}
}
