
public class Customer implements Comparable<Customer>{
    public String type;
    public double items;
    public int arrivalTime;
    public boolean served;

    public Customer(String type, int arrivalTime, double items) {
      this.type   = type;
      this.items  = items;
      this.arrivalTime = arrivalTime;
      served = false;
    }

    public void ringItem(double speed) {
      items -= speed;
      if (items <= 0) {
        served = true;
      }
    }

    public void getInLine(Store store) {

        System.out.println("Customer " + type + " is getting in line with " + items + " items ");

        int customerType = 0;

        if (type == "A") {
            customerType = 1;
        }else {
            customerType = 2;
        }

        switch (customerType) {
            case 1:
                Register registerA = (Register) store.shortestLine();
                registerA.addCustomer(this);
                System.out.println("GEE THIS LINE LOOKS SWELLL!!");
                registerA.printCustomers();
                break;
            case 2:
                Register registerB = (Register) store.lastCustomerWithLeastItems();
                registerB.addCustomer(this);
                System.out.println("GEE THIS LINE LOOKS GOOOOD TOO!!");
                registerB.printCustomers();
                break;
        }
    }

    @Override
    public int compareTo(Customer customer) {
        int value = type.compareTo(customer.type);
        return (value == 0) ? Double.compare(items, customer.items) : value;
    }
}
