package sn.sdley;

public class Personne {
    private String nom;
    private int age;

    // Constructeur
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Getter pour l'âge
    public int getAge() {
        return age;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Nom: " + nom + ", Age: " + age;
    }
}
