package service;
import model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService
{

    private static final String FILE_NAME = "students.txt";


    public void saveToFile(List<Student> students)
    {

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Student student : students)
            {
                String line = student.getId() + "," +
                              student.getName() + "," +
                              student.getAge() + "," +
                              student.getCourse() + "," +
                              student.getGpa();

                writer.write(line);
                writer.newLine();
            }

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error while saving data to file.");
        }
    }


    public List<Student> loadFromFile()
    {

        List<Student> students = new ArrayList<Student>();

        File file = new File(FILE_NAME);

        if (!file.exists())
        {
            return students;
        }

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String course = parts[3];
                double gpa = Double.parseDouble(parts[4]);

                Student student = new Student(id, name, age, course, gpa);

                students.add(student);
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error while loading data from file.");
        }

        return students;
    }
}
