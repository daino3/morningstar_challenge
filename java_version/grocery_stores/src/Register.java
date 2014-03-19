import java.util.ArrayList;
import java.util.List;

public class Register {
    private double speed;
    public ArrayList customers;

    public Register(double regSpeed) {
      this.speed     = regSpeed;
      this.customers = new ArrayList();
    }

    public double getSpeed() { return speed; }

    public void addCustomer(Customer x) { customers.add(x); }

    public void serveCurrentCustomer() {
      if (customers.isEmpty()) return;

      Customer currentCustomer = (Customer) customers.get(0);
      currentCustomer.ringItem(speed);

      if(currentCustomer.served) customers.remove(0);
    }

    public double lastCustomerItems() {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Customer lastCustomer = (Customer) customers.get(customers.size() - 1);
            return lastCustomer.items;
        }
    }

    public void printCustomers() {
        if (!customers.isEmpty()) {
            for (int i = 0; i < lineLength(); i++) {
                Customer customer = (Customer) customers.get(i);
            }
        }
    }

    public boolean isEmpty() {
        if(customers.isEmpty()) return true;
        return false;
    }

    public int lineLength() {
        return customers.size();
    }

}
