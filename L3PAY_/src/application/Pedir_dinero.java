package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
public class Pedir_dinero {
	
	@FXML
	public Button cancelar_con2;
	@FXML
	public Button cancelar_sin2;
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) cancelar_con2.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void cancel2() {
		Stage stage = (Stage) cancelar_sin2.getScene().getWindow();
		stage.close();
	}
}
