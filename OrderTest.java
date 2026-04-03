public class OrderTest {
    public static void main(String[] args) {
        // Test 1: Simple Order without invoice and notification
        System.out.println("=== TEST 1: Simple Order ===");
        SimpleOrder simpleOrder = new SimpleOrder("ORD001", "John Doe", "123 Main St");
        OrderProcessor processor = new OrderProcessor(simpleOrder, simpleOrder);
        processor.processOrder(10.0, 2, "John Doe", "123 Main St");
        
        // Test 2: Complete Order with all features
        System.out.println("\n=== TEST 2: Complete Order ===");
        CompleteOrder completeOrder = new CompleteOrder("ORD002", "Jane Smith", 
                                                        "456 Oak Ave", "jane@example.com");
        OrderProcessor fullProcessor = new OrderProcessor(completeOrder, completeOrder);
        fullProcessor.processOrder(25.0, 3, "Jane Smith", "456 Oak Ave");
        
        // Test 3: Generate Invoice
        System.out.println("\n=== TEST 3: Generate Invoice ===");
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.generateInvoice(completeOrder, "order_002.pdf");
        
        // Test 4: Send Notifications
        System.out.println("\n=== TEST 4: Send Notifications ===");
        NotificationService notificationService = new NotificationService();
        notificationService.sendEmailNotification(completeOrder, "jane@example.com");
        
        // Test 5: SMS Notification (with phone number)
        System.out.println("\n=== TEST 5: SMS Notification ===");
        CompleteOrder completeOrderWithPhone = new CompleteOrder("ORD003", "Bob Wilson", 
                                                                "789 Pine St", 
                                                                "bob@example.com", 
                                                                "+1234567890");
        notificationService.sendSMSNotification(completeOrderWithPhone, "+1234567890");
        
        // Test 6: Both notifications together
        System.out.println("\n=== TEST 6: Both Notifications ===");
        notificationService.sendBothNotifications(completeOrderWithPhone, 
                                                 "bob@example.com", 
                                                 "+1234567890");
        
        // Test 7: Flexible Order Processing - Same method works with different order types
        System.out.println("\n=== TEST 7: Flexible Order Processing ===");
        processAnyOrder(simpleOrder, simpleOrder, 15.0, 1, "John Doe", "123 Main St");
        processAnyOrder(completeOrder, completeOrder, 30.0, 2, "Jane Smith", "456 Oak Ave");
        
        // Test 8: Error handling demonstration
        System.out.println("\n=== TEST 8: Error Handling Demo ===");
        try {
            processor.processOrder(-10.0, 2, "John Doe", "123 Main St");
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
        
        try {
            notificationService.sendEmailNotification(completeOrder, "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
    
    // Flexible method that can process ANY order type (Simple or Complete)
    private static void processAnyOrder(IOrderCalculable calculable, 
                                       IOrderPlacable placable,
                                       double price, int quantity, 
                                       String customerName, String address) {
        OrderProcessor tempProcessor = new OrderProcessor(calculable, placable);
        tempProcessor.processOrder(price, quantity, customerName, address);
    }
}