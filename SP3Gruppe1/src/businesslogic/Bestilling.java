package businesslogic;

/*
 * @author Nina, Rikke og Caroline
 */

public class Bestilling {
    private Pizza pizza;
    private int ordreNr;

    public Bestilling(Pizza pizza, int currentOrderNr) {
        this.pizza = pizza;
        ordreNr = currentOrderNr;
    }

    public int getOrdreNr() {
        return ordreNr;
    }
    
    public Pizza getPizza() {
        return pizza;
    }
    
    @Override
    public String toString() {
        return "Ordre Nr: \t\t   " + ordreNr 
                /*+ "\nAfhentningstidspunkt:\t" + afhentningsTidspunkt */
                + "\nOrdre beskrivelse:\n\t1 x " + pizza.getPizzaNavn()
                + "\nPris: \t\t" + (int)pizza.getPris() + ",-";
    }
}