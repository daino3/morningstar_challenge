import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

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

    @Test
    public void getInLineTest() {
        Register registerA = new Register(1);
        Register registerB = new Register(1);

        Customer customerA = new Customer("A", 3, 1);
        Customer customerB = new Customer("A", 5, 1);
        Customer customerC = new Customer("B", 1, 1);

        registerA.addCustomer(customerA);
        registerB.addCustomer(customerB);
        registerB.addCustomer(customerC);

        ArrayList customers = new ArrayList();
        customers.add(customerA);
        customers.add(customerB);
        customers.add(customerC);

        ArrayList registers = new ArrayList();
        registers.add(registerA);
        registers.add(registerB);

        Store storeTest = new Store(registers, customers);
        /* Register A : CustomerA (A, 3 items)
           Register B : CustomerB (A, 5 item), CustomerC (B, 1 items)
         */

        Customer customerTestA = new Customer("A", 10, 1); /*Test should choose Register A*/
        Customer customerTestB = new Customer("B", 10, 1); /*Test should choose Register B*/

        customerTestA.getInLine(storeTest);
        customerTestB.getInLine(storeTest);

        assertEquals("it puts itself in the line of the correct register", isInline(registerA, customerTestA), true);
        assertEquals("it puts itself in the line of the correct register", isInline(registerB, customerTestB), true);
    }

    public boolean isInline(Register register, Customer customer) {
        Iterator it = register.customers.iterator();
        boolean value = false;

        while (it.hasNext()) {
            Customer x = (Customer) it.next();
            if (x == customer) value = true;
        }
        return value;
    }
}
