/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class M_ApplyController implements Initializable {

    @FXML
    private TextField branches;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField restuName;

    @FXML
    private TextField usarName;
    @FXML
    private Label msg;
    
    @FXML
    private Button applyBt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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

    public void apply(ActionEvent event) throws IOException {
        if (restuName.getText().isEmpty() || email.getText().isEmpty() || usarName.getText().isEmpty() || phone.getText().isEmpty() || branches.getText().isEmpty()) {
            msg.setText("pleas fill all the information");
            msg.setStyle("-fx-text-fill: red");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<partnership> pList = null;
            Query query = session.createQuery("from partnership");
            pList = query.list();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();
            for (partnership p : pList) {
                Transaction tx = session.beginTransaction();
                partnership newPartner = new partnership(restuName.getText(), email.getText(), usarName.getText(), Integer.parseInt(phone.getText()), Integer.parseInt(branches.getText()));

                session.save(newPartner);
                tx.commit();
                java.io.File file = new java.io.File("C:\\Users\\noosa\\OneDrive\\سطح المكتب\\PartnerShip.txt");
                //"C:\Users\noosa\OneDrive\سطح المكتب\PartnerShip.txt"
//                java.io.File file = new java.io.File("C:\\Users\\noosa\\OneDrive\\سطح المكتب\\Database.txt");

        java.io.PrintWriter output = new java.io.PrintWriter(file);
                String temp = "Resturant Name: "+restuName.getText() + "\n" + "Email: "+email.getText() + "\n" +"user Name: "+ usarName.getText() + "\n" +"Phone Number: "+ phone.getText() + "\n" +"Number of branches: "+ branches.getText();
                output.println(temp);
                output.println();
            output.close();
                session.close();
            msg.setText("information has been send");
                msg.setStyle("-fx-text-fill: red");
            }
        }

    }

}
