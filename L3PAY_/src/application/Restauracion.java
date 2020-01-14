package application;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Restauracion {

	public Restauracion() {
		
	}
	
	public void restaura() {
	
		try {
		
			Process p = Runtime.getRuntime().exec("mysql -u root -p1234 cpseguridad");
			
			new HiloLector(p.getErrorStream()).start();
			
			OutputStream os = p.getOutputStream();
			FileInputStream fis = new FileInputStream("backup_aplicacion.sql");
			
			byte[] buffer =new byte[1000];
					
			int leido = fis.read(buffer);
			
			while(leido > 0) {
				
				os.write(buffer,0,leido);
				leido = fis.read(buffer);
				
			}
			
			os.flush();
			os.close();
			fis.close();
			
		}catch (IOException ex) {
			
			Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null , ex);
			
		}
	
	}
	
}
