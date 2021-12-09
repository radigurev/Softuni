package shopAndGoods;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
        private Shop shop;

        @Before
    public void setUp(){
            this.shop=new Shop();
        }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddGoodsShoudlFailForInvalidShelve() throws OperationNotSupportedException {
            shop.addGoods("invalid_test",null );
    }
}