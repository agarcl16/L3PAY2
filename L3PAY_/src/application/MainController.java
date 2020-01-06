package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainController {
	
	private Stage primaryStage = new Stage();
	private Registro registro = new Registro();
	@FXML
	private Label myMessage2;
	@FXML
	private Label userName;
	@FXML
	private TextField usuario;
	@FXML
	private TextField contrasenia;
	@FXML
	private Button cancelar_reg;
	
	@FXML
	private TextField name;
	@FXML
	private TextField surname;
	@FXML
	private TextField personalID;
	@FXML
	private TextField number;
	@FXML
	private TextField user;
	@FXML
	private PasswordField password;
	@FXML
	private Label Mymessage;
	
	public MainController() {
		
	}
	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelar_reg.getScene().getWindow();
		stage.close();
	}
	
	public void iniciarSesion(ActionEvent event) throws Exception {
		//habria que comprobar en toda la base de datos
		if(usuario.getText().equals("lanerin") && contrasenia.getText().equals("Alex1990-")) {
			myMessage2.setText("Sign in Success");
				Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/L3PAY.fxml"));
				Scene scene = new Scene(root,600,600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
		}
		else {
			myMessage2.setText("Sign in Failed");
		}
	}
	
	public void registro(ActionEvent event) throws Exception{
		if(name.getText().equals("") || surname.getText().equals("") || personalID.getText().equals("") || number.getText().equals("") || user.getText().equals("") || password.getText().equals("")) {
			Mymessage.setText("Sign up Failed");
		}
		else if(personalID.getLength()!=9 || comprobacionID(personalID.getText().charAt(8) ) || comprobacionNum(personalID.getText().substring(0, 8))) {
			Mymessage.setText("Sign up Failed");
		}
		else if(number.getLength()!=9 || comprobacionNum(number.getText())) {
			Mymessage.setText("Sign up Failed");
		}
		else {
			if(registro.aniadirPersona(name, surname, personalID, number, user, password)){
				Mymessage.setText("Sign up Success");
			}
			else {
				Mymessage.setText("This user alredy exists");
			}
			
		}
	}
	public boolean comprobacionID(char a) {
		int i;
		for(i=65;i<91;i++) {
			if(a==i) {
				return false;
			}
		}
			return true;
	}
	public boolean comprobacionNum(String cadena) {
		try {
			Integer.parseInt(cadena);
			return false;
		}catch(NumberFormatException e) {
			return true;
		}
	}
	
}
