/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author carol
 */
public class Pizza {
    private int pizzaNr;
    private String pizzaNavn;
    private double pris;
    private String pizzaToppings;

    public Pizza(int pizzaNr, String pizzaNavn, String pizzaToppings, double pris) {
        this.pizzaNr = pizzaNr;
        this.pizzaNavn = pizzaNavn;
        this.pris = pris;
        this.pizzaToppings = pizzaToppings;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public double getPris() {
        return pris;
    }

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    @Override
    public String toString() {
        return pizzaNr + ". " + pizzaNavn + ": " + pizzaToppings + "........" 
                + (int)pris + ",-";
    }
}
