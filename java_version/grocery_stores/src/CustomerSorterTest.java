import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CustomerSorterTest {
    CustomerSorter sorter;
    Customer customerA;
    Customer customerB;
    Customer customerC;
    Customer customerD;
    Customer customerE;

    @Before
    public void initialize(){
        customerA = new Customer("B", 3, 1);
        customerB = new Customer("A", 1, 1);
        customerC = new Customer("B", 5, 1);
        customerD = new Customer("A", 5, 1);
        customerE = new Customer("B", 1, 1);
        ArrayList customerList = new ArrayList<Customer>();
        customerList.add(customerA);
        customerList.add(customerB);
        customerList.add(customerC);
        customerList.add(customerD);
        customerList.add(customerE);
        sorter = new CustomerSorter(customerList);
    }

    @Test
    public void sortByTypeTest() {
        List sortedCustomers = sorter.sortByTypeAndItems();
        Customer[] expectedArray = {customerB, customerD, customerE, customerA, customerC};
        List<Customer> expectedList = Arrays.asList(expectedArray);
        assertEquals("It sorts a list of customers by type", expectedList, sortedCustomers);
    }

}
