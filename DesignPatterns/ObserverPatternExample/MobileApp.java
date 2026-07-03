public class MobileApp implements Observer {

    private final String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {

        System.out.println("Mobile App (" + user + ") received update:");
        System.out.println(stockName + " = Rs." + price);

    }

}