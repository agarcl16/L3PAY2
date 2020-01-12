package application;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Respaldos{

	public Respaldos() {
		
	}
	
	public void copia() {
	
		try {
		
			Process p = Runtime.getRuntime().exec("mysqldump -u root -p 1234 aplicacion");
			
			new HiloLector(p.getErrorStream()).start();
			
			InputStream is = p.getInputStream();
			FileOutputStream fos = new FileOutputStream("backup_aplicacion.sql");
			
			byte[] buffer =new byte[1000];
					
			int leido = is.read(buffer);
			
			while(leido > 0) {
				
				fos.write(buffer,0,leido);
				leido = is.read(buffer);
				
			}
			
			fos.close();
			
		}catch (IOException ex) {
			
			Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null , ex);
			
		}
	
	}
}
