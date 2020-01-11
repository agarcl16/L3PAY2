package application;

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
public class Ingresar {
	private MainController controlador;
	private Ingreso nuevoIngreso;
	@FXML
	public Button cancelar_ing;
	@FXML
	public TextField cost;
	@FXML
	public TextField password;
	@FXML
	private Label mensaje;
	
	
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_ing.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void ingresar(ActionEvent event) {
		//comprobar contraseña
		/*if(nuevoIngreso.Ingresar(controlador.getUser(),cost.getText() )){
			mensaje.setText("El ingreso ha sido un exito");
		}*/
	}
	
}
