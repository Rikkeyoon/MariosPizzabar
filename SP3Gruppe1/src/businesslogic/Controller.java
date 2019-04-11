package businesslogic;

import datalag.DBFacade;
import java.util.ArrayList;
import presentation.UI;

/*
 * @author Nina, Rikke og Caroline
 */
public class Controller {

    private UI ui;
    private DBFacade db;
  
    public Controller(UI ui, DBFacade db) {
        this.ui = ui;
        this.db = db;
     
    }

    public void start() {
        boolean quit = false;
        ui.visHovedmenu();

        do {
            switch (ui.hovedmenuValg()) {
                case "1":
                    db.visMenukort();
                    break;
                case "2":
                    ui.visBestillingsMenu();
                    do {
                        switch (ui.hovedmenuValg()) {
                            case "1":
                                db.visBestillinger();
                                break;
                            case "2":
                                db.opretBestilling();
                                break;
                            case "3":
                                db.gemBestilling();
                                break;
                            case "4":
                                db.visGemteBestillinger();
                                break;
                            case "5":
                                quit = true;
                                start();
                                break;
                            case "0":
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } while (!quit);
    }
}




