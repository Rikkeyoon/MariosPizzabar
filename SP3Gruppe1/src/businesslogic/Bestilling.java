package businesslogic;

import java.sql.Time;

/*
 * @author Nina, Rikke og Caroline
 */
public class Bestilling {

    private int pizzaNr;
    private int bestilNr;
    private Time afhentTid;
    private int antal;

    public Bestilling(int bestilNr, Time afhentTid, int antal, int pizzaNr) {
        this.pizzaNr = pizzaNr;
        this.bestilNr = bestilNr;
        this.afhentTid = afhentTid;
        this.antal = antal;
    }

    public int getBestilNr() {
        return bestilNr;
    }

    public Time getAfhentTid() {
        return afhentTid;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public int getAntal() {
        return antal;
    }

    @Override
    public String toString() {
        return "Ordre Nr:\t\t\t" + bestilNr
                + "\nAfhentningstidspunkt:  \t" + afhentTid
                + "\nOrdre beskrivelse:\n\t" /*1 x " + pizza.getPizzaNavn()*/
                + "\nPris: \t\t\t     " /*+ (int) pizza.getPris() + ",-\n"*/;
    }
}
