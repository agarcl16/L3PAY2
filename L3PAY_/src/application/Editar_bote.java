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
public class Editar_bote{

	@FXML
	public TextField usuarioAdd;
	@FXML
	public TextField usuarioRemove;
	@FXML
	public TextField dineroAdd;
	@FXML
	public Label mensaje;
	@FXML
	public Button cancel_edit;
	@FXML
	
	private BoteDAO bote;
	
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancel_edit.getScene().getWindow();
		stage.close();
	}
	
	@FXML 
	public void aceptar(ActionEvent event) {
		if(usuarioAdd.getText().equals("")&&usuarioRemove.getText().equals("")&&dineroAdd.getText().equals("")) {
			mensaje.setText("Rellene uno de los campos");
			limpiaCajas();
		}
		else if((!usuarioAdd.getText().equals("")&&!usuarioRemove.getText().equals("")&&!dineroAdd.getText().equals(""))||(!usuarioAdd.getText().equals("")&&!usuarioRemove.getText().equals(""))||(!usuarioRemove.getText().equals("")&&!dineroAdd.getText().equals(""))||(!usuarioAdd.getText().equals("")&&!dineroAdd.getText().equals(""))) {
			mensaje.setText("Rellene solo un campo por vez");
			limpiaCajas();
		}
		else {
			if(!usuarioAdd.getText().equals("")) {
				addUser(usuarioAdd.getText());
			}
			else if(!usuarioRemove.getText().equals("")) {
				removeUser(usuarioRemove.getText());
			}
			else if(!dineroAdd.getText().equals("")) {
				addMoney(dineroAdd.getText());
			}
		}
	}
	
	
	
	public void addUser(String user) {
		bote = new BoteDAO();
		if(bote.aniadePersona(user, Ges_pot.codigoBote)) {
			mensaje.setText("Persona anidadida correctamente");
		}
		else {
			mensaje.setText("No se ha podidio aniadir a la persona");
		}
	}
	
	public void removeUser(String user) {
		bote = new BoteDAO();
		
	}
	
	public void addMoney(String money) {
		bote = new BoteDAO();
		if(!bote.comprueba2(money)) {
			mensaje.setText("Introduzca un valor valido");
			limpiaCajas();
		}
		else {
			if(bote.aniadeDineroBote(Ges_pot.codigoBote,money)){
				mensaje.setText("Dinero anidadido correctamente");		
			}
		}
		
		
	}
	
	public void limpiaCajas() {
		usuarioAdd.setText("");
		usuarioRemove.setText("");
		dineroAdd.setText("");
	}
	
}