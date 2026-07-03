public class DecoratorPatternTest {
    public static void main(String[] args) {

        Notifier email = new EmailNotifier();

        System.out.println("Email Notification");
        email.send("Your order has been placed.");

        System.out.println();

        Notifier emailSMS =
                new SMSNotifierDecorator(new EmailNotifier());

        System.out.println("Email + SMS Notification");
        emailSMS.send("Your payment was successful.");

        System.out.println();

        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        System.out.println("Email + SMS + Slack Notification");
        allNotifications.send("Server is running successfully.");

    }
}