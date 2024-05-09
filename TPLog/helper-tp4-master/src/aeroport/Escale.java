package aeroport;
import reservation.*;
import java.time.LocalDateTime;
import java.time.Duration;

public class Escale {

    private LocalDateTime depart;
    private LocalDateTime arrivee;
    private Duration duree;
    private Aeroport aeroport; 

    public Escale(LocalDateTime depart, LocalDateTime arrivee, Aeroport aeroport) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.aeroport = aeroport;
    }
    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }
    // Calculate the duration between depart and arrivee
    public Duration calculateDuration() {
        if (depart != null && arrivee != null) {
            return Duration.between(depart, arrivee);
        }
        return Duration.ZERO;
    }

    public LocalDateTime getDepart() {
        return depart;
    }

    
    public void setDepart(LocalDateTime depart) {
        this.depart = depart;
        this.duree = calculateDuration();  // Recalculate duration on setting new depart
    }

    
    public LocalDateTime getArrivee() {
        return arrivee;
    }

    
    public void setArrivee(LocalDateTime arrivee) {
        this.arrivee = arrivee;
        this.duree = calculateDuration();  // Recalculate duration on setting new arrivee
    }

    // Getter for duree that returns a formatted string
    public String getDuree() {
        return formatDuration(duree);
    }
    public void setduree(Duration duree){
        this.duree=duree;
    }
    public Duration getduree(){
        return this.duree;
    }

    // Helper method to format Duration object into a readable string
    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return String.format("%dh %02dm", hours, minutes);
    }
}
