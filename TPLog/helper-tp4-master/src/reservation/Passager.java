package reservation;
import aeroport.*;

public class Passager {
    private String nom;
    private Reservation reservation;

    public Passager(String nom, Reservation reservation) {
        this.nom = nom;
        this.reservation = reservation;
        if (reservation != null) {
            reservation.addPassager(this);
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
