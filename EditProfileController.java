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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class EditProfileController implements Initializable {

    @FXML
    private TextField email, usarName;
    @FXML
    private Label emailmsg;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

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
    
    public void editM(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("m_editProfile.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
    }
    
    public void mMore(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("M_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
    }

    public boolean chickAdmin() {
        if (usarName.getText().isEmpty() || password.getText().isEmpty()) {
            emailmsg.setText("Enter your name and password");
            emailmsg.setStyle("-fx-text-fill: red");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<theAdmin> aList = null;
            Query query = session.createQuery("from theAdmin");
            aList = query.list();
            session.close();
            for (theAdmin a : aList) {
                if (email.getText().toLowerCase().equals(a.getEmail().toLowerCase())) {
                    if (email.getText().matches("^(.+)@(.+)$*")) {
                        session = HibernateUtil.getSessionFactory().openSession();
                        theAdmin newAdmin = new theAdmin(a.getEmail(), usarName.getText(), password.getText());
                        Transaction tx = session.beginTransaction();
                        session.update(newAdmin);
                        tx.commit();
                        session.close();
                        emailmsg.setText("information updated successfully");
                        emailmsg.setStyle("-fx-text-fill: black");
                        return true;
                    } else {
                        emailmsg.setText("you can't change the email");
                        emailmsg.setStyle("-fx-text-fill: red");
                    }
                }
            }

        }
        return false;
    }

    public void edit(ActionEvent event) throws IOException {
        if (usarName.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            emailmsg.setText("pleas Enter all information");
            emailmsg.setStyle("-fx-text-fill: red");
        } else {
            if (chickAdmin()) {

            } else {
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<customer> cList = null;
                Query query = session.createQuery("from customer");
                cList = query.list();
                session.close();
                for (customer c : cList) {
                    if (c.getName().equals(usarName.getText())) {
                        if (email.getText().matches("^(.+)@(.+)$*")) {
                            session = HibernateUtil.getSessionFactory().openSession();
                            customer newCustomer = new customer(email.getText(), c.getName(), password.getText());
                            Transaction tx = session.beginTransaction();
                            session.update(newCustomer);
                            tx.commit();
                            session.close();
                            emailmsg.setText("information updated successfully");
                            emailmsg.setStyle("-fx-text-fill: red");
                        } else {
                            emailmsg.setText("invalid email");
                            emailmsg.setStyle("-fx-text-fill: red");
                        }
                    } else {
                        emailmsg.setText("you can't change the name");
                        emailmsg.setStyle("-fx-text-fill: red");
                    }
                }
            }
        }
    }

}
