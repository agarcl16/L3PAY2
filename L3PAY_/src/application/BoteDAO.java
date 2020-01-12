package application;

public class BoteDAO {
	private BoteVO controlador;
	public BoteDAO() {
		controlador = new BoteVO();
	}
	public boolean aniadeDinero(){
		return true;
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
