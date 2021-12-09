package farmville;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    Farm farm;
    @Before
    public void setUp(){
        farm=new Farm("name",2);
    }

    @Test
    public void TestIfItReturnsCount(){
        int i=farm.getCount();
        int expected=0;
        assertEquals(i,expected);
    }
    @Test
    public void testIfItReturnsName(){
        String name=farm.getName();
        String expected="name";
        assertEquals(expected,name);
    }
    @Test
    public void testIfItReturnsCapacity(){
        int capacity=farm.getCapacity();
        int expected=2;
        assertEquals(expected,capacity);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfYouCanAddAnimal(){
        Animal a=new Animal("ping",10);
        Animal b=new Animal("bird",10);
        Animal c=new Animal("dog",10);
        Animal d=new Animal("cat",10);
        farm.add(a);
        farm.add(b);
        farm.add(c);
        farm.add(d);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfYouHaveAlreadyExistingAnimal(){
        Animal a=new Animal("ping",10);
        farm.add(a);
        farm.add(a);
    }
    @Test
    public void testRemoveAnimal(){
        Animal a=new Animal("ping",10);
        farm.add(a);
        boolean bool=farm.remove("ping");
        assertTrue(bool);
    }
    @Test
    public void testifThereIsNoAnimalToRemove(){
        Animal a=new Animal("ping",10);
        farm.add(a);
        boolean bool=farm.remove("dog");
        assertFalse(bool);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity(){
        Farm farm=new Farm("name",-2);
    }
    @Test(expected = NullPointerException.class)
    public void TestSetName(){
        Farm farm=new Farm("    ",10);
    }


}
