/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import models.Customers;
import models.FeastMenu;

public class Validation {
   
    
    public boolean isValidCustomerCode(String code, ArrayList<Customers> listCustomer){
        boolean check = true;
        for(Customers customer : listCustomer){
            if(customer.getCustomerCode().equals(code)){
                check = false;
            }
        }
        return check;
    }
    public boolean isValidOrderCode(String code, List<FeastMenu> feastMenus) {
        boolean check = false;
        for (FeastMenu feastMenu : feastMenus) {
            if (feastMenu.getCode().equals(code)) {
                check = false;
            }
        }
        return check;
    }
}

