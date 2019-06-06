import java.io.*;
public class operArchArea {
	
	RandomAccessFile archD=null;
	String nomRuta;
   
	public operArchArea(String arch)
	{
		nomRuta=arch;
	}
	
	public void Abrir(String tipo)
	{
		try{
			archD = new RandomAccessFile(nomRuta,tipo);
		}catch(IOException e){
			System.out.println("Error de apertura del archivo directo: " + e);
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

	public void Grabar(Area reg)
	{
		try{
			archD.writeUTF(reg.getNombreArea());
			archD.writeUTF(reg.getDescA());
			archD.writeInt(reg.getPiso());
			archD.writeUTF(reg.getDireccionA());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}

	public void Grabar(Area reg,int pos)
	{
		try{
			//saltar a la posicion
			archD.seek(pos*reg.tam);
			archD.writeUTF(reg.getNombreArea());
			archD.writeUTF(reg.getDescA());
			archD.writeInt(reg.getPiso());
			archD.writeUTF(reg.getDireccionA());
			archD.writeInt(reg.getIdArea());
			archD.writeBoolean(reg.Eliminado());

		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}

	public Area Leer()
	{
		Area regt=new Area();
		try{
			regt.putNombreArea(archD.readUTF());
			regt.putDescAct(archD.readUTF());
			regt.putPiso(archD.readInt());
			regt.putDireccion(archD.readUTF());
			regt.putIdArea(archD.readInt());
			regt.Eliminado(archD.readBoolean());
			
		}catch(EOFException e){
			regt=null;
		}
		catch(IOException e){
			System.out.println("Error de Lectura");
			regt=null;
		}
		return regt;
	}

	public Area Leer(int pos)
	{
		Area regt=new Area();
		try{
			archD.seek(pos*Area.tam);
			regt.putNombreArea(archD.readUTF());
			regt.putDescAct(archD.readUTF());
			regt.putPiso(archD.readInt());
			regt.putDireccion(archD.readUTF());
			regt.putIdArea(archD.readInt());
			regt.Eliminado(archD.readBoolean());
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
		int nr=-1;
		try{
			tamBytes=archD.length();
			nr=(int)(tamBytes/Area.tam);
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
	public static void main(String[] args) {
		operArchArea objArch = new operArchArea("areas.txt");
		objArch.Abrir("rw");
		System.out.println(objArch.numReg());
		objArch.Grabar(new Area("Cardiologia","Corazon",3,"lopez r 78"),objArch.numReg());
		System.out.println(objArch.numReg());
		objArch.Grabar(new Area("Neurologia","Cerebro",5,"lopez r 78"),objArch.numReg());
		System.out.println(objArch.numReg());
	}
}