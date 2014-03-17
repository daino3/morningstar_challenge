import java.util.ArrayList;

public class Runner {
    String[] examples = {"/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_one.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_two.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_thre.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_four.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_five.txt"};

    public void main() {
        /*for(int i = 0; i < examples.length; i++) {*/
            Parser parser = new Parser(examples[0]);
            Store store = parser.main();

            store.time = 1;

            System.out.println(store.time);
            store.placeCustomersInLine();

            Register loneRegister = (Register) store.registers.get(0);

            System.out.println(loneRegister.customers);

            store.serviceCustomers();

            printRegisterCustomers(store);
            /*int time = store.main();
            System.out.println(time);
            System.out.println("Example" + 1 + ": " + time + " minutes");*/
        /*}*/
    }

    public void printRegisterCustomers(Store store) {
        for (int i = 0; i < store.registers.size(); i++) {
            Register register = (Register) store.registers.get(i);
            for (int c = 0; c < register.customers.size(); c++) {
                Customer customer = (Customer) register.customers.get(c);
                printCustomer(customer);
            }
        }
    }

    public void printCustomer(Customer customer) {
        System.out.println("Type: " + customer.type);
        System.out.println("Items: " + customer.items);
        System.out.println("Arrival Time: " + customer.arrivalTime);
        System.out.println("Served?: " + customer.served);

    }

}