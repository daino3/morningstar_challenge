import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class CustomerSorter implements Comparator<Customer> {
    ArrayList customers;

    public void CustomerSorter(ArrayList customerList) {
        customers = customerList;
    }

    public ArrayList sortByTypeAndItems() {
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer customer, Customer customer2) {
                return customer.type.compareTo(customer2.type);
            }
        })
        return customers;
    }
}
