package presentation;

import businesslogic.*;
import java.sql.Time;
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
        output.add("" + bestilling.getBestilNr());
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

    @Override
    public void visBestillinger(Bestilling bestilling) {
        output.add(bestilling.toString());
    }

    @Override
    public int vælgBestilNrPåBestillingSomGemmes() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visGemteBestillinger(Bestilling bestilling) {
        output.add(bestilling.toString());
    }

       @Override
    public void visBestillingsMenu() {
        output.add("Bestillinger\n"
                + "Vælg en af følgende muligheder:\n"
                + "1. Opret bestilling\n"
                + "2. Fjern bestilling\n"
                + "3. Se gemte bestillinger\n"
                + "4. Vend tilbage til hovedmenu\n"
                + "5. Afslut program\n");
    }

    @Override
    public Time vælgAfhentTid() {
        output.add("Skriv hvornår bestillingen skal afhentes i HH:MM:SS format: ");
        return Time.valueOf(input[index++]);
    }

    @Override
    public int vælgAntal() {
        output.add("Skriv hvor mange pizzaer af denne variant som kunden ønsker: ");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public int vælgPizzalNr() {
        output.add("Skriv hvilket pizzanummer kunden har bestilt: ");
        return Integer.parseInt(input[index++]);
    }
    
}
