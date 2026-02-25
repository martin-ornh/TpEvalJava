package fr.epsi.petstore.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "manager_name")
    private String managerName;

    // 1 PetStore --> 1 Address
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    // 1 PetStore --> N Animal
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals = new ArrayList<>();

    // N PetStore --> N Product
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "petstore_product",
            joinColumns = @JoinColumn(name = "petstore_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public PetStore() {

    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    // Ajoute un animal dans un petstore
    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setPetStore(this);
    }

    // Retire un animal d'un petstore
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        animal.setPetStore(null);
    }

    // Ajoute un produit dans un petstore
    public void addProduct(Product product) {
        products.add(product);
        product.getPetStores().add(this);
    }

    // Retire un produit d'un petstore
    public void removeProduct(Product product) {
        products.remove(product);
        product.getPetStores().remove(this);
    }

    // Gatters & setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Animal> getAnimals() { return animals; }
    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        return "PetStore{id=" + id + ", name='" + name + "', manager='" + managerName + "'}";
    }
}