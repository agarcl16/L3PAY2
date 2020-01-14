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
		
		public boolean aniadirMovimiento(String name, int cuenta, double dinero) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO bill (billname, billprice, accountnum) VALUES(?,?,?)");
				ps.setString(1, name);
				ps.setDouble(2, dinero);
				ps.setInt(3, cuenta);
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
				System.err.println("Error al introducir el dinero en la tabla bill");
			}
			return retorno;
		}
		
		public boolean creaBote(String namePot, String userLeader, int potCode) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO pot (potname,potstatus,potleader,potID) VALUES(?,?,?,?)");
				ps.setString(1, namePot);
				ps.setDouble(2, 0);
				ps.setString(3, userLeader);
				ps.setInt(4, potCode);
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
				System.err.println("Error al crear bote");
			}
			return retorno;
		}
		
		public boolean searchUserPot(String user) {
			Connection con = null;
			boolean respuesta = false;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM participant WHERE participantname = ?");
				ps.setString(1, user);
				rs = ps.executeQuery();
				if(!rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar usuario del bote");
			}	
			return respuesta;
		}
		public String getIntegrantesBote(int potID) {
			Connection con = null;
			String respuesta = "";
			try {
				con = getConnection();
				ps= con.prepareStatement("SELECT * FROM participant WHERE potcall = ?");
				ps.setInt(1, potID);
				rs = ps.executeQuery();
				while(rs.next()) {
					respuesta += rs.getString("participantname")+",";
				}
				
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar usuario del bote");
			}	
			return respuesta.substring(0, respuesta.length()-1);
		}
		
		public String getLeader(int code) {
			Connection con = null;
			String respuesta = null;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM pot WHERE potID = ?");
				ps.setInt(1, code);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getString("potLeader");
				}
				else {
					respuesta = null;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar la cuenta");
			}	
			return respuesta;
		}
		
		public String searchPot(int codigo) {
			Connection con = null;
			String respuesta = null;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM pot WHERE potID = ?");
				ps.setInt(1, codigo);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getString("potname");
				}
				else {
					respuesta = null;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar la cuenta");
			}	
			return respuesta;
		}
		
		public boolean removeBote(int bote) {
			Connection con = null;
			boolean respuesta = true;
			try {
				con = getConnection();
				ps = con.prepareStatement("DELETE FROM pot WHERE potID = ?");
				ps.setInt(1, bote);
				ps.executeUpdate();
				/*if(rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}*/
				con.close();
			}catch(Exception e) {
				System.err.println("Error al eliminar");
			}	
			return respuesta;
		}
		
		public boolean aniadirPersonaBote(String userName, int potID, String dni) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO participant (potcall, usercall, contribution, participantname) VALUES(?,?,?,?)");
				ps.setInt(1, potID);
				ps.setString(2, dni);
				ps.setDouble(3, 0.0);
				ps.setString(4, userName);
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
				System.err.println("Error al aniadir persona al bote");
			}
			return retorno;
		}
		
		public float getMoney(int potCode) {
			Connection con = null;
			float respuesta = -1;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM pot WHERE potID = ?");
				ps.setInt(1, potCode);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getFloat("potstatus");
				}
				else {
					respuesta = -1;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar la cuenta");
			}	
			return respuesta;
		}
		
		public boolean removeFromPot(String user) {
			Connection con = null;
			boolean respuesta = true;
			try {
				con = getConnection();
				ps = con.prepareStatement("DELETE FROM participant WHERE participantname = ?");
				ps.setString(1, user);
				ps.executeUpdate();
				/*if(rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}*/
				con.close();
			}catch(Exception e) {
				System.err.println("Error al eliminar");
			}	
			return respuesta;
		}
		
		public float getMoney2(int potCode) {
			Connection con = null;
			float respuesta = -1;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM pot WHERE potID = ?");
				ps.setInt(1, potCode);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getFloat("missingmoney");
				}
				else {
					respuesta = -1;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar la cuenta");
			}	
			return respuesta;
		}
		
		public boolean aniadirDineroBote(int potID, float cantidad) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("UPDATE pot SET potstatus = ? WHERE potID = ?");
				ps.setFloat(1, cantidad);
				ps.setInt(2,potID);
				
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
				System.err.println("Error al aniadir dinero bote");
			}
			return retorno;
		}
		
		public boolean aniadirDineroBote2(int potID, float cantidad) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("UPDATE pot SET missingmoney = ? WHERE potID = ?");
				ps.setFloat(1, cantidad);
				ps.setInt(2,potID);
				
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
				System.err.println("Error al aniadir dinero bote");
			}
			return retorno;
		}
		
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
		
		public String getDni(String user) {
			Connection con = null;
			String retorno=null;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
				ps.setString(1, user);
				rs = ps.executeQuery();
				if(rs.next()) {
					retorno = rs.getString("dni");
				}
				else {
					retorno = null; 	
				}
				con.close();
				return retorno;
				
			}catch(Exception e) {
				System.err.println("Error al coger el dni");
			}
			return retorno;
		}
		
		public boolean addAccount2(int name, String dni) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO useracc (accountid, userdni) VALUES(?,?)");
				ps.setInt(1, name);
				ps.setString(2, dni);
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
		public boolean searchAccount(String dni) {
			Connection con = null;
			boolean respuesta = false;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM useracc WHERE userdni = ?");
				ps.setString(1, dni);
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
		
		public boolean removeUser(String name) {
			Connection con = null;
			boolean respuesta = true;
			try {
				con = getConnection();
				ps = con.prepareStatement("DELETE FROM users WHERE username = ?");
				ps.setString(1, name);
				ps.executeUpdate();
				/*if(rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}*/
				con.close();
			}catch(Exception e) {
				System.err.println("Error al eliminar");
			}	
			return respuesta;
		}
		
		public boolean searchAccount2(int num) {
			Connection con = null;
			boolean respuesta = false;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM account WHERE accountnumber = ?");
				ps.setInt(1, num);
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

		public boolean removeCuenta(int cuenta) {
			Connection con = null;
			boolean respuesta = true;
			try {
				con = getConnection();
				ps = con.prepareStatement("DELETE FROM account WHERE accountnumber = ?");
				ps.setInt(1, cuenta);
				ps.executeUpdate();
				/*if(rs.next()) {
					respuesta = true;
				}
				else {
					respuesta = false;
				}*/
				con.close();
			}catch(Exception e) {
				System.err.println("Error al eliminar");
			}	
			return respuesta;
		}
		
		public int cuenta(String dni) {
			Connection con = null;
			int respuesta = 0;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM useracc WHERE userdni = ?");
				ps.setString(1, dni);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getInt("accountid");
				}
				else {
					respuesta = -1;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al buscar la cuenta");
			}	
			return respuesta;
		}
		
		
		public double dineroCuente(int cuenta) {
			Connection con = null;
			double respuesta = 0;
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM account WHERE accountnumber = ?");
				ps.setInt(1, cuenta);
				rs = ps.executeQuery();
				if(rs.next()) {
					respuesta = rs.getDouble("accountstatus");
				}
				else {
					respuesta = 0;
				}
				con.close();
			}catch(Exception e) {
				System.err.println("Error al sacar dinero de la cuenta");
			}	
			return respuesta;
		}
		
		public boolean enviarDinero(int cuenta, double cantidad) {
			Connection con = null;
			boolean retorno=false;
			try {
				con = getConnection();
				ps = con.prepareStatement("UPDATE account SET accountstatus = ? WHERE accountnumber = ?");
				ps.setDouble(1, cantidad);
				ps.setInt(2, cuenta);
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
				System.err.println("Error al enviar");
			}
			return retorno;
		}
		
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
