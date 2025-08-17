/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import models.FeastMenu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import models.Customers;
import models.Order;
public class FileUtils {
    
    public static final String filePath = "src/resources/FeastMenu.csv";
     private static final String filePathCustomer = "src/main/java/resources/Customer.dat";
    private static final String filePathOrder = "src/main/java/resources/Order.dat";
    
    public ArrayList <FeastMenu> readFeastMenusFromFile(){
        ArrayList<FeastMenu> feastMenus = new ArrayList<>();
        String line;
        
        File file = new File(filePath);
        
        if(!file.exists()){
            System.out.println("Cannot read data from "+filePath+ ". Please check it.");
            
        }
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        { 
           
            boolean isFirstLine = true ;
           
            while((line = br.readLine()) !=  null){
               if(isFirstLine){
                   isFirstLine = false;
                   continue;
               }
                String[] parts = line.split(",", 4);
                if(parts.length == 4){
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    
                    List<String> ingredients = new ArrayList<>();
                    String cleanedIngredients = parts[3].replace("\"","");
                    String [] ingredientsLine = cleanedIngredients.split("#");
                    for(String ing :ingredientsLine ){
                      ingredients.add(ing.trim());
                    }
                    FeastMenu feastMenu = new FeastMenu(code, name, price, ingredients);
                    feastMenus.add(feastMenu);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
        return feastMenus;
    }
     public void saveCustomerListToFile(List<Customers> customers) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathCustomer));
            oos.writeObject(customers);
            System.out.println("Save customers successfully!");
        } catch (Exception e) {
            System.out.println("ERROR Save Customer: " + e.getMessage());
        }
    }
    
    public List<Customers> loadCustomersFromFile() {
        List<Customers> customers = new ArrayList<>();
        File file = new File(filePathCustomer);
        if (!file.exists() || file.length() == 0) {
            System.err.println("File " + filePathCustomer + " does not exist!!!");
            return customers;
        }
        
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filePathCustomer));
            customers = (List<Customers>) oos.readObject();
            return customers;
        } catch (Exception e) {
            System.out.println("Error load file Customer: " + e.getMessage());
        }
        return customers;
    }
    
    public void saveOrdersToFile(List<Order> orders) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathOrder));
            oos.writeObject(orders);
            System.out.println("Save customers successfully!");
        } catch (Exception e) {
            System.out.println("ERROR Save Customer: " + e.getMessage());
        }
    }
    
    public List<Order> loadOrdersFile() {
        List<Order> orders = new ArrayList<>();
        File file = new File(filePathOrder);
        
        if (!file.exists() || file.length() == 0) {
            System.err.println("File " + filePathOrder + " does not exist!!!");
            return orders;
        }
        
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filePathOrder));
            orders = (List<Order>) oos.readObject();
            return orders;
        } catch (Exception e) {
            System.out.println("Error load file Customer: " + e.getMessage());
        }
        return orders;
    }
}
