/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import java.util.Scanner;

/**
 *
 * @author SERVER
 */
public class SHELL {
    public static void main(String[] args) {
        String text;
        Scanner linea = new Scanner(System.in);
        
        Lexer l = new Lexer();
        while(true){
           System.out.print("Basic >  ");
           text = linea.nextLine();
           System.out.println(l.run(text));
        }
    }

}
