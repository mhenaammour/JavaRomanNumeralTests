package aeroport;
import reservation.*;
import java.util.ArrayList;
import java.util.Collection;

public class Aeroport {

    private String nom;

    private Ville ville;
    private Collection<Vol> VolDepart = new ArrayList<>();
    private Collection<Vol> VolArrive = new ArrayList<>();

    public Aeroport(String nom , Ville ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
    public void setVolDepart(Collection<Vol> vols ){
        this.VolDepart = vols;
    }

    public Collection<Vol>  getVolDepart(){
        return VolDepart;
    }
    public void setVolArrive(Collection<Vol> vols ){
        this.VolArrive = vols;
    }

    public Collection<Vol>  getVolArrive(){
        return VolArrive;
    }
    public void addVolDepart(Vol vol) {
        if (!VolDepart.contains(vol)) {
            VolDepart.add(vol);
            vol.setDepart(this);  // Assure la bidirectionnalité
        }
    }

    public void removeVolDepart(Vol vol) {
        if (VolDepart.contains(vol)) {
            VolDepart.remove(vol);
            vol.setDepart(null);  // Nettoie la référence
        }
    }

    public void addVolArrive(Vol vol) {
        if (!VolArrive.contains(vol)) {
            VolArrive.add(vol);
            vol.setArrivee(this);  // Assure la bidirectionnalité
        }
    }

    public void removeVolArrive(Vol vol) {
        if (VolArrive.contains(vol)) {
            VolArrive.remove(vol);
            vol.setArrivee(null);  // Nettoie la référence
        }
    }
}
