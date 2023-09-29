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
@Table(name="theAdmin")
public class theAdmin  implements java.io.Serializable {

     @Id
     @Column(name="email")
     private String email;
     @Column(name="adminName")
     private String adminName;
     @Column(name="password")
     private String password;

    public theAdmin() {
    }

    public theAdmin(String email, String adminName, String password) {
        this.email = email;
        this.adminName = adminName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
     
     
}
