import java.util.ArrayList;
import java.util.List;

public class Register {
    private double speed;
    public List customers = new ArrayList();

    public Register(double regSpeed) {
      speed = regSpeed;
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

    public boolean isEmpty() {
        if(customers.isEmpty()) return true;
        return false;
    }

    public int lineLength() {
        return customers.size();
    }

}
