/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Util.InputUtil;
import Util.StudentUtil;
import beans.Student;

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

            if (menu == 1) {
                StudentUtil.registerStudents();
            } else if (menu == 2) {
                StudentUtil.printAllRegisteredStudents();
            } else if (menu == 3) {
                StudentUtil.findStudentsAndPrint();
            } else if (menu == 4) {
                StudentUtil.printAllRegisteredStudents(); //show and print all registered students
                int i = InputUtil.requireNumber("Which student do you want to update");
                System.out.println("type update details");
                Student s = StudentUtil.fillStudent(); // update data of selected student
                Config.students[i-1] = s; // updated student
            }
        }
    }
}
