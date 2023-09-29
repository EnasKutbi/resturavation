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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author noosa
 */
public class AddRestaurantController implements Initializable {
    
     @FXML
    private TextField f;

    @FXML
    private ComboBox<String> r;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            List<restaurants> cList = null;
            Query query = session.createQuery("from restaurants");
            cList = query.list();
            session.close();
            for (restaurants c : cList){
        r.setValue("Select restuarant");
        r.getItems().add(c.getRestaurant());
            }
    }    
    
    public void add (ActionEvent event) {
            r.getItems().add(f.getText());
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            restaurants newuser = new restaurants(f.getText());
            session.save(newuser);
            tx.commit();
            session.close();
            f.clear();
        }
    
    @FXML
    public void more(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    @FXML
    public void home(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_home.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();

    }
    @FXML
        public void reser(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("u_reservations.fxml"));
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
    
}
