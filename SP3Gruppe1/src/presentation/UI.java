package presentation;

import businesslogic.*;
import java.sql.Time;

/*
 * @author Stephanie, Nina, Rikke og Caroline
 */

public interface UI {

    public void visHovedmenu();
    public String hovedmenuValg();
    public void visMenukort(Pizza pizza);
    public void visBestillinger(Bestilling bestilling);
    public int vælgBestilNrPåBestillingSomGemmes();
    public void visGemteBestillinger(Bestilling bestilling);
    public void visBestillingsMenu();
    public Time vælgAfhentTid();
    public int vælgAntal();
    public int vælgPizzalNr();
}
