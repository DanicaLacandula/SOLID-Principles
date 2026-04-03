public class InvoiceService {
    
    public void generateInvoice(IInvoiceGenerable invoiceGenerable, String fileName) {
        if (invoiceGenerable == null) {
            throw new IllegalArgumentException("Invoice generable cannot be null");
        }
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }
        
        System.out.println("\n--- Generating Invoice ---");
        invoiceGenerable.generateInvoice(fileName);
        System.out.println("--- Invoice Generated Successfully ---\n");
    }
    
    public void generateInvoiceWithDetails(IInvoiceGenerable invoiceGenerable, 
                                          String fileName, String format) {
        generateInvoice(invoiceGenerable, fileName);
        System.out.println("Invoice Format: " + format);
    }
}