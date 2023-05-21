package LAB;

import java.util.*;

public class PB06_Product_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        TreeMap<String, LinkedHashMap<String, Double>> shopMap = getShopInfoFromUserInput(scanner);
        for (Map.Entry<String, LinkedHashMap<String, Double> > entry: shopMap.entrySet()) {
            String shop = entry.getKey();
            LinkedHashMap <String, Double> currentShopProductMap = entry.getValue();
            System.out.println(shop+"->");
            for (Map.Entry<String, Double> entryProductInfo : currentShopProductMap.entrySet()) {
                String productName= entryProductInfo.getKey();
                Double price = entryProductInfo.getValue();
                System.out.printf("Product: %s, Price: %.1f%n", productName, price);
            }

        }
    }

    private static TreeMap getShopInfoFromUserInput(Scanner scanner) {
        TreeMap<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();
                String input;
        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] inputArr = input.split(", ");
            String shop = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);

            if (!shopMap.containsKey(shop)) {
               shopMap.put(shop, new LinkedHashMap<>());
               shopMap.get(shop).put(product, price);
            }else if (!shopMap.get(shop).containsValue(product)){
                shopMap.get(shop).put(product, price);
            }
        }
        return shopMap;
    }
}
