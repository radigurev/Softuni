package shopAndGoods;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
        private Shop shop;

        @Before
    public void setUp(){
            this.shop=new Shop();
        }


        @Test(expected = UnsupportedOperationException.class)
        public void testShelfReturnsUnmodifiable(){
            shop.getShelves().clear();
        }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddGoodsShoudlFailForInvalidShelve() throws OperationNotSupportedException {
            shop.addGoods("invalid_test",null );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfShelfIsAlreadyTaken() throws OperationNotSupportedException {
            Goods goods=new Goods("test","test");
            shop.addGoods("Shelves1",goods);
            shop.addGoods("Shelves1",goods);
    }
    @Test
    public void TestifGoodsArePlacedSuccessfully() throws OperationNotSupportedException {
        Goods goods=new Goods("test","test");
        String real=shop.addGoods("Shelves1",goods);
        String expected="Goods: test is placed successfully!";
        assertEquals(expected,real);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfShelfExistRemovingGoods(){
        Goods goods=new Goods("test","test");
            shop.removeGoods("test",goods);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfShelveGoodsExist() throws OperationNotSupportedException {
        Goods goods=new Goods("test","test");
        Goods good1=new Goods("test1","test1");
        shop.addGoods("Shelve1",goods);
        shop.removeGoods("Shelve1",good1);
    }
    @Test
    public void SuccessfullyRemovedGood() throws OperationNotSupportedException {
        Goods goods=new Goods("test","test");
        shop.addGoods("Shelves1",goods);
        String str="Goods: test is removed successfully!";
        String real=shop.removeGoods("Shelves1",goods);
        assertEquals(str,real);
    }
}