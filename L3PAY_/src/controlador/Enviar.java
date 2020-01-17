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
import javafx.stage.Stage;
public class Enviar {

	@FXML
	public Button cancelar_env;
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_env.getScene().getWindow();
		stage.close();
	}
	
}