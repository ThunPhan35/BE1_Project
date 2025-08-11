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
public class FileUtils {
    
    public static final String filePath = "src/resources/FeastMenu.csv";
    
    
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
}
