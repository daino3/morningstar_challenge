import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser test;

    @Before
    public void initialize() {
        test = new Parser("/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_one.txt");
    }

    @Test
    public void parserDataTest() {
        test.parse();

        String numReg = test.instructions.get(0);
        assertEquals("It opens the correct files", "1", numReg);

        String firstCustomer = test.instructions.get(1);
        assertEquals("It opens the correct files", "A 1 2", firstCustomer);

        String secondCustomer = test.instructions.get(2);
        assertEquals("It opens the correct files", "A 2 1", secondCustomer);
    }

    @Test
    public void createRegistersTest() {
        test.parse();
        test.createRegisters();
        Register results = test.registers.get(0);
        assertEquals(0.5, results.getSpeed(), 1.0);
    }

    @Test
    public void createCustomersTest() {
        test.parse();
        test.createCustomers();

        Customer customerA = test.customers.get(0);
        assertEquals("It creates the first customer with the correct type", customerA.type, "A");
        assertEquals(customerA.items, 2.0, 0.0);
        assertEquals("It creates the first customer with the correct arrival time", customerA.arrivalTime, 1);

        Customer customerB = test.customers.get(1);
        assertEquals("It creates the second customer with the correct type", customerB.type, "A");
        assertEquals(customerB.items, 1.0, 0.0);
        assertEquals("It creates the second customer with the correct arrival time", customerB.arrivalTime, 2);
    }

    @Test
    public void mainTest() {
        Store store = test.main();
        ArrayList<Register> registers = store.registers;
        ArrayList<Customer> customers = store.customers;
        assertEquals("It creates the correct number of registers", registers.size(), 1);
        assertEquals("It creates the correct number of customers", customers.size(), 2);
    }
}
