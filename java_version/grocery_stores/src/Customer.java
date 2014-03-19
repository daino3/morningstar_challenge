
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
        if (type.equals("A")) {
            Register registerA = (Register) store.shortestLine();
            registerA.addCustomer(this);

        } else if (type.equals("B")) {
            Register registerB = (Register) store.lastCustomerWithLeastItems();
            registerB.addCustomer(this);
        }
    }

    @Override
    public int compareTo(Customer customer) {
        int value = Double.compare(items, customer.items);
        return (value == 0) ? type.compareTo(customer.type) : value;
    }
}
