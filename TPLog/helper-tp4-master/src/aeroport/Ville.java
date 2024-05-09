package aeroport;
import java.util.ArrayList;
import java.util.Collection;
import reservation.*;
public class Ville {

    private String nom;
    private Collection<Aeroport> aeroports = new ArrayList<>();
    

    public Ville(String nom) {
        this.nom = nom ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
      public Collection<Aeroport> getAeroports() {
        return this.aeroports;
    }

    public void setAeroports(Collection<Aeroport> aeroports) {
        this.aeroports = aeroports;
    }
    
    public void addAeroports(Aeroport aeroport){
        this.aeroports.add(aeroport);

    }
    public String toString(){

        return this.nom;
    }
}