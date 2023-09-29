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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author shamo
 */
public class U_loginController implements Initializable {

    @FXML
    private Button dd;
    @FXML
    private Button login;
    @FXML
    private Label message;
    @FXML
    private PasswordField password;
    @FXML
    private TextField usarName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public boolean chickAdmin() {
        if (usarName.getText().isEmpty() || password.getText().isEmpty()) {
            message.setText("Enter your name and password");
            message.setStyle("-fx-text-fill: red");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            List<theAdmin> aList = null;
            Query query = session.createQuery("from theAdmin");
            aList = query.list();
            session.close();
            for (theAdmin a : aList) {
                if (usarName.getText().toLowerCase().equals(a.getAdminName().toLowerCase()) && password.getText().equals(a.getPassword())) {
                    globalUser.adminName = usarName.getText();
                    globalUser.adminEmail = a.getEmail();
                    return true;
                }
            }

        }
        return false;
    }

    public void singin(ActionEvent event) throws IOException {
        if (chickAdmin()) {
            Parent root = FXMLLoader.load(getClass().getResource("M_moer.fxml"));
            Scene roott = new Scene(root);

            Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Window.setScene(roott);
            Window.show();
        } else if (usarName.getText().isEmpty() || password.getText().isEmpty()) {
            message.setText("Enter your name and password");
            message.setStyle("-fx-text-fill: red");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<customer> cList = null;
            Query query = session.createQuery("from customer");
            cList = query.list();
            session.close();
            for (customer c : cList) {
                if (usarName.getText().toLowerCase().equals(c.getName().toLowerCase()) && password.getText().equals(c.getPassword())) {

                    globalUser.customerName = usarName.getText();
                    globalUser.customerEmail = c.getEmail();

                    Parent root = FXMLLoader.load(getClass().getResource("u_home.fxml"));
                    Scene roott = new Scene(root);

                    Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Window.setUserData(usarName.getText());
                    Window.setScene(roott);
                    Window.show();
                } else {
                    message.setText("invalid name or password");
                    message.setStyle("-fx-text-fill: red");
                }
            }

        }

    }

    public void singup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_singup.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }

}
