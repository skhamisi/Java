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

    /* 
     * The current implementation of size() iterates through all values in itemsCount and adds them up. 
     * This can be inefficient for large bags. 
     * HashMap keeps track of its size internally, we can then use stream() to calculate the number of elements in the map
    */

    // Calculate total number of elements in the bag
    // public int size() {
    //     int totalSize = 0;
    //     for (int count : itemsCount.values()) {
    //         totalSize += count;
    //     }
    //     return totalSize;
    // }

    // Optimized implementation of size() method
    public int size() {
        return itemsCount.values().stream().mapToInt(Integer::intValue).sum();
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

    public static void main(String[] args) {
        Bag<Integer> bag1 = new Bag<>();
        Bag<Integer> bag2 = new Bag<>();

        // Add elements to each bag
        bag1.add(10);
        bag1.add(10);
        bag1.add(5);
        bag1.add(20);

        bag2.add(10);
        bag2.add(15);
        bag2.add(20);
        bag2.add(20);
        bag2.add(46);
        bag2.add(88);
        bag2.add(100);

        // Print the size of each bag
        System.out.println("Size of bag1: " + bag1.size());
        System.out.println("Size of bag2: " + bag2.size());

        // Merge bag1 and bag2
        bag1.merge(bag2);

        // Print merged bag contents
        System.out.println("Merged Bag Contents:");
        bag1.printContents();

        // New bag with only distinct elements
        Bag<Integer> distinctBag = bag1.distinct();

        // Print distinct bag contents
        System.out.println("Distinct Bag Contents:");
        distinctBag.printContents();
    }
}