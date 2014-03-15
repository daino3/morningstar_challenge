import org.junit.Before;

import java.util.ArrayList;

public class CustomerSorterTest {
    ArrayList customers;

    @Before
    public void initialize(){
        Customer customerA = new Customer("B", 3, 1);
        Customer customerB = new Customer("A", 1, 1);
        Customer customerC = new Customer("B", 5, 1);
        Customer customerD = new Customer("A", 5, 1);
        Customer customerE = new Customer("B", 5, 1);
        Customer[] customerList = Customer[]{customerA, customerB, customerC, customerD, customerE};
        customers.add(customerA);
    }
}
