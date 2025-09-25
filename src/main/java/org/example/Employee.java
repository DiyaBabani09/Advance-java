package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Employee() {
    }

@Column(name="Emp_name" ,length=10)
    private String name;

    private int salary;
@OneToMany(mappedBy = "employee" ,fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    private List<Department>list=new ArrayList<>();
    @Lob
    private String about;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", list=" + list +
                ", about='" + about + '\'' +
                '}';
    }
}
