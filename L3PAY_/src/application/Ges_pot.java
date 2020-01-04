package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
public class Ges_pot {

	private Stage primaryStage = new Stage();
	@FXML
	public Button cancel_gespot;
	@FXML
	public Button button_edit;
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancel_gespot.getScene().getWindow();
		stage.close();
	}
	
	public void editar(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Editar_bote.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
