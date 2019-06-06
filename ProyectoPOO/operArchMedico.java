import java.io.*;
public class operArchMedico {

	RandomAccessFile archD=null;
	String nomRuta;
	
	public operArchMedico(String arch)
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

	public void Grabar(Medico reg)
	{
		try{
			archD.writeUTF(reg.getNombre());
			archD.writeUTF(reg.getDireccion());
			archD.writeUTF(reg.getRFC());
			archD.writeInt(reg.getEdad());
			archD.writeInt(reg.getIdMedico());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}

	public void Grabar(Medico reg,int pos)
	{
		try{
			//saltar a la posicion
			archD.seek(pos*Medico.tam);
			archD.writeUTF(reg.getNombre());
			archD.writeUTF(reg.getDireccion());
			archD.writeUTF(reg.getRFC());
			archD.writeInt(reg.getEdad());
			archD.writeInt(reg.getIdMedico());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
   	}

	public Medico Leer()
	{
		Medico regt=new Medico();
		try{
			regt.putNombre(archD.readUTF());
			regt.putDireccion(archD.readUTF());
			regt.putRFC(archD.readUTF());
			regt.putEdad(archD.readInt());
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

	public Medico Leer(int pos)
	{
		Medico regt=new Medico();
		try{
			archD.seek(pos*Medico.tam);
			regt.putNombre(archD.readUTF());
			regt.putDireccion(archD.readUTF());
			regt.putRFC(archD.readUTF());
			regt.putEdad(archD.readInt());
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