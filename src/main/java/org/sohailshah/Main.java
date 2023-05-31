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
        LibraryCard card1 = entityManager.find(LibraryCard.class, 3);
        LibraryCard card2 = entityManager.find(LibraryCard.class, 4);
        Student student1 = entityManager.find(Student.class, 1);
        student1.setCard(card1);
        Student student2 = entityManager.find(Student.class, 2);
        student2.setCard(card2);
//
////
//
//        Student student1 = new Student();
//        student1.setName("Sohail Shah");
//        student1.setAge(18);
//        student1.setAdmission_no("1234");
//        student1.setDob(new Date());
//        student1.setStudentType(StudentType.SCHOLARSHIP);
//        Student student2 = new Student();
//        student2.setName("Ali");
//        student2.setAge(20);
//        student2.setAdmission_no("1235");
//        student2.setDob(new Date());
//        student2.setStudentType(StudentType.NON_SCHOLARSHIP);
//
//        LibraryCard card1 = new LibraryCard();
//        card1.setActive(true);
//        card1.setIssuedDate(new Date());
//
//        LibraryCard card2 = new LibraryCard();
//        card2.setActive(false);
//        card2.setIssuedDate(new Date());

    //        Student s = entityManager.find(Student.class, 1);
    //        s.setLibrary_card(card1.getId());
    //
    //        Student s1 = entityManager.find(Student.class, 2);
    //        s1.setLibrary_card(card2.getId());

//      //creating a transaction object using the entity manager
        EntityTransaction transaction = entityManager.getTransaction();
        //beginning the transaction
        transaction.begin();
        //updating the student
        entityManager.persist(student1);
        entityManager.persist(student2);
//        entityManager.persist(card1);
//        entityManager.persist(card2);
        //committing the transaction
        transaction.commit();
        //closing the entity manager
        entityManager.close();
        //closing the entity manager factory
        entityManagerFactory.close();

    }
}