import aeroport.Aeroport;
import aeroport.Compagnie;
import aeroport.Escale;
import aeroport.Ville;
import aeroport.Vol;
import reservation.Client;
import reservation.Passager;
import reservation.Reservation;

import java.time.Duration;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Start {
     private static void testClientAndReservation() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Client client = new Client("Oussama fellag", "123-456-7890", "Credit Card", "REF123");

        try {
            Date date = format.parse("25/12/2024 15:00");
            Vol vol = new Vol(); // Assuming Vol has a default constructor or appropriate setters to configure it.
            vol.setNumero("FL123");

            Reservation reservation = client.createReservation(date, vol);
            System.out.println("Reservation Number: " + reservation.getNumero());
            System.out.println("Total Reservations for Client: " + client.getReservations().size());

            Passager passager = new Passager("Oussama fellag", reservation);
            System.out.println("Passager Name: " + passager.getNom());
            System.out.println("Reservation for Passager: " + passager.getReservation().getNumero());

        } catch (Exception e) {
            System.err.println("Error with Client and Reservation test: " + e.getMessage());
        }
    }

    private static void testPassagerAndReservationLink() {
        Client client = new Client("ammour m'hena", "987-654-3210", "PayPal", "REF456");
        Reservation reservation = new Reservation("RES-001", new Date(), client, null);
        Passager passager = new Passager("anis bomnjel", reservation);

        System.out.println("Passager's Reservation Number: " + passager.getReservation().getNumero());
        System.out.println("Is the Passager linked correctly? " + (reservation.getPassagers().contains(passager) ? "Yes" : "No"));
    }
    public static void main(String[] args){
        Vol volFinal = new Vol();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dd = "21/10/2020 13:00";
        String da = "23/10/2020 02:15";

        try {
            volFinal.setDateDepart(format.parse(dd));
            volFinal.setDateArrivee(format.parse(da));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }

        System.out.println(volFinal.getDateArrivee());
        System.out.println(volFinal.obtenirDuree().toString().substring(2));






        //Bidirectional
        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        compagnie.addVol(vol);
        compagnie.addVol(vol2);

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println(vol.getCompagnie().getName());
        System.out.println(vol2.getCompagnie().getName());

        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }
      ;
    
        Escale escale = new Escale(LocalDateTime.now(), LocalDateTime.now().plusHours(2), new Aeroport("CDG",new Ville("paris")));
        vol2.addEscale(escale);
    
        System.out.println("Escale at: " + escale.getAeroport().getNom());
        Duration dureeEscale = escale.calculateDuration();
        escale.setduree(dureeEscale);
        System.out.println("Duration of the escale: " + escale.getduree().toMinutes() + " minutes");
        testClientAndReservation();
        testPassagerAndReservationLink();     
    
    }

  
    
}
