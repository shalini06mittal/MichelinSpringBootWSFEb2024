import service.*;

public class Main {
    public static void main(String[] args) {
//        StringMessageProvider messageProvider = new StringMessageProvider();
//        messageProvider.setMessage("From string");
//        // interface ref can be passed object of any class that implements interface
//        IMeesageProvider provider = messageProvider;
//        provider = new FileMessageProvider();
        /**
         * SPRING FRAMEWORK
         *          IOC -> inversion of control : concept
         *         // stock
         *         // DI : approach
         *         // DI : constructor/ setter/ field
         *         // AOP : Aspect Oriented programming : filter or middlewares
         *         // abstraction : JDBC , JPA, ORM, kafka
         *         enforce developers to follow a structure
         *         best practices
         *         design patterns
         *         BL
         */

        NotificationService notificationService = null;// give me ns object
        //new NotificationService();
        //notificationService.setMessageProvider(provider);
        notificationService.sendMessage();
        /**
         * AOP :
         * login page : creadentials [ Banking ]
         * click on login button
         * AOP : generate logs => ip, date, time, credenitals, s/f
         * s/f -> rea backend > validates from db
         *
         *
         *
         */
    }
}