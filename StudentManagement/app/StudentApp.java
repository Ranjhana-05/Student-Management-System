package app;

import java.util.List;
import java.util.Scanner;
import model.Student;
import service.FileService;
import service.StudentService;

public class StudentApp
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        FileService fileService = new FileService();

        
        List<Student> loadedStudents = fileService.loadFromFile();
        studentService.setStudents(loadedStudents);

        int choice = 0;

        do
        {
            System.out.println();
            System.out.println("----- STUDENT MANAGEMENT SYSTEM -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch(choice)
            {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    boolean added = studentService.addStudent(id, name, age, course, gpa);

                    if (added)
                    {
                        System.out.println("Student added successfully.");
                    }
                    else
                    {
                        System.out.println("Failed to add student. Check input.");
                    }

                    break;


                case 2:

                    List<Student> students = studentService.getStudents();

                    if (students.isEmpty())
                    {
                        System.out.println("No students found.");
                    }
                    else
                    {
                        System.out.println("ID | Name | Age | Course | GPA");
                        System.out.println("------------------------------------");

                        for (Student student : students)
                        {
                            System.out.println(student);
                        }
                    }

                    break;


                case 3:

                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();

                    Student foundStudent = studentService.searchStudentById(searchId);

                    if (foundStudent != null)
                    {
                        System.out.println("Student Found:");
                        System.out.println(foundStudent);
                    }
                    else
                    {
                        System.out.println("Student not found.");
                    }

                    break;


                case 4:

                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New GPA: ");
                    double newGpa = scanner.nextDouble();

                    boolean updated = studentService.updateStudent(updateId, newName, newAge, newCourse, newGpa);

                    if (updated)
                    {
                        System.out.println("Student updated successfully.");
                    }
                    else
                    {
                        System.out.println("Update failed. Student not found or invalid data.");
                    }

                    break;


                case 5:

                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();

                    boolean deleted = studentService.deleteStudent(deleteId);

                    if (deleted)
                    {
                        System.out.println("Student deleted successfully.");
                    }
                    else
                    {
                        System.out.println("Student not found.");
                    }

                    break;


                case 6:

                    fileService.saveToFile(studentService.getStudents());
                    System.out.println("Data saved successfully.");
                    System.out.println("Exiting application...");
                    break;


                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
