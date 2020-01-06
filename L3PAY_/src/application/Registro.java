package application;

public class Registro {
	private int numero;
	public Registro() {
		this.numero = 0;
	}
	public boolean aniadirPersona(String name, String surname, String personalID, String number, String user, String password) {
		if(this.numero == 0) {
			//Aqui se aniade
			this.numero++;
			return true;
		}
		else {
			int i;
			for(i=0; i<this.numero;i++ ) {
				//aqui se comprueba toda la lista si concuerda con alguno
				if(true) {
					return false;
				}
			}
			//Si llega aqui es que hay que aniadirlo
			this.numero++;
			return true;
		}
		
	}
}
