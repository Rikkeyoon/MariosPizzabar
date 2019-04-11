package presentation;

import businesslogic.*;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * @author Stephanie, Nina, Rikke og Caroline
 */

public interface UI {

    public void visHovedmenu();
    public String hovedmenuValg();
    public void visMenukort(ArrayList<Pizza> menukort);
    public void visBestillinger(ArrayList<Bestilling> bestillinger);
    public int vælgBestilNrPåBestillingSomGemmes();
    public void visGemteBestillinger(ArrayList<Bestilling> bestillinger);
    public void visBestillingsMenu();
    public LocalTime vælgAfhentTid();
    public int vælgAntal();
    public int vælgPizzaNr();
    public void visPizzaNavn(String pizzaNavn);
    public int bestillingsMenuValg();

}
