
package ProyectoPOO;
import java.io.*;
public class operArchArea {
   RandomAccessFile archD=null;
   String nomRuta;
   
   public void Reporte()
   {
	   Area regt=null;
	   int i=0;
	   do{
		   regt=Leer(i);
		   if(regt!=null && !regt.Eliminado())
			   System.out.println(regt);
		   i++;
	   }while(regt!=null);
   }
   public operArchArea(String arch)
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
   public void Grabar(Area reg)
   {
	   try{
		   archD.writeBoolean(reg.Eliminado());
		   archD.writeUTF(reg.getNombreArea());
		   archD.writeUTF(reg.getDescA());
		   archD.writeInt(reg.getPiso());
		   archD.writeUTF(reg.getDireccionA());
		   archD.writeInt(reg.getIdArea());
	   }catch(IOException e){
		   System.out.println("Error de escritura");
	   }
   }
   public void Grabar(Area reg,int pos)
   {
	   try{
		   //saltar a la posicion
		   archD.seek(pos*Area.tam);
		   archD.writeBoolean(reg.Eliminado());
		   archD.writeUTF(reg.getNombreArea());
		   archD.writeUTF(reg.getDescA());
		   archD.writeInt(reg.getPiso());
		   archD.writeUTF(reg.getDireccionA());
		   archD.writeInt(reg.getIdArea());

	   }catch(IOException e){
		   System.out.println("Error de escritura");
	   }
   }
   public Area Leer()
   {
	   Area regt=new Area();
	   try{
		   regt.Eliminar(archD.readBoolean());
		   regt.putDireccion(archD.readUTF());
		   regt.putNombre(archD.readUTF());
		   regt.putDescAct(archD.readUTF());
		   regt.putIdArea(archD.readInt());
		   regt.putPiso(archD.readInt());
		   
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
		   archD.seek(pos*Medico.tam);
		   regt.Eliminar(archD.readBoolean());
		   regt.putDireccion(archD.readUTF());
		   regt.putNombre(archD.readUTF());
		   regt.putDescAct(archD.readUTF());
		   regt.putIdArea(archD.readInt());
		   regt.putPiso(archD.readInt());;
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
	  operArchArea obj=new operArchArea("src/medico.txt");
  }
}