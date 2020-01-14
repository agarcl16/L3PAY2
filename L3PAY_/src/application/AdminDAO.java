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
public class AdminDAO {

	@FXML
	public Button cancel;
	
	private AdminVO controlador;
	
	@FXML
	public TextField user;
	@FXML
	public TextField cuenta;
	@FXML
	public TextField bote;
	@FXML
	public Label mensaje;
	
	@FXML
	public void cancelar(ActionEvent event) {
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void removeUser(ActionEvent event) {
		controlador = new AdminVO();
		if(user.getText().equals("")) {
				mensaje.setText("Introduce un nombre de usuario");
				limpiaCajas();
		}
		else if(!controlador.searchUser(user.getText())) {
			mensaje.setText("Introduce un nombre de usuario existente");
			limpiaCajas();
		}
	}
	
	@FXML
	public void removeAccount(ActionEvent event) {
		controlador = new AdminVO();
		
	}
	
	@FXML
	public void removePot(ActionEvent event) {
		controlador = new AdminVO();
		
	}
	
	@FXML
	public void restaura(ActionEvent event) {
		Restauracion reset = new Restauracion();
		reset.restaura();
	}
	
	public void limpiaCajas() {
		user.setText("");
		cuenta.setText("");
		bote.setText("");
	}
	
}
