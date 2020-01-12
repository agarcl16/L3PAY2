package application;

public class BoteVO {
	private procs controlador;
	public BoteVO() {
		controlador = new procs();
	}
	public boolean creaBote(String namePot) {
		System.out.println("hola2.1");
		if(controlador.creaBote(namePot, MainController.elUsuario)) {
				System.out.println("hola 2.2");
			return true;
		}
		return false;
	}
	public boolean aniadePersona(String usuario, String bote) {
		System.out.println("hola3.1");
		int pot = controlador.searchPot(bote);
		if(pot==-1) {
			return false;
		}
		else {
			System.out.println("hola3.2");
			if(controlador.search(usuario)) {
				System.out.println("hola3.3");
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
		return false;
	}
}
