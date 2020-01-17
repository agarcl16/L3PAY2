package controlador;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pagoBote {
	
	@FXML
	public Button cancelar_pago;
	@FXML
	public TextField potCode;
	@FXML
	public TextField potCost;
	@FXML
	public TextField potConcept;
	@FXML
	public Label mensaje;
	
	private BoteDAO controlador;
	private int code;
	private float money;
	private EnviosVO envio;
	
	@FXML
	public void cancelar(ActionEvent event) {
		Stage stage = (Stage) cancelar_pago.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void aceptar(ActionEvent event) {
		controlador = new BoteDAO();
		if(potCode.getText().equals("")||potCost.getText().equals("")||potConcept.getText().equals("")) {
			mensaje.setText("Rellene todos los campos");
		}
		else if(comprueba(potCode.getText())) {
			mensaje.setText("Introduzca un codigo valido");
		}
		else if(comprueba2(potCost.getText())) {
			mensaje.setText("Introduzca una cantidad valida");
		}
		else {
			code = Integer.parseInt(potCode.getText());
			money = Float.parseFloat(potCost.getText());
			if(!controlador.search(code)) {
				mensaje.setText("No existe el bote");
			}
			else if(!controlador.leader(code).equals(MainController.elUsuario)) {
				mensaje.setText("Solo el lider del bote puede realizar los pagos");
			}
			else {
				float dinero = controlador.money(code);
				float newDinero = controlador.money(code) - dinero;
				if(newDinero<0) {
					mensaje.setText("No hay sufificente saldo");
				}
				boolean respuesta = controlador.pagoBote(code, newDinero);
				if(!respuesta) {
					mensaje.setText("Error al pagar");
				}
				else {
					envio = new EnviosVO();
					if(envio.aniadirMovimiento(potConcept.getText(), code, 0-money));
				}
			}
			
		}
	}
	public boolean comprueba(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean comprueba2(String cadena) {
		try {
			Float.parseFloat(cadena);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
