package application;

public class BoteDAO {
	private BoteVO controlador;
	public BoteDAO() {
		controlador = new BoteVO();
	}
	public boolean aniadeDinero(){
		return true;
	}
	public boolean aniadePersona(String user, String namePot) {
		//el bote existe? aniades persona directa
		//sino, se crea y se pone al lider y luego se aniade
		if(controlador.searchBote(namePot)) {
			//aniadimos directamente la persona
		}
		else {
			//creamos el bote y aniadimos lider y la persona
			if(controlador.creaBote(namePot)) {
				if(controlador.aniadePersona(MainController.elUsuario, namePot)) {
					if(controlador.aniadePersona(user, namePot)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	public boolean creaBote() {
		return true;
	}
}
