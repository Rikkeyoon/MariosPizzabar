package presentation;

import businesslogic.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Nina, Rikke og Caroline
 */

public class SystemUI implements UI {

    private Scanner input = new Scanner(System.in);

    @Override
    public int vælgPizza() {
        System.out.println("Skriv hvilket pizza nummer kunden har bestilt: ");
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public void visPizzaValg(String str) {
        System.out.println("Pizzaen som er bestilt: " + str);
    }

    @Override
    public void visOrdreNr(Bestilling bestilling) {
        System.out.println("Kunden har fået ordre nr: " + bestilling.getOrdreNr());
    }


    @Override
    public void visHovedmenu() {
        System.out.println("Vælg en af følgende muligheder:\n"
                + "1. Vis menukort\n"
                + "2. Bestillinger\n"
                + "3. Afslut program");
    }

    @Override
    public String hovedmenuValg() {
        return input.nextLine();
    }

    @Override
    public void visBestillingsliste() {
        System.out.println("Bestillinger\n"
                + "Vælg en af følgende muligheder:\n"
                + "1. Opret bestilling\n"
                + "2. Fjern bestilling\n"
                + "3. Vend tilbage til hovedmenu\n"
                + "4. Afslut program");
    }

    @Override
    public void visAktiveOrdre(ArrayList<Bestilling> aktiveOrdre) {
        StringBuilder builder = new StringBuilder();
        for (Bestilling bestilling : aktiveOrdre) {
            builder.append(bestilling.toString());
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    @Override
    public int vælgOrdreNr() {
        return input.nextInt();
    }

    @Override
    public void visMenukort(Pizza pizza) {
        System.out.println(pizza.toString());
    }

}
