package reservation;
import aeroport.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aeroport.Vol;

public class Reservation {
    private String numero;
    private Date date;
    private Client client;
    private Vol vol;
    private List<Passager> passagers = new ArrayList<>();

    public Reservation(String numero, Date date, Client client, Vol vol) {
        this.numero = numero;
        this.date = date;
        this.client = client;
        this.vol = vol;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void addPassager(Passager passager) {
        if (!passagers.contains(passager)) {
            passagers.add(passager);
            passager.setReservation(this);
        }
    }
}
