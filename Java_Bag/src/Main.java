
public class Main {
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
