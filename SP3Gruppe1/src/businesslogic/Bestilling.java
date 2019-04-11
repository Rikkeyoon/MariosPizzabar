package businesslogic;

import java.time.LocalTime;
//import java.util.ArrayList;

/*
 * @author Nina, Rikke og Caroline
 */
public class Bestilling {

    private int bestilNr;
    private LocalTime afhentTid;
    private /*ArrayList<*/Bestillingslinje/*>*/ bestilLinje/*r*/;
    
    public Bestilling(int bestilNr, LocalTime afhentTid,
            /*ArrayList<*/Bestillingslinje/*>*/ bestilLinje/*r*/) {
        this.bestilNr = bestilNr;
        this.afhentTid = afhentTid;
        this.bestilLinje = bestilLinje;
    }

    public int getBestilNr() {
        return bestilNr;
    }

    public LocalTime getAfhentTid() {
        return afhentTid;
    }

    @Override
    public String toString() {
        return "Ordre Nr:\t\t" + bestilNr
                + "\nAfhentningstidspunkt:  \t" + afhentTid
                + "\nOrdre beskrivelse:\n\t" /*1 x "*/
                + "\nPris: \t\t\t     " /*+ (int) pizza.getPris() + ",-\n"*/;
    }
}
