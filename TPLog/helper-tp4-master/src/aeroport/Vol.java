package aeroport ;
import reservation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import reservation.Reservation;

public class Vol {

    private String numero;
    private Aeroport depart;
    private Aeroport arrivee;
    private Compagnie compagnie;
    private Date dateDepart;
    private List<Reservation> reservations = new ArrayList<>();
    private Date dateArrivee;
    private List<Escale> escales = new ArrayList<>();  

    

  //first constructor
    public Vol(Date dateDepart, Date dateArrivee, Aeroport depart, Aeroport arrivee, Compagnie compagnie) {
        this.numero = FlightNumberGenerator.generate();
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.depart = depart;
        this.arrivee = arrivee;
        this.compagnie = compagnie;
        if (compagnie != null) compagnie.addVol(this);
        if (depart != null) depart.addVolDepart(this);
        if (arrivee != null) arrivee.addVolArrive(this);
    }
    //second constructor
    public Vol(){

    }
    // Calculates flight duration
    public String obtenirDuree() {
        if (this.dateDepart != null && this.dateArrivee != null) {
            Duration duration = Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
            long hours = duration.toHours();
            long minutes = duration.toMinutesPart();
            return String.format("%d hours and %d minutes", hours, minutes);
        }
        return "Duration not available";
    }
    

    
    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie newCompagnie) {
        if (this.compagnie != null) {
            this.compagnie.removeVolWithoutBidirectional(this);  // Clean up the old company
        }
        this.compagnie = newCompagnie;
        if (newCompagnie != null) {
            newCompagnie.addVolWithoutBidirectional(this);  // Add to the new company
        }
    }

    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    // Flight number generator class within Vol
    public static class FlightNumberGenerator {
        private static final Set<String> existingNumbers = new HashSet<>();

        public static String generate() {
            String newNumber;
            do {
                newNumber = "FL" + (int) (Math.random() * 10000);
            } while (existingNumbers.contains(newNumber));
            existingNumbers.add(newNumber);
            return newNumber;
        }

        public static void releaseNumber(String number) {
            existingNumbers.remove(number);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vol vol = (Vol) obj;
        return numero != null ? numero.equals(vol.numero) : vol.numero == null;
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }
    public void addEscale(Escale escale) {
        if (escale != null && !escales.contains(escale)) {
            escales.add(escale);
        }
    }

    public void removeEscale(Escale escale) {
        escales.remove(escale);
    }

    public List<Escale> getEscales() {
        return escales;
    }

    public void addReservation(Reservation reservation) {
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
        }
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }
}

