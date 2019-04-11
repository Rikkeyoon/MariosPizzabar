package presentation;

import businesslogic.*;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * @author Nina, Rikke og Caroline
 */

public class FakeUI implements UI {
    
    String[] input;
    int index = 0;
    public ArrayList<String> output = new ArrayList<>();
    
    public FakeUI(String[] input) {
        this.input = input;
    }

    @Override
    public void visHovedmenu() {
        output.add("Vælg en af følgende muligheder: ");
        output.add("1. Vis menukort");
        output.add("2. Opret bestilling");
        output.add("0. Afslut program");
    }

    @Override
    public int hovedmenuValg() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visMenukort(ArrayList<Pizza> menukort) {
        for (Pizza pizza : menukort) {
            output.add(pizza.toString());
        }
    }

    @Override
    public void visBestillinger(ArrayList<Bestilling> bestillinger) {
        for (Bestilling bestilling : bestillinger) {
           output.add(bestilling.toString()); 
        }
    }

    @Override
    public int vælgBestilNrPåBestillingSomGemmes() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visGemteBestillinger(ArrayList<Bestilling> bestillinger) {
        for (Bestilling bestilling : bestillinger) {
           output.add(bestilling.toString()); 
        }
    }

       @Override
    public void visBestillingsMenu() {
        output.add("Bestillinger\n"
                + "Vælg en af følgende muligheder:\n"
                + "1. Se bestillinger\n"
                + "2. Opret bestilling\n"
                + "3. Fjern bestilling\n"
                + "4. Se gemte bestillinger\n"
                + "5. Vend tilbage til hovedmenu\n"
                + "0. Afslut program");
    }

    @Override
    public LocalTime vælgAfhentTid() {
        output.add("Skriv hvornår bestillingen skal afhentes i HH:MM:SS format: ");
        return LocalTime.parse(input[index++]);
    }

    @Override
    public int vælgAntal() {
        output.add("Skriv hvor mange pizzaer af denne variant som kunden ønsker: ");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public int vælgPizzaNr() {
        output.add("Skriv hvilket pizzanummer kunden har bestilt: ");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visPizzaNavn(String pizzaNavn) {
        output.add(pizzaNavn);
    }

    @Override
    public int bestillingsMenuValg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
