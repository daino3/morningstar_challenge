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

            /* FOR VISUAL PLAY-BY-PLAY
            System.out.println("==============");
            System.out.println("TIME : " + time);
            printLines();*/

            serviceCustomers();

            time++;

        }
        return time;
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

    public void printLines() {
        int numReg = registers.size();

        for (int i = 0; i < numReg; i++) {
            Register register = (Register) registers.get(i);
            System.out.println("Register " + (i+1) );

            if (!register.isEmpty()) {
                for(int c = 0; c < register.lineLength(); c++) {
                    Customer customer = (Customer) register.customers.get(c);
                    System.out.println("Customer "+ customer.type + " " + " with " + customer.items + " items");
                }
            }else {
                System.out.println("EMPTY");
            }
        }
    }

    public void placeCustomersInLine() {
        ArrayList arrivals = findLineArrivals();

        List sortedArrivals = sortArrivals(arrivals);

        int numArrivals = sortedArrivals.size();

        for (int i = 0; i < numArrivals; i++) {
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
