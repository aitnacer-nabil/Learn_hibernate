package edu.mum.cs;

import edu.mum.cs.domain.Book;
import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class Main {
   static EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.mum.cs");

    private void persist(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Person p = Person.builder().name("Nabil").lastName("Ait Nacer").build();
        entityManager.persist(p);
        transaction.commit();

        entityManager.close();
    }
    private void merge(){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Person p = entityManager.find(Person.class,1L);
        entityManager.detach(p);
        p.setName("Hello Nabil");
        Book book = Book.builder().isbn("1213-121243252").title("Learn Hibernate").build();
        entityManager.merge(book);
        entityManager.merge(p);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    private void remove(){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Person p = Person.builder().name("Hello").lastName("World!").build();
        entityManager.remove(p);
        Person p2 = entityManager.getReference(Person.class,1L);
        entityManager.remove(p2 );
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.persist();
        main.merge();
        main.remove();

    }
}
