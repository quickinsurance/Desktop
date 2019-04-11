package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.scene.Node;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;

public class LoginController implements Initializable {

	@FXML
	private AnchorPane anchorLogin;

	@FXML
	private JFXTextField emailTxt;

	@FXML
	private JFXPasswordField passwordTxt;

	@FXML
	private Button loginBtn;

	public User ServicefindUserByEmail(String email) throws Exception {
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.getUserByEmail(email);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void loginAction(ActionEvent event) throws Exception {

		if (emailTxt.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Insert your Email");
			alert.setHeaderText("Insert your Email");
			alert.setContentText("Insert your Email");

			alert.showAndWait();

		} else if (passwordTxt.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Insert your Password");
			alert.setHeaderText("Insert your Password");
			alert.setContentText("Insert your Password");

			alert.showAndWait();
		}

		User user = new User();

		user.setEmail(emailTxt.getText());
		user = ServicefindUserByEmail(user.getEmail());
		if (user != null) {
			if (user.getEmail().equals(emailTxt.getText()) && user.getCode().equals(passwordTxt.getText())) {
				if (user.getRole().equals("Agent")) {

					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SecondMain.fxml"));
					Parent root1 = (Parent) loader.load();
					Scene scene = new Scene(root1);
					primaryStage.setScene(scene);
					SecondMainController mainController = loader.<SecondMainController>getController();
					mainController.setIdUser(user.getId());
					Stage stage = (Stage) loginBtn.getScene().getWindow();
					stage.close();
					primaryStage.show();

				} else if (user.getRole().equals("Admin")) {
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AdminMainView.fxml"));
					Parent root1 = (Parent) loader.load();
					Scene scene = new Scene(root1);
					primaryStage.setScene(scene);
					AdminMainController mainController = loader.<AdminMainController>getController();
					mainController.setIdUser(user.getId());
					Stage stage = (Stage) loginBtn.getScene().getWindow();
					stage.close();
					primaryStage.show();

				} else if (user.getRole().equals("Expert")) {

					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/expertMain.fxml"));
					Parent root1 = (Parent) loader.load();
					Scene scene = new Scene(root1);
					primaryStage.setScene(scene);
					ExpertMainController mainController = loader.<ExpertMainController>getController();
					mainController.setIdUser(user.getId());
					Stage stage = (Stage) loginBtn.getScene().getWindow();
					stage.close();
					primaryStage.show();

				}
				else {

					Alert alert = new Alert(AlertType.ERROR);

					alert.setTitle("Error  ");
					alert.setHeaderText("This account doesn't exist ! ");
					alert.setContentText("This account doesn't exist ! ");

					alert.showAndWait();
				}

			} else {
				Alert alert = new Alert(AlertType.ERROR);

				alert.setTitle("Wrong Password ! ");
				alert.setHeaderText("Wrong Password ! ");
				alert.setContentText("Wrong Password ! ");
				alert.showAndWait();

			}
		} else {

			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Error  ");
			alert.setHeaderText("This account doesn't exist ! ");
			alert.setContentText("This account doesn't exist ! ");

			alert.showAndWait();
		}

	}
}

