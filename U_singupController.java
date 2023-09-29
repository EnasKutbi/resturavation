/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author shamo
 */
public class U_singupController implements Initializable {

     @FXML
    private  TextField email,usarName;
    @FXML
    private Button login;
    @FXML
    private Label message,userNameLabel, emailLabel;
    @FXML
    private PasswordField password;

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }
    
    
    
    public void home(ActionEvent event) throws IOException {
        
        AdvancedPrograming.customerName = usarName.getText();
        AdvancedPrograming.cutomrePassword = password.getText();
        AdvancedPrograming.cutomerEmail = email.getText();
        
        if (usarName.getText().isEmpty() || password.getText().isEmpty() || email.getText().isEmpty()) {
            message.setText("please write your name, email and password");
            message.setStyle("-fx-text-fill: red");
        } else if (email.getText().matches("^(.+)@(.+)$*")) {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<customer> cList = null;
            Query query = session.createQuery("from customer");
            cList = query.list();
            session.close();
            for (customer c : cList) {
                if (email.getText().equals(c.getEmail())) {
                    message.setText("unavailable email");
                    message.setStyle("-fx-text-fill: red");

                } else if (usarName.getText().toLowerCase().equals(c.getName().toLowerCase())) {
                    message.setText("unavailable name");
                    message.setStyle("-fx-text-fill: red");
                } else {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            customer newuser = new customer(AdvancedPrograming.cutomerEmail, AdvancedPrograming.customerName, AdvancedPrograming.cutomrePassword );
            session.save(newuser);
            tx.commit();
            session.close();
//            globalUser.customerName = newuser.getName();
//            globalUser.customerEmail = newuser.getEmail();
//                    
                    Parent root = FXMLLoader.load(getClass().getResource("u_home.fxml"));
                    Scene roott = new Scene(root);

                    Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Window.setScene(roott);
                    Window.show();
                }
            }
        } else {
            message.setText("unavailable email");
            message.setStyle("-fx-text-fill: red");
        }

    }
    public void login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("u_login.fxml"));
                    Scene roott = new Scene(root);

                    Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Window.setScene(roott);
                    Window.show();
    }
    

}
