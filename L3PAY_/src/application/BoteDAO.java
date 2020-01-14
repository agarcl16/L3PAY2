package application;

public class BoteDAO {
	private BoteVO controlador;
	public BoteDAO() {
		controlador = new BoteVO();
	}
	public boolean aniadeDinero(String potCode, String cantidad){
		int codigoBote;
		float dinero;
		if(!comprueba(potCode)) {
			return false;
		}
		if(!comprueba2(cantidad)) {
			return false;
		}
		codigoBote = Integer.parseInt(potCode);
		dinero = Float.parseFloat(cantidad);
		if(controlador.searchBote2(codigoBote)) {
			if(controlador.getLeader(codigoBote).equals(MainController.elUsuario)) {
				if(controlador.aniadeDinero(codigoBote, dinero)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean comprueba2(String cadena) {
		try {
			Float.parseFloat(cadena);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean aniadePersona(String user, String potCode) {
		//el bote existe? aniades persona directa
		//sino, se crea y se pone al lider y luego se aniade
		int codigo;
		if(!comprueba(potCode)) {
			return false;
		}
		codigo = Integer.parseInt(potCode);
				if(controlador.aniadePersona(user, codigo)) {
					return true;
				}
		return false;
	}
	
	public String integrantes(int potCode) {
		return controlador.getIntegrantes(potCode);
	}
	
	public boolean aniadePersona(String user, String namePot, String potCode) {
		//el bote existe? aniades persona directa
		//sino, se crea y se pone al lider y luego se aniade
		int codigo;
		if(!comprueba(potCode)) {
			return false;
		}
		codigo = Integer.parseInt(potCode);
		if(controlador.searchBote(codigo, namePot)) {
			if(controlador.getLeader(codigo).equals(MainController.elUsuario)) {
				if(controlador.aniadePersona(user, namePot, codigo)) {
					return true;
				}
			}
			else {
				return false;
			}
			//aniadimos directamente la persona
		}
		else {
			//creamos el bote y aniadimos lider y la persona
			if(controlador.creaBote(namePot, codigo)) {
				if(controlador.aniadePersona(MainController.elUsuario, namePot, codigo)) {
					if(controlador.aniadePersona(user, namePot, codigo)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean search(int potCode) {
		if(controlador.searchBote2(potCode)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public float money(int potCode) {
		return controlador.getMoney(potCode);
	}
	
	public String leader(int potCode) {
		String respuesta = null;
		respuesta = controlador.getLeader(potCode);
		return respuesta;
	}
	
	public boolean comprueba(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean creaBote() {
		return true;
	}
}
