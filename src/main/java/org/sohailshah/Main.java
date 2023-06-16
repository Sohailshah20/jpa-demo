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

        Student student1 = new Student();
        student1.setName("Sohail Shah");
        student1.setAge(18);
        student1.setAdmission_no("1234");
        student1.setDob(new Date());
        student1.setStudentType(StudentType.SCHOLARSHIP);

        Student student2 = new Student();
        student2.setName("Ali");
        student2.setAge(20);
        student2.setAdmission_no("1235");
        student2.setDob(new Date());
        student2.setStudentType(StudentType.NON_SCHOLARSHIP);

        Club club1 = new Club();
        club1.setName("Java Club");
        club1.addStudent(student1);
        club1.addStudent(student2);
        student1.addClub(club1);
        student2.addClub(club1);

        Club club2 = new Club();
        club2.setName("Spring Club");
        club2.addStudent(student2);
        student2.addClub(club2);

//        LibraryCard card1 = new LibraryCard();
//        card1.setActive(true);
//        card1.setIssuedDate(new Date());
//
//        LibraryCard card2 = new LibraryCard();
//        card2.setActive(false);
//        card2.setIssuedDate(new Date());
//
//        Assignment ass1 = new Assignment();
//        ass1.setTitle("JAVA");
//        ass1.setDueDate(new Date());
//        ass1.setAssignedTo(student1);
//
//        Assignment ass2 = new Assignment();
//        ass2.setTitle("DSA");
//        ass2.setDueDate(new Date());
//        ass2.setAssignedTo(student1);
//
//        student1.setCard(card1);
//        student2.setCard(card2);
//
//        card1.setOwner(student1);
//        card2.setOwner(student2);

        //creating a transaction object using the entity manager
        EntityTransaction transaction = entityManager.getTransaction();
        //beginning the transaction
        transaction.begin();
        //updating the student
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(club1);
        entityManager.persist(club2);
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