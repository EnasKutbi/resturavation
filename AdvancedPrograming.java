/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AdvancedPrograming extends Application {
    
    public static String restuarantName;
    public static String time;
    public static String date;
    
    public static String customerName;
    public static String cutomrePassword;
    public static String cutomerEmail;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("logo.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    

    /**
     * @param args the command line arguments*/
     }
     
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}