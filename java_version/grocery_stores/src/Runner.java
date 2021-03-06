import java.util.ArrayList;

public class Runner {
    String[] examples = {"/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_one.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_two.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_three.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_four.txt",
                         "/home/dainovu3/Programs/code_challenges/morningstar/java_version/grocery_stores/instructions/example_five.txt"};

    public void main() {
        for(int i = 0; i < examples.length; i++) {
            String fileLocation = examples[i];
            int time = findCompletionTime(fileLocation);

            System.out.println("==========================================");
            System.out.println("Example " + (i+1) + ": " + time + " minutes");
            System.out.println("==========================================");
        }
    }

    public int findCompletionTime(String fileLocation) {
        Store store = createStore(fileLocation);
        int time = store.main();
        return time;
    }

    public Store createStore(String location) {
        Parser parser = new Parser(location);
        Store store = parser.main();
        return store;
    }

}