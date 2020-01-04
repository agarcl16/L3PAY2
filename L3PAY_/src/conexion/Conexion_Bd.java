package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion_Bd {
	
	private static Connection cn;
	
	public static Connection getConnection() {
		
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://LAPTOP-AQVCQBRF\\SQLEXPRESS:50663;databaseName=Users","inso","123");
			
		}catch (Exception e) {
			
			cn=null;
		}
		
		return cn;
	}
	
	public static void main(String[] args) {
		
		Connection pruebaCn=Conexion_Bd.getConnection();
		if(pruebaCn!=null) {
			
			System.out.println("conectado");
			System.out.println(pruebaCn);
			
		}else {
			
			System.out.println("desconectado");
			
		}
		
	}
 
}
