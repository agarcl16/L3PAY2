package controlador;

public class BoteDAO {
	private BoteVO controlador;
	public BoteDAO() {
		controlador = new BoteVO();
	}
	public boolean aniadeDinero(String potCode, String cantidad){
		EnviosVO envios= new EnviosVO();
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
				String[] array = new String[99];
				array = controlador.getIntegrantes(codigoBote).split(",");
				int personas = array.length;
				int i;
				float aPagar = dinero/personas;
				for(i=0;i<personas;i++) {
					if((controlador.getDineroCuenta(array[i])-aPagar)<0) {
						return false;
					}
					if(!controlador.updateUserMoney(array[i], controlador.getDineroCuenta(array[i])-aPagar)) {
						return false;
					}
					envios.aniadirMovimiento(array[i]+" pago al bote "+potCode, envios.getCuenta(array[i]), 0-aPagar);
				}
				if(controlador.aniadeDinero(codigoBote, dinero)&&controlador.aniadeDinero2(codigoBote, dinero)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean aniadeDineroBote(String potCode, String cantidad) {
		EnviosVO envios= new EnviosVO();
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
				String[] array = new String[99];
				array = controlador.getIntegrantes(codigoBote).split(",");
				int personas = array.length;
				int i;
				float aPagar = dinero/personas;
				for(i=0;i<personas;i++) {
					if((controlador.getDineroCuenta(array[i])-aPagar)<0) {
						return false;
					}
					if(!controlador.updateUserMoney(array[i], controlador.getDineroCuenta(array[i])-aPagar)) {
						return false;
					}
					envios.aniadirMovimiento(array[i]+" pago al bote "+potCode, envios.getCuenta(array[i]), 0-aPagar);
				}
				
				if(controlador.updatePotMoney(codigoBote, dinero)) {
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
	
	public boolean pagoBote(int code, float cantidad) {
		boolean respuesta = controlador.pagoBote(code, cantidad);
		return respuesta;
	}
	
	public boolean removeUser(String user) {
		return controlador.removeUser(user);
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
	
	public float money2(int potCode) {
		return controlador.getMoney2(potCode);
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
