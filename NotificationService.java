public class NotificationService {
    
    public void sendEmailNotification(INotificationSendable notifiable, String email) {
        if (notifiable == null) {
            throw new IllegalArgumentException("Notifiable cannot be null");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        
        System.out.println("\n--- Sending Notification ---");
        notifiable.sendEmailNotification(email);
        System.out.println("--- Notification Sent ---\n");
    }
    
    public void sendSMSNotification(INotificationSendable notifiable, String phoneNumber) {
        if (notifiable == null) {
            throw new IllegalArgumentException("Notifiable cannot be null");
        }
        if (phoneNumber == null || phoneNumber.length() < 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        System.out.println("\n--- Sending SMS ---");
        notifiable.sendSMSNotification(phoneNumber);
        System.out.println("--- SMS Sent ---\n");
    }
    
    public void sendBothNotifications(INotificationSendable notifiable, 
                                     String email, String phoneNumber) {
        sendEmailNotification(notifiable, email);
        sendSMSNotification(notifiable, phoneNumber);
    }
}