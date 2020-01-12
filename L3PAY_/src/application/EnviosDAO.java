package application;

public class EnviosDAO {
	private String sendUser;
	private String receiveUser;
	private double dinero;
	private int cuentaEnvia;
	private int cuentaRecibe;
	private double dineroEnvia;
	private double dineroRecibe;
	private double newDineroEnvia;
	private double newDineroRecibe;
	public EnviosDAO() {
		
	}
	public boolean enviarDinero(String userEnvia, String UserRecibe, String cantidad) {
		EnviosVO envia = new EnviosVO();
		this.sendUser = userEnvia;
		this.receiveUser  = UserRecibe;
		try {
			dinero = Double.parseDouble(cantidad);
			//Ahora sacamos los numero de cuenta de ambos usuarios
			cuentaEnvia = envia.getCuenta(this.sendUser);
			cuentaRecibe = envia.getCuenta(this.receiveUser);
			if(cuentaEnvia == -1 || cuentaRecibe == -1) {
				return false;
			}
			
			dineroEnvia = envia.getDinero(cuentaEnvia);
			dineroRecibe = envia.getDinero(cuentaRecibe);
			if(dineroEnvia - dinero < 0) {
				return false;
			}
			
			newDineroEnvia = dineroEnvia - dinero;
			newDineroRecibe = dineroRecibe + dinero;
			if(envia.enviarDinero(cuentaEnvia, newDineroEnvia)==false || envia.enviarDinero(cuentaRecibe, newDineroRecibe) == false){
				return false;
			}
			//aniadimos movimientos
			if((!envia.aniadirMovimiento("pago a "+this.receiveUser, cuentaEnvia, 0-dinero))||(!envia.aniadirMovimiento("pago de "+this.sendUser, cuentaRecibe, dinero))) {
				return false;
			}
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
