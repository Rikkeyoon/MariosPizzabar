package presentation;

import businesslogic.*;
import java.util.ArrayList;

/*
 * @author Stephanie, Nina, Rikke og Caroline
 */

public interface UI {

    public int vælgPizza();
    public void visPizzaValg(String str);
    public void visOrdreNr(Bestilling bestilling);
    public void visMenukort(Menukort menukort);
    public void visHovedmenu();
    public String hovedmenuValg();
    public void visBestillingsliste();
    public void visAktiveOrdre(ArrayList<Bestilling> aktiveOrdre);
    public int vælgOrdreNr();
}
