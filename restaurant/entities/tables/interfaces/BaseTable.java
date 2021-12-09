package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number, size, numberOfPeople;
    private double pricePerPerson, allPeople;
    private boolean isReservedTable;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.allPeople = 0;
        this.isReservedTable = false;
    }

    private void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);

        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0)
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.isReservedTable = true;
        this.allPeople = numberOfPeople * this.pricePerPerson;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double bill = 0;
        bill = this.allPeople;
        bill += this.healthyFood.stream()
                .mapToDouble(HealthyFood::getPrice).sum()
                + this.beverages.stream()
                .mapToDouble(Beverages::getPrice).sum();
        return bill;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n"
                        + "Size - %d%n"
                        + "Type - %s%n"
                        + "All price - %f",
                this.number,
                this.size,
                this.getClass().getSimpleName(),
                this.pricePerPerson);
    }
}
