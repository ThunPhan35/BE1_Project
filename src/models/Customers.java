/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Tcp35
 */
public class Customers extend Person {
     private String customersCode ;

    public Customerss(String customersCode, String name, String phoneNumber, String mail) {
        super(name, phoneNumber, mail);
        this.customersCode = customersCode;
    }

    public Customerss() {
    }

    public String getCustomersCode() {
        return customersCode;
    }

    public void setCustomersCode(String customersCode) {
        this.customersCode = customersCode;
    }
   
    
}
