package org.sohailshah;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student1 = entityManager.find(Student.class, 1);
        System.out.println(student1);
//        LibraryCard card = entityManager.find(LibraryCard.class, 3);
//        System.out.println(card.getOwner());
    }
}
