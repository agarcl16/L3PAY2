package application;

public class EnviosVO {
		public procs controlador;
		public EnviosVO() {
			controlador = new procs();
		}
		public int getCuenta(String user) {
			String dni;
			dni = controlador.getDni(user);
			int retorno;
			retorno = controlador.cuenta(dni);
			return retorno;
		}
		public double getDinero(int cuenta) {
			double retorno;
			retorno = controlador.dineroCuente(cuenta);
			return retorno;
		}
		
		public boolean enviarDinero(int cuenta, double cantidad) {
			boolean retorno;
			retorno = controlador.enviarDinero(cuenta, cantidad);
			return retorno;
		}
		public boolean aniadirMovimiento(String name, int cuenta, double dinero) {
			boolean retorno;
			retorno = controlador.aniadirMovimiento(name, cuenta, dinero);
			return true;
		}
}
