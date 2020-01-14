package application;

public class AdminVO {
	private procs controlador;
	public AdminVO() {
		controlador = new procs();
	}
	public boolean removeUser() {
		return true;
	}
	public boolean removeCuenta() {
		return true;
	}
	public boolean removeBote() {
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
}
