package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        if (!type.equals("LongHouse") && !type.equals("ShortHouse"))
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        this.houses.add(type.equals("ShortHouse")
                ? new ShortHouse(name)
                : new LongHouse(name));
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        switch (type) {
            case "Mouse":
                this.toys.buyToy(new Mouse());
                break;
            case "Ball":
                this.toys.buyToy(new Ball());
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy t = toys.findFirst(toyType);
        if (t == null)
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));

        toys.removeToy(t);
        houses.stream().filter(h -> h.getName().equals(houseName)).forEach(hh -> hh.buyToy(t));
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        if (!catType.equals("LonghairCat") && !catType.equals("ShorthairCat"))
            throw new IllegalArgumentException(INVALID_CAT_TYPE);

        Cat cat=catType.equals("LonghairCat")?new LonghairCat(catName, catBreed, price):new ShorthairCat(catName, catBreed, price);
        String result="";
        for (House house :
                houses) {
            if (house.getName().equals(houseName)) {
                switch (catType) {
                    case "LonghairCat":
                        if (house.getClass().getSimpleName().equals("LongHouse")) {
                            result = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                            house.addCat(cat);
                        } else
                            result = UNSUITABLE_HOUSE;
                        break;
                    case "ShorthairCat":
                        if (house.getClass().getSimpleName().equals("ShortHouse")) {
                            result = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                            house.addCat(cat);
                        } else
                            result = UNSUITABLE_HOUSE;
                        break;
                }
            }
        }
        return result;
    }

    @Override
    public String feedingCat(String houseName) {
       String result="";
        for (House house:
             houses) {
            if(house.getName().equals(houseName)){
                house.feeding();
                result=String.format(FEEDING_CAT,house.getCats().size());
            }
        }
        return result;
    }

    @Override
    public String sumOfAll(String houseName) {
        double sum=0;
        for (House h:
             houses) {
            if (h.getName().equals(houseName)) {
                sum += h.getCats().stream().mapToDouble(Cat::getPrice).sum();
                sum += h.getToys().stream().mapToDouble(Toy::getPrice).sum();
            }
        }
        return String.format(VALUE_HOUSE,houseName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder result=new StringBuilder();
        for (House h:
             houses) {
            result.append(h.getStatistics());
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
