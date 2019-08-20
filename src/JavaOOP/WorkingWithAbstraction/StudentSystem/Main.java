package JavaOOP.WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        loop:
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            switch (command) {
                case "Create":
                    String name = input[1];
                    if (!studentSystem.getRepo().containsKey(name)) {
                        int age = Integer.parseInt(input[2]);
                        double grade = Double.parseDouble(input[3]);
                        Student student = new Student(name, age, grade);
                        studentSystem.addStudent(student);
                    }
                    break;
                case "Show":
                    break;
                case "Exit":
                    break loop;
            }
        }
    }
}
