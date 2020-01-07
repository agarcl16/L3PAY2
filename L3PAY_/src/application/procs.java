package application;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class procs {
	PreparedStatement ps;
	ResultSet rs;
		public procs() {
			
		}
		
		public static Connection getConnection() {
			Connection cn = null;
			
			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				cn= (Connection) DriverManager.getConnection("jdbc:sqlserver://LAPTOP-AQVCQBRF\\SQLEXPRESS:50663;databaseName=Users","inso","123");
				
			}catch (Exception e) {
				
				cn=null;
			}
			
			return cn;
		}
	
		public static void NuevoUsuario(String dni,String username,String name,String surname,String phonenumber,String email,String fechaNacimiento,String password)throws SQLException{
		
			CallableStatement entrada = Conexion_Bd.getConnection().prepareCall("{call NuevoUsuario(?,?,?,?,?,?,?,?)}");
			
			entrada.setString(1,dni);
			entrada.setString(2,username);
			entrada.setString(3,name);
			entrada.setString(4,surname);
			entrada.setString(5,phonenumber);
			entrada.setString(6,email);
			entrada.setString(7,fechaNacimiento);
			entrada.setString(8,password);
			
			entrada.execute();
			
			
		}
		public int search(String username) {
			
			int positionUser=-1;
			int i=0;
			boolean encontrado=false;
			
			while(i!=NuevoUsuario.length) {
				
				if(NuevoUsuario[i]!=null && encontrado == false) {
		
					if(name.contentEquals(NuevoUsuario[i].username)) {
						positionKid = i;
						encontrado=true;
					}else {

						encontrado=false;
					}
				}
				i++;
			}
			return positionUser;	
		}
		
		public void remove(user){

			int position = search(users.username);
			int contador=0;
			
			for(int i=0; i</*Lista de users.username*/; i++) {
				if(/*Lista de users.username*/[i]!=null) {
					contador++;
				}
			}
			
			if(position!=-1) { 
				/*Lista de users.username*/[position] = null;
				reOrder();
				next--;
			}else if(contador==0) { 

				throw new Exception("ERROR: empty list.");
			}
			else { 

				throw new Exception("ERROR:" +/*user.username*/  + " doesnt not exist.");
			}
		}

		public boolean add(String name, String surname, String personalID, String number, String user, String password) throws Exception{
			Connection con = null;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO Users (dni,username,name,surname,phonenumber,password) VALUES(?,?,?,?,?,?)");
				
				ps.setString(1,personalID);
				ps.setString(2,user);
				ps.setString(3,name);
				ps.setString(4,surname);
				ps.setString(5,number);
				ps.setString(6,password);
				
				int res = ps.executeUpdate();
				if(res>0) {
					return true;
				}
				else {
					return false; 	
				}
				con.close();
				
			}catch(Exception e) {
				System.err.println("Error al aniadir");
			}
		   
			
		}


}
