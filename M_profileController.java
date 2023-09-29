/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shamo
 */
public class M_profileController implements Initializable {
    
    @FXML
    private Label email;

    @FXML
    private Button login1;

    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.setText(globalUser.adminEmail);
        name.setText(globalUser.adminName);
        
        
    }

    public void editprofile(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("m_editProfile.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    
       public void mMore(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("M_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
       
       
    

}
