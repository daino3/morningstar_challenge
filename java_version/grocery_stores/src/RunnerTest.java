import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;


public class RunnerTest {
    String fileLocation;
    Runner testRunner;

    @Before
    public void initialize() {
        fileLocation = "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_one.txt";
        testRunner = new Runner();
    }

    @Test
    public void mainTest() {
        testRunner.main();
    }

    @Test
    public void createStoreTest() {
       Store store = testRunner.createStore(fileLocation);

       ArrayList<Register> registers = store.registers;
       ArrayList<Customer> customers = store.customers;

       /* ------ REGISTER TESTS ------*/

       Register register    = registers.get(0);
       Double registerSpeed = register.getSpeed();
       int registerCount    = registers.size();

       assertEquals(registerCount, 1);
       assertEquals(registerSpeed, 0.5);

       /* ------ FIRST CUSTOMER TESTS ------*/

       Customer customerA       = customers.get(0);
       String customerAType     = customerA.type;
       Double customerAItems    = customerA.items;
       int customerAArrivalTime = customerA.arrivalTime;

        assertEquals("Correct CustomerA Type", customerAType, "A");
        assertEquals(customerAItems, 2.0);
        assertEquals(customerAArrivalTime, 1);

       /* ------ SECOND CUSTOMER TESTS ------*/

        Customer customerB       = customers.get(1);
        String customerBType     = customerB.type;
        Double customerBItems    = customerB.items;
        int customerBArrivalTime = customerB.arrivalTime;

        assertEquals("Correct CustomerB Type", customerBType, "A");
        assertEquals(customerBItems, 1.0);
        assertEquals(customerBArrivalTime, 2);

        /* ------ NUM CUSTOMERS TESTS ------*/

       int customerCount = customers.size();

       assertEquals(customerCount, 2);
    }
}
