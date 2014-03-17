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
            printCustomers(store.customers);
            printRegisters(store.registers);
            /*int time = store.main();
            System.out.println(time);
            System.out.println("Example" + 1 + ": " + time + " minutes");*/
        /*}*/
    }

    public void printCustomers(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            Customer customer = list.get(i);
            System.out.println("Type: " + customer.type);
            System.out.println("Items: " + customer.items);
            System.out.println("Arrival Time: " + customer.arrivalTime);
            System.out.println("Served?: " + customer.served);
        }
    }

    public void printRegisters(ArrayList<Register> list) {
        for (int i = 0; i < list.size(); i++) {
            Register register = list.get(i);
            System.out.println("Speed: " + register.getSpeed());
        }
    }

}