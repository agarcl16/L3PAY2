package application;




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
				
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost/aplicacion";
				String usuario="root";
				String contrasenia="1234";
				cn= DriverManager.getConnection(url,usuario,contrasenia);
				
			}catch (Exception e) {
				
				cn=null;
			}
			
			if(cn!=null) {
				
				System.out.println("conectado");
				System.out.println(cn);
			}else {
				
				System.out.println("desconectado");
				
			}
			return cn;
		}
	
	/*	public static void NuevoUsuario(String dni,String username,String name,String surname,String phonenumber,String email,String fechaNacimiento,String password)throws SQLException{
		
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
			
			
		}*/
		
		public String searchPassword(String userName){
			Connection con = null;
			String respuesta = null;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
				ps.setString(1, userName);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getString("password");
				}
				else {
					respuesta = null;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar");
			}	
			return respuesta;
		}
		
		public boolean search(String username) {
			Connection con = null;
			boolean respuesta = false;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
				ps.setString(1, username);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar");
			}	
			return respuesta;
		}
		
		public boolean addAccount(int name, double dinero) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO account (accountnumber, accountstatus) VALUES(?,?)");
				ps.setInt(1, name);
				ps.setDouble(2, dinero);
				int res = ps.executeUpdate();
				if(res>0) {
					retorno = true;
				}
				else {
					retorno = false; 	
				}
				con.close();
				return retorno;
				
			}catch(Exception e) {
				System.err.println("Error al vincular");
			}
			return retorno;
		}
		
	/*	public String getDni(String user) {
			String retorno;
			retorn = this.
			return null;
		}*/
		
		public boolean addAccount2(int name) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO useracc (accountid, userdni) VALUES(?,?)");
				ps.setInt(1, name);
				ps.setString(2, "39469120Q");
				int res = ps.executeUpdate();
				if(res>0) {
					retorno = true;
				}
				else {
					retorno = false; 	
				}
				con.close();
				return retorno;
				
			}catch(Exception e) {
				System.err.println("Error al vincular");
			}
			return retorno;
		}
		public boolean searchAccount(int name) {
			return false;
		}
		
		
		/*public void remove(user){

			int position = search(users.username);
			int contador=0;
			
			for(int i=0; i<; i++) {
				if([i]!=null) {
					contador++;
				}
			}
			
			if(position!=-1) { 
				[position] = null;
				reOrder();
				next--;
			}else if(contador==0) { 

				throw new Exception("ERROR: empty list.");
			}
			else { 

				throw new Exception("ERROR:" +  + " doesnt not exist.");
			}
		}*/

		public boolean add(String name, String surname, String personalID, String number, String user, String password) throws Exception{
			
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO users (dni,username,name,surname,phonenumber,password) VALUES(?,?,?,?,?,?)");
				
				ps.setString(1,personalID);
				ps.setString(2,user);
				ps.setString(3,name);
				ps.setString(4,surname);
				ps.setString(5,number);
				ps.setString(6,password);
				
				int res = ps.executeUpdate();
				if(res>0) {
					retorno = true;
				}
				else {
					retorno = false; 	
				}
				con.close();
				return retorno;
				
			}catch(Exception e) {
				System.err.println("Error al aniadir");
			}
		   
			return retorno;
		}


}
