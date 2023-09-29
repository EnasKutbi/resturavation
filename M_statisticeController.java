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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class M_statisticeController implements Initializable {
    
    @FXML
    private ComboBox<String> restura;

    @FXML
    private Button show;

    @FXML
    private DatePicker theDate;
    
    @FXML
    private Label number;


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
        restura.setValue("Select restuarant");
        restura.getItems().add(c.getRestaurant());
            }
    }   
    public void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("M_statistice.fxml"));
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
    
    public void Show(ActionEvent event) throws IOException{
        Session session = HibernateUtil.getSessionFactory().openSession();
            List<booking> cList = null;
            Query query = session.createQuery("from booking where date = '"+theDate.getValue()+
                    "' and restaurantName = '"+restura.getValue()+"'");
            cList = query.list();
            session.close();
            
            number.setText(String.valueOf(cList.size()));
            number.setStyle("-fx-text-fill: white");
            
    }
    public void mMore(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("M_moer.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setScene(roott);
        Window.show();
    }
    
}
