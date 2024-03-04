package service;

public class NotificationService {
    /**
     * 1. getMessage() : reads data from the Scanner
     * has a dependency on the object of type IMessageProvider
     * Dependency Injection : constructor / setter
     */
    IMeesageProvider messageProvider;

    public NotificationService() {
    }

    public NotificationService(IMeesageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void setMessageProvider(IMeesageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void sendMessage()
    {
//        messageProvider = new ScannerMessageProvider();
        String message = messageProvider.getMessage();
        System.out.println(message);
    }
}
