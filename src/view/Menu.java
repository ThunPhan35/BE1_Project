/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CustomerController;
import controller.MenuController;
import javax.xml.transform.OutputKeys;
import utils.Input;

public class Menu {
    Input input = new Input(); 
    CustomerController customerController = new CustomerController();
    MenuController menuController = new MenuController();
    public void mainMenu(){
        int choice;
        do{
            System.out.println("Welcome to the main menu");
            System.out.println("Please select your option following menu");
            System.out.println("1. Register customers.");
            System.out.println("2. Update customer information.");
            System.out.println("3. Search for customer information by name.");
            System.out.println("4. Display feast menus.");
            System.out.println("5. Place a feast order.");
            System.out.println("6. Update order information.");
            System.out.println("7. Save data to file.");
            System.out.println("8. Display Customer or Order lists.");
            System.out.println("Others- Quit.");
            
            choice = input.inputMenuChoice();
            
            switch(choice){
                case 1:
                    customerController.registerCustomer();
                    break;
                case 2:
                    customerController.updateCustomer();
                    break;
                case 3:
                    customerController.findCustomerByKeyword();
                    break;
                 case 4:
                    menuController.displayMenu();
                    break;
                 case 5:
                    
                    break;
                default:
                  System.out.println("Goodbye Boss, Exiting...");
            }
        }while(choice >=1 && choice < 9);
        
        
    }
}
