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
public class Crea_bote {

	@FXML
	public Button cancelar_pot;
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_pot.getScene().getWindow();
		stage.close();
	}
	 
}
