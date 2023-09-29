/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author noosa
 */
public class TabelsController implements Initializable {
    
    @FXML
    private Button confirm;
    
    @FXML
    private Button t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    
    private ComboBox<U_homeController> restu, time ;
    private U_homeController date;
    
    int tableN =0;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            List<booking> cList = null;
            //userName = '"+globalUser.customerName+"'" +"'
            Query query = session.createQuery("from booking where restaurantName = '"+AdvancedPrograming.restuarantName+
                    "' and date = '"+AdvancedPrograming.date+
                    "' and time = '"+AdvancedPrograming.time+"'");
            cList = query.list();
            session.close();
            for (booking c : cList){
                if (c.getNumberOfTabel()==1) {
                    t1.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==2) {
                    t2.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==3) {
                    t3.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==4) {
                    t4.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==5) {
                    t5.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==6) {
                    t6.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==7) {
                    t7.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==8) {
                    t8.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==9) {
                    t9.setStyle("-fx-color:red");
                }if (c.getNumberOfTabel()==10) {
                    t10.setStyle("-fx-color:red");
                }
            }
    }    
    
    
    @FXML
    public void choose(ActionEvent event) throws IOException{
        
            Button b = (Button) event.getSource();
        tableN = Integer.parseInt(b.getText());
        b.setStyle("-fx-color:red");
        
        
    }
    @FXML
    public void confirm(ActionEvent event) throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
//            List<booking> bList = null;
//            Query query = session.createQuery("from booking");
//            bList = query.list();
//            session.close();
//            for (booking b : bList) {
                booking newbook = new booking(globalUser.customerName, AdvancedPrograming.restuarantName, AdvancedPrograming.time, AdvancedPrograming.date,tableN);
            session.save(newbook);
            tx.commit();
            session.close();
//            }
        
        Parent root = FXMLLoader.load(getClass().getResource("u_reservations.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Window.setUserData(restu.getValue());
//        Window.setUserData(time.getValue());
//        Window.setUserData(date);
        Window.setScene(roott);
        Window.show();
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
    
}