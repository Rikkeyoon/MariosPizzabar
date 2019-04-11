package presentation;

import businesslogic.*;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Nina, Rikke og Caroline
 */
public class SystemUI implements UI {
    
    private Scanner input = new Scanner(System.in);
    
    @Override
    public void visHovedmenu() {
        System.out.println("Vælg en af følgende muligheder:\n"
                + "1. Vis menukort\n"
                + "2. Bestillinger\n"
                + "0. Afslut program");
    }
    
    @Override
    public String hovedmenuValg() {
        int valg = input.nextInt();
        while (valg < 0 || valg > 2)
        {
            System.out.println(valg + " er ikke en mulighed, prøv igen: ");
            valg = input.nextInt();
        }
    
        return valg + "";
    }
    
    @Override
    public void visMenukort(ArrayList<Pizza> menukort) {
        for (Pizza pizza : menukort) {
            System.out.println(pizza.toString());            
        }
    }
    
    @Override
    public void visBestillinger(ArrayList<Bestilling> bestillinger) {
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling.toString());            
        }
    }
    
    @Override
    public int vælgBestilNrPåBestillingSomGemmes() {
        System.out.println("Indtast bestillingsnummeret på den bestilling, som du vil fjerne: ");
        return input.nextInt();
    }
    
    @Override
    public void visGemteBestillinger(ArrayList<Bestilling> bestillinger) {
        for (Bestilling bestilling : bestillinger) {
           System.out.println(bestilling.toString()); 
        }
    }
    
    @Override
    public void visBestillingsMenu() {
        System.out.println("Bestillinger\n"
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
        System.out.println("Skriv hvornår bestillingen skal afhentes i HH:MM format: ");
        input.nextLine();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm");
        
        String time = input.nextLine();
        return LocalTime.parse(time, dft);
    }
    
    @Override
    public int vælgAntal() {
        System.out.println("Skriv hvor mange pizzaer af denne variant som kunden ønsker: ");
        int valg = input.nextInt();
//        
//        if (valg != (int)valg){
//            System.out.println(valg + " er ikke en mulighed, prøv igen: ");
//            valg = input.nextInt();
//        
//        }
        return valg;
        
       
        
    }
    
    @Override
    public int vælgPizzaNr() {
        System.out.println("Skriv hvilket pizzanummer kunden ønsker:");
        int valg = input.nextInt();
        
//        if (valg < 1 || valg > 14) {
//            System.out.println(valg + " er ikke en mulighed, prøv igen: ");
//            valg = input.nextInt();
//        }
        return valg;
        
    }
    
    @Override
    public void visPizzaNavn(String pizzaNavn) {
        System.out.println(pizzaNavn);
    }
}

