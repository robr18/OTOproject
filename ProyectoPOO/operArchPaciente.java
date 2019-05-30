package ProyectoPOO;
import java.io.*;
public class operArchPaciente {
   RandomAccessFile archD=null;
   String nomRuta;
   public Medico Buscar(String rfc)
   {
	   Medico regt=null;
	   int i=0;
	   do{
		   regt=Leer(i);
		   if(regt!=null && !regt.Eliminado())
			   if(regt.getRFC().compareToIgnoreCase(rfc)==0)
				   	  return regt;
		   i++;
	   }while(regt!=null);
	   return regt;
   }
   public int BuscarA(String rfc)
   {
	   Medico regt=null;
	   int i=0;
	   do{
		   regt=Leer(i);
		   if(regt!=null && !regt.Eliminado())
			   if(regt.getRFC().compareToIgnoreCase(rfc)==0)
				   	  return i;
		   i++;
	   }while(regt!=null);
	   return -1;
   }
   public void Reporte()
   {
	   Medico regt=null;
	   int i=0;
	   do{
		   regt=Leer(i);
		   if(regt!=null && !regt.Eliminado())
			   System.out.println(regt);
		   i++;
	   }while(regt!=null);
   }
   public operArchPaciente(String arch)
   {
	   nomRuta=arch;
   }
   public void Abrir()
   {
	   try{
		   archD=new RandomAccessFile(nomRuta,"rw");
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
		   archD.writeBoolean(reg.Eliminado());
		   archD.writeUTF(reg.getRFC());
		   archD.writeUTF(reg.getNombre());
		   archD.writeInt(reg.getEdad());
	   }catch(IOException e){
		   System.out.println("Error de escritura");
	   }
   }
   public void Grabar(Paciente reg,int pos)
   {
	   try{
		   //saltar a la posicion
		   archD.seek(pos*Medico.tam);
		   archD.writeBoolean(reg.Eliminado());
		   archD.writeUTF(reg.getRFC());
		   archD.writeUTF(reg.getNombre());
		   archD.writeInt(reg.getEdad());

	   }catch(IOException e){
		   System.out.println("Error de escritura");
	   }
   }
   public Paciente Leer()
   {
	   Paciente regt=new Paciente();
	   try{
		   regt.Eliminar(archD.readBoolean());
		   regt.putRFC(archD.readUTF());
		   regt.putNombre(archD.readUTF());
		   regt.putEdad(archD.readInt());
		   
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
		   regt.Eliminar(archD.readBoolean());
		   regt.putRFC(archD.readUTF());
		   regt.putNombre(archD.readUTF());
		   regt.putEdad(archD.readInt());
		   regt.putDireccion(archD.readUTF());
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
   public static void main(String[] args) {
	  operArchPaciente obj=new operArchPaciente("src/paciente.txt");
  }
}
