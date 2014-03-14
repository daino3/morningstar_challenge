import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class CustomerTest {
    public Customer test;

    @Before
    public void initialize() {
        test = new Customer("A", 5.0, 1);
    }

    @Test
    public void testCustomerData() {
        assertEquals("Type isn't being set", test.type, "A");
        assertEquals("Items isn't being set", test.items, 5.0);
        assertEquals("ArrivalTime isn't being set", test.arrivalTime, 1);
        assertEquals("Served isn't being set", test.served, false);
    }

    @Test
    public void ringItemTest() {
        test.ringItem(1.0);
        assertEquals("ringItem reduces number of items", test.items, 4.0);
        test.items = 1.0;
        test.ringItem(1.0);
        assertEquals("ringItem changes the boolean value of served to true", test.served, true);
    }
}
