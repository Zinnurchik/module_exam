package org.example;

public class Student {
    private int student_id;
    private String name;
    private int age;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + student_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
