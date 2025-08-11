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
        String code;
        String name;
        String email;
        String phone;
    public void registerCustomer(){
      
        do {
        code = input.inputRegex("^[CGK]\\d{4}$","Enter your code");
        }while(!validation.isValidCustomerCode(code, listCustomer));
        
        name = input.inputRegex(".{2,25}$","Enter your name");
        
        email = input.inputRegex("^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,63}$","Enter your email");
        
        phone = input.inputRegex("^\\d{10}$","Enter your phone");
        
        Customers customers = new Customers(code, name, phone, email);
        
        listCustomer.add(customers);
        }
    public void updateCustomer(){
        String code = input.inputRegex("^[CGK]\\d{4}$","Enter your code");
        
        Customers customer = findCustomerByCode(code);
        if(customer != null)
        {
        name = input.inputRegex(".{2,25}$","Enter your name");
        
        email = input.inputRegex("^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,63}$","Enter your email");
        
        phone = input.inputRegex("^\\d{10}$","Enter your phone");
          
        
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phone);
        
        System.out.println("Update Successfully");
        }
        else
        {
            System.out.println("Customer does not exist");
        }
}
    public Customers findCustomerByCode(String code){
         for(int i=0;i<=listCustomer.size();i++ ){
             Customers currentCustomer = listCustomer.get(i);
             String currentCode = currentCustomer.getCustomerCode();
             if(code.equals(currentCode)){
                 return currentCustomer;
             }
         }
         return null;
     } 
    public void findCustomerByKeyword(){
        String keyword = input.inputRegex("^\\w$","Enter your keyword");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-6s | %-25s | %-11s | %-25s%n", "Code", "Customer Name", "Phone", "Email");
        System.out.println("-----------------------------------------------------------");
        for(Customers customer : listCustomer){
            if(customer.getName().contains(keyword)){
                System.out.printf("| %-6s | %-25s | %-11s | %-25s |",
                        customer.getCustomerCode(),customer.getName(),
                        customer.getPhoneNumber(),customer.getEmail());
            }
        System.out.println("-----------------------------------------------------------");
        }
        
    }
}
   