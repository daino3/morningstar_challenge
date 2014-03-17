import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class Parser {
    String filePath;
    File file;
    String text;
    BufferedReader reader;
    ArrayList<String> instructions = new ArrayList();
    ArrayList<Customer> customers = new ArrayList();
    ArrayList<Register> registers = new ArrayList();

    public Parser(String filePath){
        this.filePath = filePath;
    }

    public Store main() {
        parse();
        createRegisters();
        createCustomers();
        Store store = new Store(registers, customers);
        return store;
    }

    public void parse() {
        file = new File(filePath);
        try {
            reader  = new BufferedReader(new FileReader(file));

            while ((text = reader.readLine()) != null ) {
                instructions.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
            }
        }
    }

    public void createRegisters() {
        int numRegisters = Integer.parseInt(instructions.get(0));
        for (int i = 0; i < numRegisters; i++) {
            if (i == numRegisters - 1) {
                Register register = new Register(0.5); /* if last register, make speed of register a training reg */
                registers.add(register);
            } else {
                Register register = new Register(1); /* regular speed for all registers prior to last register */
                registers.add(register);
            }
        }
    }

    public void createCustomers() {
        int numCustomers = instructions.size();
        for (int i = 1; i < numCustomers; i++) {
            String customerData = instructions.get(i);
            String[] splitData = customerData.split("\\s+");

            String type = splitData[0];
            int arrivalTime = Integer.parseInt(splitData[1]);
            double items    = Double.parseDouble(splitData[2]);
            Customer customer = new Customer(type, items, arrivalTime);
            customers.add(customer);
        }
    }

}
