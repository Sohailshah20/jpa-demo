package org.sohailshah;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        //creating entity manager factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        //creating entity manager using the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //reading from the database
        //doesn't require transactions
        Student student = entityManager.find(Student.class, 1);
        student.setAge(30);

//        Student student = new Student();
//        student.setName("Sohail Shah");
//        student.setAge(18);
//        student.setAdmission_no("1234");
//        student.setDob(new Date());
//        student.setStudentType(StudentType.SCHOLARSHIP);
//        Student student1 = new Student();
//        student1.setName("Sohail Ali");
//        student1.setAge(20);
//        student1.setAdmission_no("1235");
//        student1.setDob(new Date());
//        student1.setStudentType(StudentType.NON_SCHOLARSHIP);

//      //creating a transaction object using the entity manager
        EntityTransaction transaction = entityManager.getTransaction();
        //beginning the transaction
        transaction.begin();
        //updating the student
        entityManager.persist(student);
        //deleting the student
        entityManager.remove(student);
        //committing the transaction
        transaction.commit();
        //closing the entity manager
        entityManager.close();
        //closing the entity manager factory
        entityManagerFactory.close();

    }
}