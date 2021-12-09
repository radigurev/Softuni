package restaurant.entities.drinks.interfaces;

public class Fresh extends BaseBeverage {
    private static final double PRICE=3.5;
    public Fresh(String name, String brand, int counter) {
        super(name, brand, counter, PRICE);
    }
}
