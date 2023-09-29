/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedprograming;

/**
 *
 * @author noosa
 */
public class globalUser {
    static customer customername = new customer();
    static String customerName = customername.getName();
    
    static customer customeremail = new customer();
    static String customerEmail = customeremail.getEmail();
    
    
    static theAdmin adminname = new theAdmin();
    static String adminName = adminname.getAdminName();
    
    static theAdmin adminemail = new theAdmin();
    static String adminEmail = adminemail.getEmail();
    
    
}
