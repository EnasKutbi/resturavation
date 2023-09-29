/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.io.File;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author shamo
 */
public class U_homeController implements Initializable {
    
    @FXML
    private ComboBox<String> restu, time ;
    @FXML
    private Button next;
    @FXML
    private DatePicker date;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String[] timeGroup = new String[]{"9-11 AM", "11-1 PM", "1-3 PM", "3-5 PM", "5-7 PM", "7-9 PM", "9-11 PM", "11-1 AM"};
        time.setValue("choose time");
        time.getItems().addAll(timeGroup);

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<restaurants> cList = null;
        Query query = session.createQuery("from restaurants");
        cList = query.list();
        session.close();
        for (restaurants c : cList) {
            restu.setValue("Select restuarant");
            restu.getItems().add(c.getRestaurant());
        }
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
        
//        @FXML
//    void play (MouseEvent event) { 
//        String fileName = "audio1.mp3";
//        playHitSound(fileName);
//        
//    }
//    private void playHitSound (String fileName) {
//        String path = getClass().getResource(fileName).getPath(); 
//        System.out.println(path); 
//        Media media = new Media (new File(path).toURI().toString()); 
//        mediaPlayer = new MediaPlayer (media); 
//        mediaPlayer.setCycleCount (MediaPlayer.INDEFINITE); 
//        mediaPlayer.play(); }


        public void next(ActionEvent event) throws IOException{
             if (restu.getValue().equals("Select restuarant")) {
                message.setText("please select a restuarant");
                message.setStyle("-fx-text-fill: red");
            } else if (time.getValue().equals("choose time")) {
                message.setText("please chose the time");
                message.setStyle("-fx-text-fill: red");
            }else{
                
                AdvancedPrograming.restuarantName=restu.getValue();
                AdvancedPrograming.date = date.getValue().toString();
                AdvancedPrograming.time = time.getValue();
                 Parent root = FXMLLoader.load(getClass().getResource("tabels.fxml"));
        Scene roott = new Scene(root);

        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Window.setUserData(restu.getValue());
        Window.setUserData(time.getValue());
        Window.setUserData(date.getValue());
        Window.setScene(roott);
        Window.show();
             }
            
        }
        @FXML
    public void datePicker(ActionEvent evt){
        LocalDate localDate = date.getValue();
        String pattern = "MMMM dd, yyyy";
        String datePattern = localDate.format(DateTimeFormatter.ofPattern(pattern));
//        date.setText("Selected Date: "+datePattern);
    }

    public String getRestu() {
        return restu.getValue();
    }

    public String getTime() {
        return time.getValue();
    }

    public LocalDate getDate() {
        return date.getValue();
    }
        
    
}
