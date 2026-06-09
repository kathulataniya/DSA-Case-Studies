import java.util.TreeMap;

public class NSEOrderBook {

    public static void main(String[] args) {

        TreeMap<Integer,String> orderBook = new TreeMap<>();

        orderBook.put(2500,"Buy 50");
        orderBook.put(2510,"Buy 30");
        orderBook.put(2490,"Sell 40");
        orderBook.put(2520,"Buy 20");
        orderBook.put(2485,"Sell 60");

        System.out.println("NSE Order Book");

        for(Integer price : orderBook.keySet()) {
            System.out.println(price + " -> " + orderBook.get(price));
        }
    }
}