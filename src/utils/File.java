/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import models.FeastMenu;

/**
 *
 * @author Tcp35
 */
public class File {
    public ArrayList <FeastMenu> readFeastMenusFromFile(){
        ArrayList<FeastMenu> feastMenus = new ArrayList<>();
        String line;
        
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/FeastMenu.csv")))
        {  line = br.readLine();
            while( line !=  null){
                System.out.println(line);
                line = br.readLine();
                
            }
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
        
        return feastMenus;
    }
}
