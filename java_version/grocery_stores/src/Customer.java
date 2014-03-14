public class Customer {
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
}
