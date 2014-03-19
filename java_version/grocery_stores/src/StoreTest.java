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
        customerTest = new Customer("A", 1, 4.0);
        customerList = new ArrayList();
        customerList.add(customerTest);

        registerTest = new Register(1);
        registerList = new ArrayList();
        registerList.add(registerTest);

        storeTest = new Store(registerList, customerList);
    }

    @Test
    public void storeDataTest() {
        assertEquals("Returns the register list", storeTest.registers.get(0), registerTest);
        assertEquals("Returns the customer list", storeTest.customers.get(0), customerTest);
    }

    /* ========= TESTS HARD-CODING PARSED DATA TO PROVE APPLICATION WORKS ========= */

    @Test
    public void exampleOneTest() {

        /*--------- CREATE CUSTOMERS --------*/
        Customer customerTestA = new Customer("A", 1, 2);
        Customer customerTestB = new Customer("A", 2, 1);

        ArrayList<Customer> customers = new ArrayList();
        customers.add(customerTestA);
        customers.add(customerTestB);

        /*--------- CREATE REGISTERS --------*/
        Register register = new Register(0.5);
        ArrayList registers = new ArrayList();
        registers.add(register);

        /*--------- CREATE STORE --------*/
        Store store = new Store(registers, customers);
        int elapsedTime = store.main();

        assertEquals("Example 1 returns the correct time", 7, elapsedTime);
    }

    @Test
    public void exampleTwoTest() {

        /*--------- CREATE CUSTOMERS --------*/
        Customer customerTestA = new Customer("A", 1, 5);
        Customer customerTestB = new Customer("B", 2, 1);
        Customer customerTestC = new Customer("A", 3, 5);
        Customer customerTestD = new Customer("B", 5, 3);
        Customer customerTestE = new Customer("A", 8, 2);

        ArrayList<Customer> customers = new ArrayList();
        customers.add(customerTestA);
        customers.add(customerTestB);
        customers.add(customerTestC);
        customers.add(customerTestD);
        customers.add(customerTestE);

        /*--------- CREATE REGISTERS --------*/
        Register registerA = new Register(1.0);
        Register registerB = new Register(0.5);

        ArrayList registers = new ArrayList();
        registers.add(registerA);
        registers.add(registerB);

        Store store = new Store(registers, customers);
        int elapsedTime = store.main();

        assertEquals("Example 2 returns the correct time", 13, elapsedTime);
    }

    @Test
    public void exampleThreeTest() {

        /*--------- CREATE CUSTOMERS --------*/
        Customer customerTestA = new Customer("A", 1, 2);
        Customer customerTestB = new Customer("A", 1, 2);
        Customer customerTestC = new Customer("A", 2, 1);
        Customer customerTestD = new Customer("A", 3, 2);

        ArrayList<Customer> customers = new ArrayList();
        customers.add(customerTestA);
        customers.add(customerTestB);
        customers.add(customerTestC);
        customers.add(customerTestD);

        /*--------- CREATE REGISTERS --------*/
        Register registerA = new Register(1.0);
        Register registerB = new Register(0.5);

        ArrayList registers = new ArrayList();
        registers.add(registerA);
        registers.add(registerB);

        Store store = new Store(registers, customers);
        int elapsedTime = store.main();

        assertEquals("Example 3 returns the correct time", 6, elapsedTime);
    }

    @Test
    public void exampleFourTest() {

        /*--------- CREATE CUSTOMERS --------*/
        Customer customerTestA = new Customer("A", 1, 2);
        Customer customerTestB = new Customer("A", 1, 3);
        Customer customerTestC = new Customer("A", 2, 1);
        Customer customerTestD = new Customer("A", 2, 1);

        ArrayList<Customer> customers = new ArrayList();
        customers.add(customerTestA);
        customers.add(customerTestB);
        customers.add(customerTestC);
        customers.add(customerTestD);

        /*--------- CREATE REGISTERS --------*/
        Register registerA = new Register(1.0);
        Register registerB = new Register(0.5);

        ArrayList registers = new ArrayList();
        registers.add(registerA);
        registers.add(registerB);

        Store store = new Store(registers, customers);
        int elapsedTime = store.main();

        assertEquals("Example 4 returns the correct time", 9, elapsedTime);
    }

    @Test
    public void exampleFiveTest() {

        /*--------- CREATE CUSTOMERS --------*/
        Customer customerTestA = new Customer("A", 1, 3);
        Customer customerTestB = new Customer("A", 1, 5);
        Customer customerTestC = new Customer("A", 3, 1);
        Customer customerTestD = new Customer("B", 4, 1);
        Customer customerTestE = new Customer("A", 4, 1);

        ArrayList<Customer> customers = new ArrayList();
        customers.add(customerTestA);
        customers.add(customerTestB);
        customers.add(customerTestC);
        customers.add(customerTestD);
        customers.add(customerTestE);

        /*--------- CREATE REGISTERS --------*/
        Register registerA = new Register(1.0);
        Register registerB = new Register(0.5);

        ArrayList registers = new ArrayList();
        registers.add(registerA);
        registers.add(registerB);

        Store store = new Store(registers, customers);
        int elapsedTime = store.main();

        assertEquals("Example 5 returns the correct time", 11, elapsedTime);
    }

    /* ============= END OF APPLICATION TESTS =============== */

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
        ArrayList<Customer> arrivals = storeTest.findLineArrivals();
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

    @Test
    public void serviceCustomersTest() {
        registerTest.addCustomer(customerTest);
        storeTest.serviceCustomers();
        double newItemCount = customerTest.items;
        assertEquals("It reduces the items of the customers in each register", newItemCount, 3.0);
    }
}
