/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import models.Customers;
import models.FeastMenu;
import models.Order;
import utils.FileUtils;
import utils.Input;
import utils.Validation;

/**
 *
 * @author Tcp35
 */
public class OrderController {
     Input input = new Input();
    
    List<Customers> customers;
    
    List<Order> orders; 
        
    List<FeastMenu> feastMenus; 

    FileUtils fileUtils = new FileUtils();
    
    Validation validation = new Validation();
    
    MenuController menuController = new MenuController();
    public void placeOrder(){
           customers = fileUtils.loadCustomersFromFile();
           orders = fileUtils.loadOrdersFile();
           feastMenus = fileUtils.readFeastMenusFromFile();
        String customerCode;
        String menuCode;
        int numberOfTable;
            do {
            customerCode = input.inputRegex("Enter Your CustomerCode: ", "^[CGK]\\d{4}$");
        } while (!validation.isValidCustomerCode(customerCode, (ArrayList<Customers>) customers));
        
        menuController.displayMenu();
        
        do {            
            menuCode = input.inputString("Enter Your SetMenu");
            if (!validation.isValidOrderCode(menuCode, feastMenus)) {
                System.err.println("SetMenuCode not found!");
            }
        } while (!validation.isValidOrderCode(menuCode, feastMenus));
        numberOfTable = input.inputInt("Enter your Number of Tables: ");
    }
    
    public void saveOrderToFile() {
        fileUtils.saveOrdersToFile(orders);
    }
}
