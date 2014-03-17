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
        String results = test.instructions.get(1);
        assertEquals("It opens the correct files", "A 1 2", results);
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
        Customer results = test.customers.get(0);
        assertEquals("It creates a customer with the correct type", results.type, "A");
        assertEquals(results.items, 2.0, 0.0);
        assertEquals("It creates a customer with the correct arrival time", results.arrivalTime, 1);
    }

    @Test
    public void mainTest() {
        Store store = test.main();
        ArrayList<Register> registers = store.registers;
        ArrayList<Customer> customers = store.customers;
        assertEquals("It creates a customer and stores it with the correct type", registers.size(), 1);
        assertEquals("It creates a customer and stores it with the correct type", customers.size(), 2);
    }
}
