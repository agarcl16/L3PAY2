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

public class VinculacionController  {
	@FXML
	public Button cancelar_vin;
	@FXML
	public TextField numCuenta;
	@FXML
	public TextField claveCuenta;
	public procs controlador;
	@FXML
	private Label mensaje;
	public int recuento = 0;
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_vin.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void vincular(ActionEvent event) {
		if(numCuenta.equals("")||claveCuenta.equals("")) {
			mensaje.setText("Error en la vinculacion");
		}
		else if(numCuenta.getLength()!=9) {
			mensaje.setText("Error en la vinculacion");
		}
		else if(comprobacionNum(numCuenta.getText())) {
			mensaje.setText("Error en la vinculacion");
		}
		else {
			controlador = new procs();
				if(controlador.searchAccount(controlador.getDni(MainController.elUsuario))) {
					mensaje.setText("Error en la vinculacion. Ya tiene una cuenta asociada");
				}
				else {
					if(controlador.addAccount(Integer.parseInt(numCuenta.getText()),this.generarDinero())==true) {
						String dni = controlador.getDni(MainController.elUsuario);
						if(controlador.addAccount2(Integer.parseInt(numCuenta.getText()),dni)){
							mensaje.setText("Cuenta aceptada.");
							this.recuento++;
						}
					}
					else {
						mensaje.setText("Error en la vinculacion");
					}
				}
		}
		limpiarCajas();
	}
	
	public double generarDinero() {
		double retorna;
		retorna = (double)(Math.random()*(100000-10000+1)+10000);
		return retorna;
	}
	
	public void limpiarCajas() {
		numCuenta.setText("");
		claveCuenta.setText("");
	}
	
	public boolean comprobacionNum(String cadena) {
		try {
			Integer.parseInt(cadena);
			return false;
		}catch(NumberFormatException e) {
			return true;
		}
	}
	
}
