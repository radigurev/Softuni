package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        toys=new ArrayList<>();
        cats=new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum=0;
        for (Toy t:
             toys) {
            sum+=t.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if(cats.size()>=capacity)
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {

        StringBuilder stats=new StringBuilder();
        stats.append(String.format("%s %s:",this.getName(),this.getClass().getSimpleName()));
        stats.append(System.lineSeparator());
        stats.append("Cats:");
        if(this.cats.size()>0) {
            for (Cat c :
                    cats) {
                stats.append(String.format(" %s", c.getName()));
            }
        }else
            stats.append(" none");
        stats.append(System.lineSeparator());
        stats.append(String.format("Toys: %d Softness: %d",this.toys.size(),sumSoftness()));
        return stats.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
            if(name==null || name.trim().isEmpty())
                throw new IllegalArgumentException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
            this.name=name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
