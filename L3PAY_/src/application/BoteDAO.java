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
		if(controlador.searchBote(namePot)) {
			//aniadimos directamente la persona
		}
		else {
			//creamos el bote y aniadimos lider y la persona
			if(controlador.creaBote(namePot, codigo)) {
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
