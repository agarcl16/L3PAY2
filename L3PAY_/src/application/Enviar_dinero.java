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
public class Enviar_dinero {
	private int contador=0;
	private Envios envio;
	private MainController controlador;
	@FXML
	public Button cancelar_con;
	@FXML
	public Button cancelar_sin;
	
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
	public TextField password1;
	@FXML
	public TextField password2;
	
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
	
	@FXML
	public void enviarDinero1(ActionEvent event) {
		if(name1.getText().equals("")||cost1.getText().equals("")||password1.getText().equals("")){
			mensaje1.setText("error");
		}
		else {
			//comprobamos con un if si existe el usuario
			boolean comprobacion = search(name1.getText());
			if(comprobacion){
				mensaje1.setText("error");
			}
			else {
				mensaje1.setText("Su solicitud ha sido guardada y enviada");
				envio.enviarDinero(controlador.getUser(), name1.getText());
				this.contador++;
			}
		}
	}
	@FXML
	public void enviarDinero2(ActionEvent event) {
		if((password2.getText().equals("")||name2.getText().equals("")||(cost2.getText().equals("")&&phone2.getText().contentEquals("")))){
			
			mensaje2.setText("error");
		}
		else {
			//comprobamos con un if si existe el usuario
			boolean comprobacion = search(name2.getText());
			if(comprobacion){
				mensaje2.setText("error");
			}
			else {
				mensaje2.setText("Su solicitud ha sido guardada y enviada");
				envio.enviarDinero(controlador.getUser(), name2.getText());
				this.contador++;
			}
		}
	}
}
