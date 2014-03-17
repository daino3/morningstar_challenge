
public class Customer implements Comparable<Customer>{
    public String type;
    public double items;
    public int arrivalTime;
    public boolean served;

    public Customer(String customerType, double numItems, int timeArrived) {
      type   = customerType;
      items  = numItems;
      arrivalTime = timeArrived;
      served = false;
    }

    public void ringItem(double speed) {
      items -= speed;
      if (items <= 0) {
        served = true;
      }
    }

    public void getInLine(Store store) {
        Register register;

        int customerType = 0;

        if (type == "A") customerType = 1;
        if (type == "B") customerType = 2;

        switch (customerType) {
            case 1:
                register = (Register) store.shortestLine();
                register.addCustomer(this);
                break;
            case 2:
                register = (Register) store.lastCustomerWithLeastItems();
                register.addCustomer(this);
                break;
        }
    }

    @Override
    public int compareTo(Customer customer) {
        int value = type.compareTo(customer.type);
        return (value == 0) ? Double.compare(items, customer.items) : value;
    }
}
