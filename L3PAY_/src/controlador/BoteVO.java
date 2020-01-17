package controlador;

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
				if(!controlador.searchUserPot(usuario)) {
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
	
	public float getDineroCuenta(String user) {
		String dni;
		dni = controlador.getDni(user);
		int retorno;
		retorno = controlador.cuenta(dni);
		double respuesta = controlador.dineroCuente(retorno);
		float dinero;
		dinero = (float) respuesta;
		return dinero;
	}
	
	public boolean updateUserMoney(String user, float dinero) {
		String dni;
		dni = controlador.getDni(user);
		int retorno;
		retorno = controlador.cuenta(dni);
		if(controlador.enviarDinero(retorno,(double)dinero)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updatePotMoney(int code, float newMoney){
		float nuevoDinero = controlador.getMoney(code)+newMoney;
		float dineromissing = controlador.getMoney2(code)+newMoney;
		if(controlador.aniadirDineroBote(code, nuevoDinero)&&controlador.aniadirDineroBote2(code, dineromissing)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getIntegrantes(int potCode) {
		return controlador.getIntegrantesBote(potCode);
	}
	
	public boolean removeUser(String user) {
		boolean respuesta = controlador.removeFromPot(user);
		return respuesta;
	}
	
	public boolean aniadePersona(String usuario, int codigo) {
		
			if(controlador.search(usuario)) {
				if(!controlador.searchUserPot(usuario)) {
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
	public float getMoney(int potCode) {
		return controlador.getMoney(potCode);
	}
	
	public float getMoney2(int potCode) {
		return controlador.getMoney2(potCode);
	}
	
	public boolean aniadeDinero(int potID, float dinero) {
		if(controlador.aniadirDineroBote(potID, dinero)){
			return true;
		}
		return false;
	}
	
	public boolean pagoBote(int code, float cantidad) {
		boolean respuesta = controlador.pagoBote(code, cantidad);
		return respuesta;
	}
	
	public boolean searchBote(int potID, String namePot) {
		String pot = controlador.searchPot(potID);
		if(pot.equals(namePot)) {
			return true;
		}
		return false;
	}
	public boolean searchBote2(int potID) {
		String pot = controlador.searchPot(potID);
		if(pot!=null) {
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
