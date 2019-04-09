package controllers;
	
import java.util.List;

import entities.Client;
import entities.Contract;
import entities.Guarantee;
import entities.Housing;
import entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.Test;

public class Main1 extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
    // Parent root = FXMLLoader.load(getClass().getResource("AddContractHousingView.fxml"));
      Parent root = FXMLLoader.load(getClass().getResource("/views/Contracthousingview.fxml"));
    // Parent root = FXMLLoader.load(getClass().getResource("AddUserforHousingView.fxml"));

        Scene scene = new Scene(root,Color.BEIGE);
      
        primaryStage.setScene( scene);
        //set stage borderless
     //  primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
        
        Test t = new Test();
       User u = new User();
        
	

       /* List<Guarantee> Contract  = t.findguranteesbyhousingContract();
        System.out.println( Contract.size());
		for (int i=0; i<Contract.size(); i++){
			System.out.println("Element "+i+Contract.get(i).getDescription()+"   type  "+Contract.get(i).getRefund());}*/
    }


    public static void main(String[] args) {
        launch(args);
    }}
