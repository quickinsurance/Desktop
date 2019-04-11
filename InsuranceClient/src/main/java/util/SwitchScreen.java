package util;

import java.io.IOException;

import entities.Housing;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
    @FXML
    private AnchorPane pane2
 */
public class SwitchScreen {
    public void switchScreen(String screen,Button next) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) next.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
}