package conexion;



import java.sql.CallableStatement;

import java.sql.SQLException;

public class procs {
	
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
}
