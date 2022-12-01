/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import beans.Student;
import main.Config;

/**
 *
 * @author Umman
 */
public class StudentUtil
{

    public static Student fillStudent() {
        String name = InputUtil.requireText("enter name");
        String surname = InputUtil.requireText("enter surname");
        String className = InputUtil.requireText("enter class");
        int age = InputUtil.requireNumber("enter age");

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {// butun studentlerin qeydiyyatdan kecmeyini yoxlamaq
            Student st = Config.students[i];

            System.out.println((i+1)+"."+st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students do you want to register?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Registered student");
            Config.students[i] = StudentUtil.fillStudent();
        }

        System.out.println("Registration completed successfully");
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("type name, surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                System.out.println(st.getFullInfo());
            }
        }
    }

    public static Student[] findStudents(String text) { // find count of searching
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count]; // creating new array and then fill it from founded
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

}
