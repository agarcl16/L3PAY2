package application;
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
public class Pedir_dinero {
	public procs controlador2;
	
	@FXML
	public Button cancelar_con2;
	@FXML
	public Button cancelar_sin2;
	
	@FXML
	public TextField name1;
	@FXML
	public TextField name2;
	@FXML
	public TextField phone2;
	@FXML
	public TextField cost1;
	@FXML
	public TextField cost2;
	@FXML
	private Label mensaje1;
	@FXML
	private Label mensaje2;
	
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
	@FXML
	public void pedirDinero1(ActionEvent event) {
		controlador2 = new procs();
		if(name1.getText().equals("")||cost1.getText().equals("")){
			mensaje1.setText("error");
		}
		else {
			//comprobamos con un if si existe el usuario
			boolean comprobacion = controlador2.search(name1.getText());
			if(comprobacion){
				mensaje1.setText("error");
			}
			else {
				mensaje1.setText("Su solicitud ha sido guardada y enviada");
			}
		}
	}
	@FXML
	public void pedirDinero2(ActionEvent event) {
		controlador2 = new procs();
		if((name2.getText().equals("")||(cost2.getText().equals("")&&phone2.getText().contentEquals("")))){
			mensaje2.setText("error");
		}
		else {
			//comprobamos con un if si existe el usuario
			boolean comprobacion = controlador2.search(name2.getText());
			if(comprobacion){
				mensaje2.setText("error");
			}
			else {
				mensaje2.setText("Su solicitud ha sido guardada y enviada");
			}
		}
	}
	
}
