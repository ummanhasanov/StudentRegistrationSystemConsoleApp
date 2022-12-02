/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Util.InputUtil;
import Util.MenuUtil;

/**
 *
 * @author Umman
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        int menu = 0;

        while (true) {
            menu = InputUtil.requireNumber("What do you want to do?"
                    + "\n 1. Register Student"
                    + "\n 2. Show all students"
                    + "\n 3. Find student"
                    + "\n 4. Update student");

            MenuUtil.processMenu(menu);
        }
    }
}
