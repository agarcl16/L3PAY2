package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class L3PAY {
	
	private Stage primaryStage = new Stage();
	
	@FXML
	public Button cancelar_l3pay;
	@FXML
	private Label userName;
	
	public L3PAY() {
		
	}
	
	public void vincular() throws Exception {
		userName.setText(MainController.elUsuario);
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/vincular_cuenta.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_l3pay.getScene().getWindow();
		stage.close();
	}
	
	public void sendMoney(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Enviar_dinero.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void pedirDinero(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Pedir_dinero.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void crearBote(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Crear_bote.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void gesPot(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Ges_pot.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void ingresar(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Ingresar.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void enviar(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Enviar.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
