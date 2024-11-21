import java.util.*;

public class Ex3 {
    static TreeMap<Product, Integer> treeMap = new TreeMap<>(Comparator.comparingDouble(o -> o.getPrice()));

    public static void main(String[] args) {
        Product bed = new Product("Кровать", 35000);
        Product door = new Product("Дверь", 18600);
        Product tv = new Product("Телевизор", 44999);
        Product pen = new Product("Ручка шариковая", 69.99);
        Product milk = new Product("Молоко 3.2%", 89.99);
        sell(bed);
        sell(tv);
        sell(milk);
        sell(pen);
        sell(bed);
        sell(door);
        sell(milk);
        sell(milk);
        sell(pen);
        sell(bed);
        sell(milk);
        showListOfSold(false);
        totalSales();
        mostPopularProduct();
    }

    public static void sell(Product p) {
        if (treeMap.containsKey(p)) treeMap.replace(p, treeMap.get(p) + 1);
        else treeMap.put(p, 1);
    }

    public static void showListOfSold(boolean isAsc) {
        List<Map.Entry<Product, Integer>> list = new ArrayList<>(treeMap.entrySet());
        if (!isAsc) Collections.reverse(list);
        for (Map.Entry<Product,Integer> entry : list) {
            System.out.println("Товар \"" + entry.getKey().getName() + "\" с ценой " + entry.getKey().getPrice() + " у.е. был продан " + entry.getValue() + " раз(а)");
        }
    }

    public static void totalSales() {
        List<Map.Entry<Product, Integer>> list = new ArrayList<>(treeMap.entrySet());
        double total = 0;
        for (Map.Entry<Product,Integer> entry : list) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        System.out.println("Общая сумма продаж: " + total + " у.е.");
    }

    public static void mostPopularProduct() {
        List<Map.Entry<Product, Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Product, Integer>>() {
            @Override
            public int compare(Map.Entry<Product, Integer> o1, Map.Entry<Product, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("Наиболее популярный товар: \"" + list.getFirst().getKey().getName() + "\" (" + list.getFirst().getValue() + ")");
    }
}
