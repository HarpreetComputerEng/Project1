package level2_Assignment1;

/**
 * Program: Computer Engineering Technology - Computing Science [Academic Level: 2 ]
 * Course: CST8132 Object Oriented Programming
 * Student Name: HarpreetSingh
 * Student Number: 041127993
 * Section #: 312
 * Professor: Dr. James Mwangi
 * Assignment - 1 :
 * Due Date: 10th February 2025
 * Description: College Management System to manage students' data
 */
import java.util.Scanner;

/**
 * Represents a college system to store and manage student data.
 * The class provides functionality to add and display students.
 * 
 * @author HarpreetSingh
 * @version 1.0
 */
public class College {
	/**
	 * stores name of college
	 */
    private String name;
    /**
     * Array of students enrolled in the college
     */
    private Student[] students;
    /**
     * the total number of students in the college
     */
    private int count;

    /**
     *  parameterized  Constructor for College class.
     * 
     * @param name Name of the college.
     * @param numStudents Maximum number of students.
     */
    public College(String name, int numStudents) {
        this.name = name;
        this.students = new Student[numStudents];
        this.count = 0;
    }

    /**
     * Prints the title and header row of the student list.
     */
    public void printTitle() {
        System.out.println(name + " - List of Students");
        System.out.println("***********************************************************");
        System.out.printf("%-10s | %-8s | %-15s | %-15s | %-10s | %-4s | %-6s | %-7s |\n",
                "Program", "Student#", "Name", "Email", "Phone", "GPA", "Fees", "Credits");
    }

    /**
     * Reads and stores student details.
     * 
     * @param scanner Scanner object for user input.
     */
    public void readStudentsDetails(Scanner scanner) {
        if (count >= students.length) {
            System.out.println("Array is full.... cannot add more students");
            return;
        }

        int type = 0;
        while (true) {
            try {
                System.out.println("1 - Fulltime student\n2 - Parttime Student");
                System.out.print("Enter Student type: ");
                type = scanner.nextInt();
                if (type == 1 || type == 2) {
                    break;
                } else {
                    System.out.println("Wrong student type. Please enter 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer (1 or 2). ");
                scanner.next(); // Clear invalid input
            }
        }

        Student student = (type == 1) ? new FullTimeStudent() : new PartTimeStudent();
        student.readInfo(scanner);
        students[count++] = student;
    }

    /**
     * Prints details of all students
     * use if statement when no students to display
     */
    public void printStudentDetails() {
        if (count == 0) {
            System.out.println("********** No students to print *****");//output for the user
            return;//return due to void
        }
        /**
         * reads details for students
         */
        printTitle();
        for (int i = 0; i < count; i++) {
            students[i].printInfo();
            System.out.println();
        }
    }
}
