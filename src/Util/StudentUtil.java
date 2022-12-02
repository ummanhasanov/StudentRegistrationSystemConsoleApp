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
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        String className = MenuUtil.requireClassName();
        int age = MenuUtil.requireAge();

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {// butun studentlerin qeydiyyatdan kecmeyini yoxlamaq
            Student st = Config.students[i];

            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students do you want to register?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Registered student");
            Config.students[i] = StudentUtil.fillStudent();
        }
        MenuUtil.showSuccessOpMessage();
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

    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents(); //show and print all registered students

        int i = InputUtil.requireNumber("Which student do you want to update");

        System.out.println("type update details");
        Student s = StudentUtil.fillStudent(); // update data of selected student
        Config.students[i - 1] = s; // updated student
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents(); //show and print all registered students

        int i = InputUtil.requireNumber("Which student do you want to update");

        System.out.println("enter new update details");

        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requireText(" What do you want to change? example: 'name', 'surname', 'classname', 'age'");

        if (changeParams.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }

        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }

        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }

        if (changeParams.contains("'classname'")) {
            selectedStudent.setClassName(MenuUtil.requireClassName());
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents(); //show and print all registered students

        int index = InputUtil.requireNumber("Which student do you want to update");

        System.out.println("enter new update details");

        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requireText(" What do you want to change? example: name, surname, classname, age");
        String[] parameters = changeParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requireClassName());
            }
        }
    }
}
