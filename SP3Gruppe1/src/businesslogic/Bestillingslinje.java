package businesslogic;

/*
 *
 * @author Caroline, Nina og Rikke
 */
public class Bestillingslinje {
    private int antal;
    private int pizzaNr;
    
    public Bestillingslinje(int antal, int pizzaNr) {
        this.antal = antal;
        this.pizzaNr = pizzaNr;
    }

    public int getAntal() {
        return antal;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }
}
