package application;

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
		if(this.numero == 0) {
			if(!controlador.add(name, surname, personalID, number, user, password)) {
				return false;
			}
			this.numero++;
			return true;
		}
		else {
			int i;
			for(i=0; i<this.numero;i++ ) {
				//aqui se comprueba toda la lista si concuerda con alguno
				if(true) {
					return false;
				}
			}
			//Si llega aqui es que hay que aniadirlo
			if(!controlador.add(name, surname, personalID, number, user, password)) {
				return false;
			}
			this.numero++;
			return true;
		}
		
	}
}
