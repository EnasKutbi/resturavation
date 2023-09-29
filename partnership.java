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
@Table(name="partnership")
public class partnership  implements java.io.Serializable {

     @Id
     @Column(name="resturantName")
     private String resturantName;
     @Column(name="email")
     private String email;
     @Column(name="userName")
     private String userName;
     @Column(name="phoneNumber")
     private int phoneNumber;
     @Column(name="numberOfBranches")
     private int numberOfBranches;

    public partnership() {
    }

    public partnership(String resturantName, String email, String userName, int phoneNumber, int numberOfBranches) {
        this.resturantName = resturantName;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.numberOfBranches = numberOfBranches;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }
     
     
     
}
