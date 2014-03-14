import java.awt.*;
import java.awt.List;
import java.util.*;

public class Store {
    public ArrayList registers;
    public ArrayList customers;
    public int time;

    public Store(ArrayList registerList, ArrayList customerList) {
        registers = registerList;
        customers = customerList;
        time = 0;
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
        /* Need to sort arrivals here */
        Iterator it = arrivals.iterator();

        while (it.hasNext()) {
            Customer customer = (Customer) it.next();
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

    /*public List sortArrivals(ArrayList arrivals) {
        arrivals
    }*/

    public Register shortestLine() {
        Iterator it = registers.iterator();
        Register minimumLine = (Register) registers.get(0);

        while(it.hasNext()) {
            Register register = (Register) it.next();

            if (register.lineLength() < minimumLine.lineLength()) {
                minimumLine = register;
            }
        }
        return minimumLine;
    }

    public Register lastCustomerWithLeastItems() {
        Iterator it = registers.iterator();
        Register leastItems = (Register) registers.get(0);

        while(it.hasNext()) {
            Register register = (Register) it.next();

            if (register.lastCustomerItems() < leastItems.lastCustomerItems()) {
                leastItems = register;
            }
        }
        return leastItems;
    }

    public void serviceCustomers() {
        Iterator it   = registers.iterator();

        if (allRegistersEmpty()) {
            return;
        }
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

            if (!register.customers.isEmpty()) empty = false;
        }
        return empty;
    }

}
