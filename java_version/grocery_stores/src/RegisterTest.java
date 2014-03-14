import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class RegisterTest {
    public Register testRegister;
    public Customer testCustomer;

    @Before
    public void initialize() {
      testRegister = new Register(1.0);
      testCustomer = new Customer("A", 5, 4);
    }

    @Test
    public void dataTest() {
      double speedVar = testRegister.getSpeed();
      assertEquals("It correctly initializes speed variable", speedVar, 1.0);
      assertEquals("It correctly initializes an empty ArrayList", testRegister.customers.isEmpty(), true);
    }

    @Test
    public void addCustomerTest() {
      testRegister.addCustomer(testCustomer);
      Customer variable = (Customer) testRegister.customers.get(0);
      assertEquals("It adds an instance of customer to the list", variable, testCustomer);
    }

    @Test
    public void serveCurrentCustomerTest() {
        Customer testCustomer2 = new Customer("A", 1, 4);
        testRegister.addCustomer(testCustomer2);
        testRegister.serveCurrentCustomer();
        assertEquals("It reduces the first customer in the list's items", testCustomer2.items, 0.0);
        assertEquals("It removes the customer from the list if items is 0", testRegister.isEmpty(), true);
    }

    @Test
    public void lineLengthTest() {
        Customer testCustomer2 = new Customer("A", 1, 4);
        Customer testCustomer3 = new Customer("B", 2, 2);
        testRegister.addCustomer(testCustomer);
        testRegister.addCustomer(testCustomer2);
        testRegister.addCustomer(testCustomer3);
        assertEquals("Returns the number of customers in the list", testRegister.lineLength(), 3);
    }

    @Test
    public void lastCustomerItemsTest() {
        Customer testCustomer2 = new Customer("A", 20, 4);
        testRegister.addCustomer(testCustomer);
        testRegister.addCustomer(testCustomer2);
        assertEquals("Returns the number of items of the customer at the end of the customers list", testRegister.lastCustomerItems(), 20.0);
        Register testRegister2 = new Register(1.0);
        assertEquals("Returns 0 when the customers list is empty", testRegister2.lastCustomerItems(), 0.0);
    }



}
