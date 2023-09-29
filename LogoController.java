package advancedprograming;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;



public class LogoController implements Initializable {

    @FXML
    private ImageView R;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(R);
        translate.setDuration(Duration.millis(1150));
        translate.setByY(-290);
        translate.play();

    }
    
    public void changeScene(MouseEvent event)throws IOException{
                Parent root = FXMLLoader.load(getClass().getResource("u_login.fxml"));
                Scene roott = new Scene(root);
                
                Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Window.setScene(roott);
                Window.show();
                
    }

}
