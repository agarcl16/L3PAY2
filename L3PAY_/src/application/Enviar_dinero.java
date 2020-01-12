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
	public procs controlador2;
	private int contador=0;
	private EnviosDAO envio;
	
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
		envio = new EnviosDAO();
		controlador2 = new procs();
		String truePassword = controlador2.searchPassword(MainController.elUsuario);
		if(name1.getText().equals("")||cost1.getText().equals("")||password1.getText().equals("")){
			mensaje1.setText("error");
		}
		else if(truePassword!=password1.getText()) {
			mensaje1.setText("contrasena invalida");
		}
		else {

			//comprobamos con un if si existe el usuario
			boolean comprobacion = controlador2.search(name1.getText());
			if(!comprobacion){
				mensaje1.setText("error. No existe ese ususario");
			}
			
			else {
				if(envio.enviarDinero(MainController.elUsuario, name1.getText(), cost1.getText())) {
					mensaje1.setText("Su solicitud ha sido guardada y enviada");
					this.contador++;
				}
				else {
					mensaje1.setText("Error en el envio");
				}
			}
		}
	}
	@FXML
	public void enviarDinero2(ActionEvent event) {
		envio = new EnviosDAO();
		controlador2 = new procs();
		String truePassword = controlador2.searchPassword(MainController.elUsuario);
		if((password2.getText().equals("")||cost2.getText().equals("")||(name2.getText().equals("")&&phone2.getText().contentEquals("")))){
			
			mensaje2.setText("error. No existe el ususario");
		}
		else if(truePassword!=password2.getText()) {

			mensaje2.setText("error. Contrasena invalida");
		}
		else {
			//comprobamos con un if si existe el usuario
			//comprobar cual está rellenadoa
			if(!name2.getText().equals("")){
				boolean comprobacion = controlador2.search(name2.getText());
				if(!comprobacion){
					mensaje2.setText("error. No existe el ususario");
				}
				else {
					if(envio.enviarDinero(MainController.elUsuario, name2.getText(), cost2.getText())) {
						mensaje2.setText("Su solicitud ha sido guardada y enviada");
					//envio.enviarDinero(controlador.getUser(), name2.getText());
						this.contador++;
					}
					else {
						mensaje2.setText("Error en el envio");
					}
				}
			}
		}
	}
}
