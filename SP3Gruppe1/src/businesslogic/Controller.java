package businesslogic;

import java.util.ArrayList;
import presentation.UI;

/*
 * @author Nina, Rikke og Caroline
 */
public class Controller {

    private UI ui;
    private int pizzaNr;
    private ArrayList<Bestilling> aktiveOrdre;
    private Menukort menukort;
    private int currentOrderNr;

    public Controller(UI ui, Menukort menukort) {
        this.ui = ui;
        this.menukort = menukort;
        aktiveOrdre = new ArrayList<>();
        currentOrderNr = 1;
    }

    public void start() {
        boolean quit = false;
        ui.visHovedmenu();

        do {
            switch (ui.hovedmenuValg()) {
                case "1":
                    visMenukort();
                    break;
                case "2":
                    ui.visBestillingsliste();
                    ui.visAktiveOrdre(aktiveOrdre);
                    do {
                        switch (ui.hovedmenuValg()) {
                            case "1":
                                opretBestilling();
                                break;
                            case "2":
                                fjernBestilling();
                                break;
                            case "3":
                                quit = true;
                                start();
                                break;
                            case "4":
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } while (!quit);
    }

    public void opretBestilling() {
        //indlæs pizza nr
        pizzaNr = ui.vælgPizza();

        //opret bestilling
        Bestilling bestilling = new Bestilling(menukort.getPizza(pizzaNr),
                currentOrderNr);

        //tilføj bestilling til aktive ordreliste
        aktiveOrdre.add(bestilling);

        //vis ordreNr på skærm
        ui.visOrdreNr(bestilling);

        //vis pizzavalg
        ui.visPizzaValg(bestilling.getPizza().getPizzaNavn());

        //tæl ordreNr op
        currentOrderNr++;
    }

    public void visMenukort() {
        ui.visMenukort(menukort);
    }

    public ArrayList<Bestilling> getAktiveOrdre() {
        return aktiveOrdre;
    }

    private void fjernBestilling() {
        int brugervalg = ui.vælgOrdreNr();

        try {
            for (int i = 0; i < aktiveOrdre.size(); i++) {
                if ((aktiveOrdre.get(i).getOrdreNr()) == brugervalg) {

                    //gem bestilling i arkiv
                    FileFacade fileFacade = new FileFacade();
                    fileFacade.gemBestilling(aktiveOrdre.get(i));

                    //fjern fra listen
                    aktiveOrdre.remove(aktiveOrdre.get(i));
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }
}
