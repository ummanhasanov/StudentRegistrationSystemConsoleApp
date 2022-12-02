/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author Umman
 */
public class MenuUtil
{

    public static void processMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1:
                StudentUtil.registerStudents();
                break;
            case 2:
                StudentUtil.printAllRegisteredStudents();
                break;
            case 3:
                StudentUtil.findStudentsAndPrint();
                break;
            case 4:
                StudentUtil.updateStudentWithSplit();
                break;
            default:
                break;
        }
    }

    public static String requireName() {
        return InputUtil.requireText("enter name");
    }

    public static String requireSurname() {
        return InputUtil.requireText("enter surname");
    }

    public static String requireClassName() {
        return InputUtil.requireText("enter class name");
    }

    public static int requireAge() {
        return InputUtil.requireNumber("enter age");
    }

    public static void showSuccessOpMessage() {
        System.out.println("Registration completed successfully");

    }
}
