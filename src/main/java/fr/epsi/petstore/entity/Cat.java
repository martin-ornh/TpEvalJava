package fr.epsi.petstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cat")
@PrimaryKeyJoinColumn(name = "animal_id") // Jointure vers table Animal
public class Cat extends Animal {

    @Column(name = "chip_id")
    private String chipId;

    public Cat() {

    }

    public Cat(java.util.Date birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    // Gatters & setters
    public String getChipId() { return chipId; }
    public void setChipId(String chipId) { this.chipId = chipId; }

    @Override
    public String toString() {
        return "Cat{" + super.toString() + ", chipId='" + chipId + "'}";
    }
}