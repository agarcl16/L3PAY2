package controlador;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Registro {
	public procs controlador;
	private int numero;
	public Registro() {
		
		this.numero = 0;
	}
	
	public boolean aniadirPersona(String name, String surname, String personalID, String number, String user, String password) throws Exception {
		boolean solucion;
		controlador = new procs();
		boolean comprobacion;
		if(this.numero == 0) {
			
			solucion = controlador.add(name, surname, personalID, number, user, password);
			if(solucion == false) {
				return false;
			}
			this.numero++;
			return true;
		}
		else {
			comprobacion = controlador.search(user);
			
				if(comprobacion = true) {
					return false;
				}
			solucion = controlador.add(name, surname, personalID, number, user, password);
			if(solucion == false) {
				return false;
			}
			this.numero++;
			return true;
		}
	}
}
