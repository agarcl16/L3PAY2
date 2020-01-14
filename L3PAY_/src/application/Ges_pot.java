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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Ges_pot {

	private Stage primaryStage = new Stage();
	@FXML
	public Button cancel_gespot;
	@FXML
	public Button button_edit;
	@FXML
	public TextField namePot;
	@FXML
	public TextField dineroInicial;
	@FXML
	public TextField dineroRestante;
	@FXML
	public TextField dineroGastado;
	@FXML
	public Label mensaje;
	@FXML
	public Label mensajeIntegrantes;
	public static String codigoBote;
	
	private BoteDAO bote;
	
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancel_gespot.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void salirIntegrantes(ActionEvent event) {
		Stage stage = (Stage) cancel_gespot.getScene().getWindow();
		stage.close();
	}
	
	public void editar(ActionEvent event) throws Exception {
		codigoBote = namePot.getText();
		bote = new BoteDAO();
		if(namePot.getText().contentEquals("")) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		if(!comprueba(namePot.getText())) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		int potCode;
		potCode = Integer.parseInt(namePot.getText());
		if(!bote.search(potCode)) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		if(!bote.leader(potCode).equals(MainController.elUsuario)) {
			mensaje.setText("Usted no es el lider del bote");
			limpiaCajas();
		}		
		else {
			Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Editar_bote.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	
	@FXML 
	public void verIntegrantes(ActionEvent event) throws Exception{
		bote = new BoteDAO();
		if(namePot.getText().equals("")) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		if(!comprueba(namePot.getText())) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		int potCode;
		potCode = Integer.parseInt(namePot.getText());
		if(!bote.search(potCode)) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		String respuesta = bote.integrantes(potCode);
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Integrantes.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		mensajeIntegrantes.setText(respuesta);
	}
	
	@FXML
	public void buscaBote(ActionEvent event) throws Exception{
		bote = new BoteDAO();
		if(namePot.getText().equals("")) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		if(!comprueba(namePot.getText())) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		int potCode;
		potCode = Integer.parseInt(namePot.getText());
		if(!bote.search(potCode)) {
			mensaje.setText("No existe ese bote");
			limpiaCajas();
		}
		if(!bote.leader(potCode).equals(MainController.elUsuario)) {
			mensaje.setText("Usted no es el lider del bote");
			limpiaCajas();
		}
		else {
			float dineroActual = bote.money(potCode);
			if(dineroActual==-1) {
				mensaje.setText("No habia dinero en este bote");
				limpiaCajas();
			}
			else {
				dineroRestante.setText(String.valueOf(dineroActual));
			}
		}
	}
	
	public void limpiaCajas() {
		namePot.setText("");
		dineroInicial.setText("");
		dineroRestante.setText("");
		dineroGastado.setText("");
	}
	
	public boolean comprueba(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
