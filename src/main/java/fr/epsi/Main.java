package fr.epsi;

import fr.epsi.petstore.entity.*;
import fr.epsi.petstore.entity.enums.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore-pu");
        EntityManager em = emf.createEntityManager();

        try {
            // insert en base via EM
            em.getTransaction().begin();

            Address address1 = new Address("7", "Rue du test", "44000", "Nantes");
            Address address2 = new Address("10", "Rue de l'EPSI", "44200", "Nantes");
            Address address3 = new Address("127", "Rue des champs", "75000", "Paris");

            em.persist(address1);
            em.persist(address2);
            em.persist(address3);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
