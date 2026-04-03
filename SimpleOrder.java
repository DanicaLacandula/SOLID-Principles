public class SimpleOrder implements IOrderCalculable, IOrderPlacable {
    private String orderId;
    private String customerName;
    private String address;
    
    public SimpleOrder(String orderId, String customerName, String address) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
    }
    
    @Override
    public void calculateTotal(double price, int quantity) {
        double total = price * quantity;
        System.out.println("Order total: $" + total);
    }
    
    @Override
    public void placeOrder(String customerName, String address) {
        System.out.println("Order placed for " + customerName + " at " + address);
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
}