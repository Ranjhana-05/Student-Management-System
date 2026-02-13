package model;
public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private double gpa;

    public Student(int id, String name, int age, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa; 
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCourse(){
        return course;
    }

    public double getGpa(){
        return gpa;
    }

    public void setId(int id){
       this.id=id;   
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setCourse(String course){
        this.course=course;
    }

    public void setGpa(double gpa){
        this.gpa=gpa;    
    }

    public String toString() {
        return id + " - " + name + " | Age: " + age + " | Course: " + course + " | GPA: " + gpa;
    }

}


