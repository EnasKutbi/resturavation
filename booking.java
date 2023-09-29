/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="booking")
public class booking  implements java.io.Serializable {

     @Id
     @Column(name="userName")
     private String name;
     @Column(name="restaurantName")
     private String restaurantName;
     @Column(name="time")
     private String time;
     @Column(name="date")
     private String date;
     @Column(name="numderOfTabel")
     private int numderOfTabel;

    public booking() {
    }

    public booking(String name, String restuarantName, String time, String date, int numderOfTabel) {
        this.name = name;
        this.restaurantName = restuarantName;
        this.time = time;
        this.date = date;
        this.numderOfTabel = numderOfTabel;
    }

    public booking(String name, String restuarantName, String time, String date) {
        this.name = name;
        this.restaurantName = restuarantName;
        this.time = time;
        this.date = date;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestuarantName() {
        return restaurantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restaurantName = restuarantName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfTabel() {
        return numderOfTabel;
    }

    public void setNumberOfTabel(int numberOfTabel) {
        this.numderOfTabel = numberOfTabel;
    }
     
     
     
     

}