/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Tcp35
 */
public class Input {
    
    public static Scanner sc = new Scanner(System.in);
            
    public int inputMenuChoice(){
        int choice;
        System.out.println("Input your choice: ");
        choice = Integer.parseInt(sc.nextLine());
        
        
        return choice;
    }
    public String inputRegex(String regex, String output){
        String inputString;
        do {
            System.out.println(output);
            inputString = sc.nextLine();
    }while(!inputString.matches(regex));
        return inputString;
    }
      public String inputString(String output) {
        String inputString;
        do {            
            System.out.println(output);
            inputString = sc.nextLine();
        } while (inputString.isEmpty());
        return inputString;
    }
    
    public int inputInt(String output) {
        int number;
        do {            
            System.out.println(output);
            number = Integer.parseInt(sc.nextLine());
            if (number <= 0) {
                System.out.println("Number must be greater than 0!");
            }
        } while (number <= 0);
        return number;
    }
}


