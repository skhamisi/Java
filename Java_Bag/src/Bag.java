import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
    private final Map<T, Integer> itemsCount;

    public Bag() {
        itemsCount = new HashMap<>();
    }

    // Add an item to the bag
    public void add(T item) {
        itemsCount.put(item, itemsCount.getOrDefault(item, 0) + 1);
    }

    // Remove an item if it exists
    public void remove(T item) {
        int count = itemsCount.getOrDefault(item, 0);
        if (count > 0) {
            itemsCount.put(item, count - 1);
        }
    }

    // Check if the item exists in the bag
    public boolean contains(T item) {
        return itemsCount.containsKey(item) && itemsCount.get(item) > 0;
    }

    // Count of a specific item in the bag
    public int count(T item) {
        return itemsCount.getOrDefault(item, 0);
    }

    // Print bag contents
    public void printContents() {
        for (Map.Entry<T, Integer> entry : itemsCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Calculate total number of elements in the bag
    public int size() {
        int totalSize = 0;
        for (int count : itemsCount.values()) {
            totalSize += count;
        }
        return totalSize;
    }

    // Merge elements from another bag
    public void merge(Bag<T> otherBag) {
        for (Map.Entry<T, Integer> entry : otherBag.itemsCount.entrySet()) {
            T item = entry.getKey();
            int count = entry.getValue();
            itemsCount.put(item, itemsCount.getOrDefault(item, 0) + count);
        }
    }

    // Create a new bag containing only distinct elements from this bag
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (Map.Entry<T, Integer> entry : itemsCount.entrySet()) {
            T item = entry.getKey();
            distinctBag.add(item);
        }
        return distinctBag;
    }
}