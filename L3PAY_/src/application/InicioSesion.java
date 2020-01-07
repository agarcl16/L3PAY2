package application;

import java.sql.Connection;

public class InicioSesion {
	public procs controlador;
	public InicioSesion() {
		
	}
	public boolean accesoUsuario(String userName, String password) {
		controlador = new procs();
		String realPassword;
		realPassword = controlador.searchPassword(userName);
		if(realPassword==null) {
			return false;
		}
		else if(realPassword.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
