package businesslogic;

import java.sql.Time;
//import java.util.ArrayList;

/*
 * @author Nina, Rikke og Caroline
 */
public class Bestilling {

    private int bestilNr;
    private Time afhentTid;
    private /*ArrayList<*/Bestillingslinje/*>*/ bestilLinje/*r*/;
    
    public Bestilling(int bestilNr, Time afhentTid,
            /*ArrayList<*/Bestillingslinje/*>*/ bestilLinje/*r*/) {
        this.bestilNr = bestilNr;
        this.afhentTid = afhentTid;
        this.bestilLinje = bestilLinje;
    }

    public int getBestilNr() {
        return bestilNr;
    }

    public Time getAfhentTid() {
        return afhentTid;
    }

    @Override
    public String toString() {
        return "Ordre Nr:\t\t\t" + bestilNr
                + "\nAfhentningstidspunkt:  \t" + afhentTid
                + "\nOrdre beskrivelse:\n\t" /*1 x "*/
                + "\nPris: \t\t\t     " /*+ (int) pizza.getPris() + ",-\n"*/;
    }
}
