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
		System.out.println("hola2");
		//el bote existe? aniades persona directa
		//sino, se crea y se pone al lider y luego se aniade
		if(controlador.searchBote(namePot)) {
			//aniadimos directamente la persona
		}
		else {
			//creamos el bote y aniadimos lider y la persona
			if(controlador.creaBote(namePot)) {
				System.out.println("hola3");
				if(controlador.aniadePersona(MainController.elUsuario, namePot)) {
					System.out.println("hola4");
					if(controlador.aniadePersona(user, namePot)) {
						System.out.println("hola5");
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
