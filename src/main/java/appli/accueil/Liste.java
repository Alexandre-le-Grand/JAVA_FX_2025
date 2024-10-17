package appli.accueil;

import java.time.LocalDateTime;

public class Liste {
    private int idListe;
    private String nom;
    private LocalDateTime dateCreation;

    // Constructeur
    public Liste(int idListe, String nom, LocalDateTime dateCreation) {
        this.idListe = idListe;
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

    // Getters
    public int getIdListe() {
        return idListe;
    }

    public String getNom() {
        return nom;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
}
