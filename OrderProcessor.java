public class OrderProcessor {
    private IOrderCalculable calculable;
    private IOrderPlacable placable;
    
    public OrderProcessor(IOrderCalculable calculable, IOrderPlacable placable) {
        this.calculable = calculable;
        this.placable = placable;
    }
    
    public void processOrder(double price, int quantity, String customerName, String address) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        
        calculable.calculateTotal(price, quantity);
        placable.placeOrder(customerName, address);
    }
    
    public void setCalculable(IOrderCalculable calculable) {
        this.calculable = calculable;
    }
    
    public void setPlacable(IOrderPlacable placable) {
        this.placable = placable;
    }
}