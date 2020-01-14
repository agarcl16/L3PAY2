package application;

import java.sql.Connection;

public class AdminVO {
	private procs controlador;
	public AdminVO() {
		controlador = new procs();
	}
	public boolean removeUser(String user) {
		String dni = controlador.getDni(user);
		int cuenta = controlador.cuenta(dni);
		if(controlador.removeCuenta(cuenta)) {
			if(controlador.removeUser(user)) {
				return true;
			}
		}
		return false;
	}
	public boolean removeCuenta(int cuenta) {
		if(controlador.removeCuenta(cuenta)) {
			return true;
		}
		return true;
	}
	public boolean removeBote(String bote) {
		return true;
	}
	public boolean searchUser(String name) {
		if(controlador.search(name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean searchBote(int bote) {
		return true;
	}
	
	public boolean searchCuenta(int cuenta) {
		if(controlador.searchAccount2(cuenta)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
