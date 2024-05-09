package reservation;
import aeroport.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client {
    private String nom;
    private String contact;
    private String paiement;
    private String reference;
    private List<Reservation> reservations = new ArrayList<>();
    private Set<String> reservationNumbers = new HashSet<>();
    private int reservationCounter = 0;

    public Client(String nom, String contact, String paiement, String reference) {
        this.nom = nom;
        this.contact = contact;
        this.paiement = paiement;
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // Generate a unique reservation number for this client
    private String generateUniqueReservationNumber() {
        String numero;
        do {
            numero = "RES-" + nom.substring(0, Math.min(3, nom.length())).toUpperCase() + "-" + (++reservationCounter);
        } while (reservationNumbers.contains(numero));
        reservationNumbers.add(numero);
        return numero;
    }

   
    public Reservation createReservation(Date date, Vol vol) {
        String numero = generateUniqueReservationNumber();
        Reservation reservation = new Reservation(numero, date, this, vol);
        reservations.add(reservation);
        if (vol != null) {
            vol.addReservation(reservation);
        }
        return reservation;
    }
}
