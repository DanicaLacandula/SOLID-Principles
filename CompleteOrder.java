public class CompleteOrder implements IOrderCalculable, IOrderPlacable, 
                                     IInvoiceGenerable, INotificationSendable {
    private String orderId;
    private String customerName;
    private String address;
    private String email;
    private String phoneNumber;
    
    public CompleteOrder(String orderId, String customerName, String address, String email) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
    }
    
    public CompleteOrder(String orderId, String customerName, String address, 
                         String email, String phoneNumber) {
        this(orderId, customerName, address, email);
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void calculateTotal(double price, int quantity) {
        double total = price * quantity;
        double tax = total * 0.1; // 10% tax
        double grandTotal = total + tax;
        System.out.println("Complete order total: $" + total);
        System.out.println("Tax (10%): $" + tax);
        System.out.println("Grand total: $" + grandTotal);
    }
    
    @Override
    public void placeOrder(String customerName, String address) {
        System.out.println("Complete order placed for " + customerName + " at " + address);
        System.out.println("Order ID: " + orderId);
    }
    
    @Override
    public void generateInvoice(String fileName) {
        System.out.println("Invoice generated for order " + orderId + ": " + fileName);
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + address);
    }
    
    @Override
    public void sendEmailNotification(String email) {
        System.out.println("Email notification sent to: " + email);
        System.out.println("Subject: Order Confirmation - " + orderId);
    }
    
    @Override
    public void sendSMSNotification(String phoneNumber) {
        System.out.println("SMS notification sent to: " + phoneNumber);
        System.out.println("Message: Your order " + orderId + " has been confirmed");
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}