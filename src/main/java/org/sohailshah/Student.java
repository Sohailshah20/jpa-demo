package org.sohailshah;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "student_name")
    private String name;

    private int age;
    @Enumerated(EnumType.STRING)
    private StudentType studentType;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String admission_no;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", studentType=" + studentType +
                ", dob=" + dob +
                ", admission_no='" + admission_no + '\'' +
                '}';
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdmission_no() {
        return admission_no;
    }

    public void setAdmission_no(String admission_no) {
        this.admission_no = admission_no;
    }

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
}