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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VinculacionController implements Initializable {
	ObservableList<String> bancos = FXCollections.observableArrayList();
	private L3PAY l3pay = new L3PAY();
	@FXML
	private ChoiceBox<String> listaBancos;
	
	@FXML
	public Button cancelar_vin;
	@FXML
	public TextField numCuenta;
	@FXML
	public TextField claveCuenta;
	
	
	public void initialize(URL url, ResourceBundle rb) {
		loadData();
	}
	private void loadData() {
		bancos.removeAll(bancos);
		String a = "Santander";
		String b = "BBVA";
		String c = "Sabadell";
		String d = "la Caixa";
		bancos.addAll(a,b,c,d);
		listaBancos.getItems().addAll(bancos);
	}
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_vin.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void vincular(ActionEvent event) {
		System.out.println("hola");
	}
	
}
