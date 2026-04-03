public interface INotificationSendable {
    void sendEmailNotification(String email);
    void sendSMSNotification(String phoneNumber);
}