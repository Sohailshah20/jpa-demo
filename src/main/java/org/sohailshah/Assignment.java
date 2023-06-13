package org.sohailshah;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grade_table")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @Temporal(value = TemporalType.DATE)
    private Date dueDate;

    @ManyToOne
    private Student assignedTo;

    public Student getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Student assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id + "\n" +
                ", title='" + title + '\'' + "\n" +
                ", dueDate=" + dueDate + "\n " +
                '}';
    }
}
