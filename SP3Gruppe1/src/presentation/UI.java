package presentation;

import businesslogic.*;
import java.time.LocalTime;

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
    public LocalTime vælgAfhentTid();
    public int vælgAntal();
    public int vælgPizzalNr();

    public void visPizzaNavn(String pizzaNavn);

}
