import java.util.*;


public class CustomerSorter {
    ArrayList customers;

    public CustomerSorter(ArrayList customerList) {
        this.customers = customerList;
    }

    public List sortByTypeAndItems() {
        Collections.sort(customers);
        return customers;
    }

}
