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
@Table(name="tables")
public class tables  implements java.io.Serializable {

     @Id
     @Column(name="numberOfTabels")
     private int numberOfTabels;

    public tables() {
    }

    public tables(int numberOfTabels) {
        this.numberOfTabels = numberOfTabels;
    }

    public int getNumberOfTabels() {
        return numberOfTabels;
    }

    public void setNumberOfTabels(int numberOfTabels) {
        this.numberOfTabels = numberOfTabels;
    }
     
     

}
