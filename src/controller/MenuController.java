/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Comparator;
import java.util.List;
import models.FeastMenu;
import utils.FileUtils;

/**
 *
 * @author Tcp35
 */
public class MenuController {
    
    List<FeastMenu> feastMenus;
    FileUtils file = new FileUtils();
    public void displayMenu(){
        feastMenus =file.readFeastMenusFromFile();
        System.out.println("----------------------------------------------------");
         System.err.println("List of Set Menus for ordering party:");
        System.out.println("----------------------------------------------------");
        feastMenus.sort(Comparator.comparing(FeastMenu::getPrice));
        for(FeastMenu feastMenu :feastMenus)
        {
            System.out.println("Code        : "+ feastMenu.getCode());
            System.out.println("Name        : "+ feastMenu.getName());
            System.out.println("Price       : "+ feastMenu.getPrice() + "Vnd");
            System.out.println("Ingredients:");
           feastMenu.getIngredients().stream().forEach((ing)->{
                System.out.println("         "+ ing);
           }
           );
            System.out.println("----------------------------------------------------");
        }
    }
}
