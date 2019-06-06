import java.io.*;
public class operArchPaciente {

	RandomAccessFile archD=null;
	String nomRuta;
	
	public operArchPaciente(String arch)
	{
		nomRuta=arch;
	}

   	public void Abrir(String tipo)
   	{
		try{
			archD = new RandomAccessFile(nomRuta,tipo);
		}catch(IOException e){
			System.out.println("Error de apertura del archivo directo");
			System.exit(0);
		}
   }

	public void Cerrar()
	{
		try{
			if(archD!=null) 
				archD.close();
		}catch(IOException e){}
	}

	public void Grabar(Paciente reg)
	{
		try{
			archD.writeUTF(reg.getNombre());
			archD.writeUTF(reg.getTipoSangre());
			archD.writeBoolean(reg.getAlta());
			archD.writeUTF(reg.getPadecimiento());
			archD.writeInt(reg.getEdad());
			archD.writeChar(reg.getSexo());
			archD.writeUTF(reg.getRFC());
			archD.writeInt(reg.getIdPaciente());
			archD.writeInt(reg.getIdMedico());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}

	public void Grabar(Paciente reg,int pos)
	{
		try{
			//saltar a la posicion
			archD.seek(pos*Medico.tam);
			archD.writeUTF(reg.getNombre());
			archD.writeUTF(reg.getTipoSangre());
			archD.writeBoolean(reg.getAlta());
			archD.writeUTF(reg.getPadecimiento());
			archD.writeInt(reg.getEdad());
			archD.writeChar(reg.getSexo());
			archD.writeUTF(reg.getRFC());
			archD.writeInt(reg.getIdPaciente());
			archD.writeInt(reg.getIdMedico());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}

	public Paciente Leer()
	{
		Paciente regt=new Paciente();
		try{
			regt.putNombre(archD.readUTF());			
			regt.putTipoSangre(archD.readUTF());			
			regt.putAlta(archD.readBoolean());			
			regt.putPadecimiento(archD.readUTF());			
			regt.putEdad(archD.readInt());			
			regt.putSexo(archD.readChar());			
			regt.putRFC(archD.readUTF());			
			regt.putIdPaciente(archD.readInt());			
			regt.putIdMedico(archD.readInt());			
			regt.putIdArea(archD.readInt());			
			regt.Eliminar(archD.readBoolean());			
		}catch(EOFException e){
			regt=null;
		}
		catch(IOException e){
			System.out.println("Error de Lectura");
			regt=null;
		}
		return regt;
	}

	public Paciente Leer(int pos)
	{
		Paciente regt=new Paciente();
		try{
			archD.seek(pos*Medico.tam);
			regt.putNombre(archD.readUTF());			
			regt.putTipoSangre(archD.readUTF());			
			regt.putAlta(archD.readBoolean());			
			regt.putPadecimiento(archD.readUTF());			
			regt.putEdad(archD.readInt());			
			regt.putSexo(archD.readChar());			
			regt.putRFC(archD.readUTF());			
			regt.putIdPaciente(archD.readInt());			
			regt.putIdMedico(archD.readInt());			
			regt.putIdArea(archD.readInt());
			regt.Eliminar(archD.readBoolean());			
		}catch(EOFException e){
			regt=null;
		}
		catch(IOException e){
			System.out.println("Error de Lectura");
			regt=null;
		}
		return regt;
	}

	public void inicio()
	{
		try{
			archD.seek(0L);
		}catch(IOException e){}
	}

	public int numReg()
	{
		long tamBytes=0;
		int nr=0;
		try{
			tamBytes=archD.length();
			nr=(int)(tamBytes/Medico.tam);
			nr+=1;
		}catch(IOException e){}
		return nr;
	}

	public void borrarArch()
	{
		try{
			archD.setLength(0L);
		}catch(IOException e){}
	}
}
