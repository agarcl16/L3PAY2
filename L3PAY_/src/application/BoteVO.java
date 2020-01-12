package application;

public class BoteVO {
	private procs controlador;
	public BoteVO() {
		controlador = new procs();
	}
	public boolean creaBote(String namePot, int potCode) {
		if(controlador.creaBote(namePot, MainController.elUsuario, potCode)) {
			return true;
		}
		return false;
	}
	public boolean aniadePersona(String usuario, String bote, int codigo) {
		String pot = controlador.searchPot(codigo);
		if(!pot.equals(bote)) {
			return false;
		}
		else {
			if(controlador.search(usuario)) {
				if(controlador.searchUserPot(usuario)!=-1) {
					return false;
				}
				String dni = controlador.getDni(usuario);
				if(controlador.aniadirPersonaBote(usuario, codigo, dni)) {
					return true;
				}
				return false;
			}
			else {
				return false;
			}
		}
	}
	public boolean searchBote(int potID, String namePot) {
		String pot = controlador.searchPot(potID);
		if(pot.equals(namePot)) {
			return true;
		}
		return false;
	}
	public String getLeader(int potID) {
		String respuesta = null;
		respuesta = controlador.getLeader(potID);
		return respuesta;
	}
}
