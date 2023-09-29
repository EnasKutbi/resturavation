/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author shamo
 */
public class U_moerController implements Initializable {
    @FXML
    private Button logout;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       public void more(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }

    public void home(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_home.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    public void reser(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_reservations.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    
    public void toPartner(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("M_partner.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
        @FXML
       public void aboutUs(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("about_us.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    @FXML
              public void prof(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_profile.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
        

    }
              public void showst(ActionEvent event) throws IOException{
                  Parent root = FXMLLoader.load(getClass().getResource("M_statistice.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
              }
              
              public void addRes(ActionEvent event) throws IOException{
                  Parent root = FXMLLoader.load(getClass().getResource("addRestaurant.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
              }
              
              public void logout(ActionEvent event) throws IOException{
                  Parent root = FXMLLoader.load(getClass().getResource("logo.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
              }
              public void editM(ActionEvent event) throws IOException{
                  Parent root = FXMLLoader.load(getClass().getResource("m_profile.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
              }
 
}
