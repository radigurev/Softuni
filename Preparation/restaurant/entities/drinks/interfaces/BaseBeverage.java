package restaurant.entities.drinks.interfaces;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseBeverage implements Beverages {
    private String name, brand;
    private int counter;
    private double price;

    protected BaseBeverage(String name, String brand, int counter, double price) {
        setName(name);
        setBrand(brand);
        setCounter(counter);
        setPrice(price);
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException(INVALID_NAME);

        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty())
            throw new IllegalArgumentException(INVALID_BRAND);

        this.brand = brand;
    }

    private void setCounter(int counter) {
        if (counter <= 0)
            throw new IllegalArgumentException(INVALID_COUNTER);

        this.counter = counter;
    }

    private void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException(INVALID_PRICE);
        this.price = price;
    }
}
