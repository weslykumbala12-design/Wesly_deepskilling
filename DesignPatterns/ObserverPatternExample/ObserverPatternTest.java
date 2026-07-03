public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp("John");

        Observer web = new WebApp("David");

        stockMarket.registerObserver(mobile);

        stockMarket.registerObserver(web);

        stockMarket.setStock("TCS", 3850.50);

        stockMarket.setStock("Infosys", 1525.75);

    }

}