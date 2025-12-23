package sample.proj;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.annotations.Test;

public class groceryItems {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        // Inventory: Item -> {Stock, Price}
		        Map<String, Map<String, Integer>> inventory = new LinkedHashMap<>();
		        inventory.put("Apple", new HashMap<>(Map.of("Stock", 10, "Price", 3)));
		        inventory.put("Banana", new HashMap<>(Map.of("Stock", 5, "Price", 1)));
		        inventory.put("Orange", new HashMap<>(Map.of("Stock", 10, "Price", 2)));

		        // Customer order input
		        Map<String, Integer> order = new LinkedHashMap<>();

		        System.out.println("Enter quantity for Apple:");
		        order.put("Apple", sc.nextInt());

		        System.out.println("Enter quantity for Banana:");
		        order.put("Banana", sc.nextInt());

		        System.out.println("Enter quantity for Orange:");
		        order.put("Orange", sc.nextInt());

		        int totalBill = 0;

		        // Print bill header
		        System.out.println("--------------------------");
		        System.out.printf("%-12s %-9s %-6s%n", "items", "quantity", "price");

		        for (Map.Entry<String, Integer> entry : order.entrySet()) {
		            String item = entry.getKey();
		            int quantity = entry.getValue();

		            if (inventory.containsKey(item)) {
		                int stock = inventory.get(item).get("Stock");
		                int price = inventory.get(item).get("Price");

		                if (quantity <= stock) {
		                    int cost = quantity * price;
		                    totalBill += cost;
		                    inventory.get(item).put("Stock", stock - quantity);

		                    System.out.printf("%-12s %-9d %-6d%n", item, quantity, cost);
		                } else {
		                    System.out.printf("%-12s %-9d %-6s%n", item, quantity, "NA");
		                    System.out.println("Not enough stock for " + item);
		                }
		            }
		        }

		        System.out.println("--------------------------");
		        System.out.printf("%22s %-6d%n", "Total", totalBill);
		        System.out.println("--------------------------");

		        // Remaining stock output
		        System.out.println("\nRemaining Inventory:");
		        System.out.print("{");
		        int count = 0;
		        for (Map.Entry<String, Map<String, Integer>> entry : inventory.entrySet()) {
		            String item = entry.getKey();
		            int stock = entry.getValue().get("Stock");
		            int price = entry.getValue().get("Price");

		            System.out.print(item + " : { Stock : " + stock + ", price : " + price + "}");
		            count++;
		            if (count < inventory.size()) {
		                System.out.print(", ");
		            }
		        }
		        System.out.println("}");
	}

}
