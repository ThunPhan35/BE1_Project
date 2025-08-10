/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Tcp35
 */
public class Customers extends Person {
   private String customerCode;

    public Customers() {
    }

    public Customers(String customerCode, String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
   

}
