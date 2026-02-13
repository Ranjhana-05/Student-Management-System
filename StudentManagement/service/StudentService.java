package service;
import model.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentService
{

    private List<Student> list = new ArrayList<Student>();


    public List<Student> getStudents()
    {
        return list;
    }


    public void setStudents(List<Student> students)
    {
        this.list = students;
    }


    public boolean addStudent(int id, String name, int age, String course, double gpa)
    {

        if (id <= 0)
        {
            return false;
        }

        for (Student s : list)
        {
            if (s.getId() == id)
            {
                return false;
            }
        }

        if (name == null || name.trim().isEmpty())
        {
            return false;
        }

        if (age < 0)
        {
            return false;
        }

        if (course == null || course.trim().isEmpty())
        {
            return false;
        }

        if (gpa < 0.0 || gpa > 10.0)
        {
            return false;
        }

        Student student = new Student(id, name, age, course, gpa);
        list.add(student);

        return true;
    }


    public Student searchStudentById(int id)
    {

        for (Student s : list)
        {
            if (s.getId() == id)
            {
                return s;
            }
        }

        return null;
    }


    public boolean updateStudent(int id, String name, int age, String course, double gpa)
    {

        Student student = searchStudentById(id);

        if (student == null)
        {
            return false;
        }

        if (name == null || name.trim().isEmpty())
        {
            return false;
        }

        if (age < 0)
        {
            return false;
        }

        if (course == null || course.trim().isEmpty())
        {
            return false;
        }

        if (gpa < 0.0 || gpa > 10.0)
        {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setGpa(gpa);

        return true;
    }


    public boolean deleteStudent(int id)
    {

        Iterator<Student> iterator = list.iterator();

        while (iterator.hasNext())
        {
            Student student = iterator.next();

            if (student.getId() == id)
            {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
