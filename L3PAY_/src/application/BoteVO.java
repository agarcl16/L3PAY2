package application;

public class BoteVO {
	private procs controlador;
	public BoteVO() {
		controlador = new procs();
	}
	public boolean creaBote(String namePot) {
		if(controlador.creaBote(namePot, MainController.elUsuario)) return true;
		return false;
	}
	public boolean aniadePersona(String usuario, String bote) {
		int pot = controlador.searchPot(bote);
		if(pot==-1) {
			return false;
		}
		else {
			if(controlador.search(usuario)) {
				String dni = controlador.getDni(usuario);
				if(controlador.aniadirPersonaBote(usuario, pot, dni)) {
					return true;
				}
				return false;
			}
			else {
				return false;
			}
		}
	}
	public boolean searchBote(String namePot) {
		return true;
	}
}
