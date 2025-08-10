/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import models.Customers;
import utils.Input;
import utils.Validation;

public class CustomerController {
    ArrayList<Customers> listCustomer = new ArrayList<>();
    Input input = new Input();
    Validation validation = new Validation();
    
    public void registerCustomer(){
        String code;
        String name;
        String email;
        String phone;
        do {
        code = input.inputRegex("^[CGK]\\d{4}$","Enter your code");
        }while(!validation.isValidCustomerCode(code, listCustomer));
        
        name = input.inputRegex(".{2,25}$","Enter your name");
        
        email = input.inputRegex("^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,63}$","Enter your email");
        
        phone = input.inputRegex("^\\d{10}$","Enter your phone");
        
        Customers customers = new Customers(code, name, phone, email);
        
        listCustomer.add(customers);
        for(Customers customer : listCustomer){
            System.out.println("code:"+ customer.getCustomerCode());
        }
}
}
