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
import javafx.stage.Stage;
public class Enviar_dinero {
	
	@FXML
	public Button cancelar_con;
	@FXML
	public Button cancelar_sin;
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) cancelar_con.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void cancel2() {
		Stage stage = (Stage) cancelar_sin.getScene().getWindow();
		stage.close();
	}
}
