package presentation;

import businesslogic.*;
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
    public int vælgPizza() {
        output.add("Skriv hvilket pizza nummer kunden har bestilt: ");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visPizzaValg(String str) {
        output.add(str);
    }

    @Override
    public void visOrdreNr(Bestilling bestilling) {
        output.add("" + bestilling.getOrdreNr());
    }



    @Override
    public void visHovedmenu() {
        output.add("Vælg en af følgende muligheder: ");
        output.add("1. Vis menukort");
        output.add("2. Opret bestilling");
        output.add("3. Afslut program");
    }

    @Override
    public String hovedmenuValg() {
        return input[index++];
    }

    @Override
    public void visBestillingsliste() {
        output.add("Bestillinger\n"
                + "Vælg en af følgende muligheder:\n"
                + "1. Opret bestilling\n"
                + "2. Fjern bestilling\n"
                + "3. Vend tilbage til hovedmenu\n"
                + "4. Afslut program\n");
    }

    @Override
    public void visAktiveOrdre(ArrayList<Bestilling> aktiveOrdre) {
        StringBuilder builder = new StringBuilder();
        for (Bestilling bestilling : aktiveOrdre) {
            builder.append(bestilling.toString());
            builder.append("\n");
        }
        output.add(builder.toString());
    }

    @Override
    public int vælgOrdreNr() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visMenukort(Pizza pizza) {
       output.add(pizza.toString());
    }
    
}
