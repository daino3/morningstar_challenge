import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StoreTest {
    public Store storeTest;
    public Customer customerTest;
    public Register registerTest;
    public ArrayList customerList;
    public ArrayList registerList;

    @Before public void initialize() {
        customerTest = new Customer("A", 5, 1);
        registerTest = new Register(1);
        customerList = new ArrayList();
        registerList = new ArrayList();
        customerList.add(customerTest);
        registerList.add(registerTest);
        storeTest    = new Store(registerList, customerList);
    }

    @Test
    public void storeDataTest() {
        assertEquals("Returns the register list", storeTest.registers.get(0), registerTest);
        assertEquals("Returns the customer list", storeTest.customers.get(0), customerTest);
    }

    @Test
    public void allCustomersServedTest() {
        boolean firstResult = storeTest.allCustomersServed();
        assertEquals("Returns false if there are un-served customers", firstResult, false);
        customerTest.served = true;
        boolean secondResult = storeTest.allCustomersServed();
        assertEquals("Returns true if all customers are served", secondResult, true);
    }

    @Test
    public void findLineArrivalsTest() {
        Customer anotherCustomer = new Customer("B", 5, 3);
        storeTest.addCustomer(anotherCustomer);
        storeTest.time = 3;
        ArrayList arrivals = storeTest.findLineArrivals();
        assertEquals("Returns false if there are un-served customers", arrivals.get(0), anotherCustomer);
    }

    @Test
    public void shortestLineTest() {
      storeTest.registers.remove(0);
      Register registerA = new Register(1);
      Register registerB = new Register(1);

      Customer customerA = new Customer("A", 3, 1);
      Customer customerB = new Customer("A", 1, 1);
      Customer customerC = new Customer("B", 5, 1);

      storeTest.addRegister(registerA);
      storeTest.addRegister(registerB);
      registerA.customers.add(customerA);
      registerA.customers.add(customerB);
      registerB.customers.add(customerC);
      Register shortest = (Register) storeTest.shortestLine();
      assertEquals("It returns the register with the minimum number of customers", shortest, registerB);
    }

    @Test
    public void lastCustomerWithLeastItemsTest() {
        storeTest.registers.remove(0);
        Register registerA = new Register(1);
        Register registerB = new Register(1);

        Customer customerA = new Customer("A", 3, 1);
        Customer customerB = new Customer("A", 1, 1);
        Customer customerC = new Customer("B", 5, 1);

        storeTest.addRegister(registerA);
        storeTest.addRegister(registerB);
        registerA.customers.add(customerA);
        registerA.customers.add(customerB);
        registerB.customers.add(customerC);
        Register minNumItems = (Register) storeTest.lastCustomerWithLeastItems();
        assertEquals("It returns the register with the minimum number of customers", minNumItems, registerA);
    }
}
