public class WebApp implements Observer {

    private final String user;

    public WebApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {

        System.out.println("Web App (" + user + ") received update:");
        System.out.println(stockName + " = Rs." + price);

    }

}