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
public class Crea_bote {

	@FXML
	public Button cancelar_pot;
	@FXML
	public TextField namePot;
	@FXML
	public TextField nameUser;
	@FXML
	public TextField costPot;
	@FXML
	private Label mensaje;
	public BoteDAO bote;
	
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_pot.getScene().getWindow();
		stage.close();
	}
	 
	@FXML 
	public void aniadirPersona(ActionEvent event) {
		bote = new BoteDAO();
		if(namePot.getText().equals("")||nameUser.getText().equals("")) {
			mensaje.setText("Error. Rellene todos los campos");
		}
		//if(nombre bote ya existe
		if(bote.aniadePersona(nameUser.getText(), namePot.getText())) {
			System.out.println("hola1");
			mensaje.setText("Creado correcto");
		}
		else {
			mensaje.setText("error al crear el bote");
		}
		
	}
	
	@FXML
	public void meterDinero(ActionEvent event) {
		
	}
	
}
