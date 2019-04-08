package businesslogic;

import java.sql.Time;

/*
 * @author Nina, Rikke og Caroline
 */

public class Bestilling {
    private Pizza pizza;
    private int ordreNr;
    private Time afhentningstidpunkt;
    
    public Bestilling(Pizza pizza, int currentOrderNr, String afhentningstidspunkt) {
        this.pizza = pizza;
        ordreNr = currentOrderNr;
        this.afhentningstidpunkt = Time.valueOf(afhentningstidspunkt);
    }

    public int getOrdreNr() {
        return ordreNr;
    }
    
    public Pizza getPizza() {
        return pizza;
    }

    public Time getAfhentningstidpunkt() {
        return afhentningstidpunkt;
    }

    @Override
    public String toString() {
        return "Ordre Nr:\t\t\t" + ordreNr 
                + "\nAfhentningstidspunkt:  \t" + afhentningstidpunkt 
                + "\nOrdre beskrivelse:\n\t1 x " + pizza.getPizzaNavn()
                + "\nPris: \t\t\t     " + (int)pizza.getPris() + ",-\n";
    }
}