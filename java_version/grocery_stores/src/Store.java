import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Store {
    public ArrayList registers;
    public ArrayList customers;
    public int time;

    public Store(ArrayList<Register> registerList, ArrayList<Customer> customerList) {
        registers = registerList;
        customers = customerList;
        time = 0;
    }

    public int main() {
        while (!allCustomersServed()) {
            placeCustomersInLine();
            serviceCustomers();
            time++;
        }
        return time;
    }

    public void printCustomerStatus() {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = (Customer) customers.get(i);
            System.out.println("Type: " + customer.type);
            System.out.println("Items: " + customer.items);
            System.out.println("ArrivalTime: " + customer.arrivalTime);
            System.out.println("Been Served?: " + customer.served);
        }
    }

    public void addCustomer(Customer x) { customers.add(x);}

    public void addRegister(Register x) { registers.add(x);}

    public boolean allCustomersServed() {
        boolean flag = true;
        Iterator it = customers.iterator();

        while(it.hasNext()) {
            Customer customer = (Customer) it.next();
            if (!customer.served) flag = false;
        }
        return flag;
    }

    public void placeCustomersInLine() {
        ArrayList arrivals = findLineArrivals();
        List sortedArrivals = sortArrivals(arrivals);
        for (int i = 0; i < sortedArrivals.size(); i++) {
            Customer customer = (Customer) sortedArrivals.get(i);
            customer.getInLine(this);
        }
    }

    public ArrayList findLineArrivals() {
        ArrayList newArrivals = new ArrayList();
        Iterator it = customers.iterator();

        while (it.hasNext()) {
            Customer customer = (Customer) it.next();
            if (customer.arrivalTime == time) newArrivals.add(customer);
        }
        return newArrivals;
    }

    public List sortArrivals(ArrayList arrivals) {
        CustomerSorter sorter = new CustomerSorter(arrivals);
        List sortedArrivals = (List) sorter.sortByTypeAndItems();
        return sortedArrivals;
    }

    public Register shortestLine() {
        Iterator it = registers.iterator();
        Register minimumLine = (Register) registers.get(0);

        while(it.hasNext()) {
            Register register = (Register) it.next();
            if (register.lineLength() < minimumLine.lineLength()) minimumLine = register;
        }
        return minimumLine;
    }

    public Register lastCustomerWithLeastItems() {
        Iterator it = registers.iterator();
        Register leastItems = (Register) registers.get(0);

        while(it.hasNext()) {
            Register register = (Register) it.next();
            if (register.lastCustomerItems() < leastItems.lastCustomerItems()) leastItems = register;
        }
        return leastItems;
    }

    public void serviceCustomers() {
        Iterator it   = registers.iterator();

        if (allRegistersEmpty()) return;
        else while (it.hasNext()) {
            Register register = (Register) it.next();
            register.serveCurrentCustomer();
        }
    }

    public boolean allRegistersEmpty() {
        Iterator it   = registers.iterator();
        boolean empty = true;

        while(it.hasNext()) {
            Register register = (Register) it.next();
            if (!register.isEmpty()) empty = false;
        }
        return empty;
    }

}
