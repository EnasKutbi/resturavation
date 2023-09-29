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
@Table(name="customer")
public class customer  implements java.io.Serializable {

     @Id
     @Column(name="userName")
     private String userName;
     @Column(name="email")
     private String email;
     @Column(name="password")
     private String password;

    public customer() {
    }


    public customer(String name, String password) {
       
       this.userName = name;
       this.password = password;
    }

    public customer(String email, String name, String password) {
        this.email = email;
        this.userName = name;
        this.password = password;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    



}
