package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    private House house;

    @Before
    public void setUp(){
        this.house=new House("name",2);
    }


    @Test(expected = NullPointerException.class)
    public void testIfThrowsNullForName(){
        house=new House("   ",3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfThrowsIllegalForCapacity(){
        house=new House("test",-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfHouseIsFull(){
        Cat cat=new Cat("test");
        house.addCat(cat);
        house.addCat(cat);
        house.addCat(cat);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalForRemoveCat(){
        house.removeCat("test2");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfCatIsForSaleThrowsIllegal(){
        house.addCat(new Cat("uga"));
        house.catForSale("test");
    }
    @Test
    public void testStatisticsPrint(){
        String expected="The cat test, test2 is in the house name!";
        Cat cat=new Cat("test");
        Cat cat1=new Cat("test2");
        house.addCat(cat);
        house.addCat(cat1);
        String result=house.statistics();
        assertEquals(expected,result);
    }

}
