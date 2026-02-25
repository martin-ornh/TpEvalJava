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

            // 3 address
//            Address address1 = new Address("7", "Rue du test", "44000", "Nantes");
//            Address address2 = new Address("10", "Rue de l'EPSI", "44200", "Nantes");
//            Address address3 = new Address("127", "Rue des champs", "75000", "Paris");
            // Sauvegarde les adresses
//            em.persist(address1);
//            em.persist(address2);
//            em.persist(address3);
//
//            // 3 produits
//            Product product1 = new Product("CODE1", "Laisse pour chat", ProdType.ACCESSORY, 40);
//            Product product2 = new Product("CODE2", "Pâté pour chat", ProdType.FOOD, 10);
//            Product product3 = new Product("CODE3", "Brosse à poil", ProdType.ACCESSORY, 19.99);
//            // Sauvegarde
//            em.persist(product1);
//            em.persist(product2);
//            em.persist(product3);

            // 3 PetStore
            PetStore petStore1 = new PetStore("MaxiZoo", "Martin ORNH");
            PetStore petStore2 = new PetStore("Animalerie", "Séga SYLLA");
            PetStore petStore3 = new PetStore("SPA", "Thomas TARTRAU");
            // Sauvegarde
            em.persist(petStore1);
            em.persist(petStore2);
            em.persist(petStore3);
            // Ajout 3 chats
            Cat cat1 = new Cat(new Date(), "Roux", "CHAT1");
            Cat cat2 = new Cat(new Date(), "Bleu", "CHAT2");
            Cat cat3 = new Cat(new Date(), "Rouge", "CHAT3");
//
//            em.persist(cat1);
//            em.persist(cat2);
//            em.persist(cat3);

            // Ajout 3 poissons
            Fish fish1 = new Fish(new Date(), "Rouge", FishLivEnv.FRESH_WATER);
            Fish fish2 = new Fish(new Date(), "Gris", FishLivEnv.SEA_WATER);
            Fish fish3 = new Fish(new Date(), "Bleu", FishLivEnv.FRESH_WATER);
//
//            em.persist(fish1);
//            em.persist(fish2);
//            em.persist(fish3);

            // Adress_id dans PetStore
//            petStore1.setAddress(address1);
//            petStore2.setAddress(address2);
//            petStore3.setAddress(address3);

            // petstore_id dans Animal
            petStore1.addAnimal(cat1);
            petStore1.addAnimal(fish1);

            petStore2.addAnimal(cat2);
            petStore2.addAnimal(fish2);

            petStore3.addAnimal(cat3);
            petStore3.addAnimal(fish3);

            em.persist(petStore1);
            em.persist(petStore2);
            em.persist(petStore3);

            // Exécute en base
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
