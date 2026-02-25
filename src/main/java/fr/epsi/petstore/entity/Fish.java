package fr.epsi.petstore.entity;

import fr.epsi.petstore.entity.enums.FishLivEnv;
import jakarta.persistence.*;

@Entity
@Table(name = "fish")
@PrimaryKeyJoinColumn(name = "animal_id") // Jointure vers la table Animal
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    @Column(name = "living_env")
    private FishLivEnv livingEnv;

    public Fish() {

    }

    public Fish(java.util.Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    // Gatter & setters
    public FishLivEnv getLivingEnv() { return livingEnv; }
    public void setLivingEnv(FishLivEnv livingEnv) { this.livingEnv = livingEnv; }

    @Override
    public String toString() {
        return "Fish{" + super.toString() + ", livingEnv=" + livingEnv + "}";
    }
}