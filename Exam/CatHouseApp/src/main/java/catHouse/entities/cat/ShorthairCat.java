package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private final static int INITIAL_KILO=7;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILO);
    }
    @Override
    public void eating() {
        super.setKilograms(super.getKilograms()+1);
    }

}
