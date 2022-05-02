public class Main {

    public static void main(String[] args) {

        Node<Integer> myNode = new Node<Integer>(4);
        Node<Integer> myNode1 = new Node<Integer>(10);
        Node<Integer> myNode2 = new Node<Integer>(8);
        Node<String> myNode3 = new Node<String>("I'm a String");

        if (!myNode.hasLeft()) {
            myNode.setLeft(myNode1);
        }

        //4 , 10,8, "I'm a string"
        // 10<-4

        /* Bag<Integer> numberBag = new Bag<Integer>();
        System.out.println(numberBag);
        System.out.println("\nAdding the numbers 1, 1, 1, 6, 2, 7, 8, 4, 4, 2, and 9 to the Bag now.\n");

        numberBag.add(1);
        numberBag.add(1);
        numberBag.add(1);
        numberBag.add(6);
        numberBag.add(2);
        numberBag.add(7);
        numberBag.add(8);
        numberBag.add(4);
        numberBag.add(4);
        numberBag.add(2);
        numberBag.add(9);

        System.out.println("All numbers have been added to Bag!\n");
        System.out.print("The bag now contains the numbers: ");
        Bag.printInorder(numberBag);
        System.out.println("\n\nThe counts for each are (#: QTY): " + numberBag);
        
        System.out.println("\nNow for some tests...\n");

        boolean numCheck = numberBag.contains(10);
        System.out.println("Does the Bag contain the number 3?\n" + numCheck + "\n");
        numCheck=numberBag.contains(8);
        System.out.println("Does the Bag contain the number 8?\n" + numCheck + "\n");

        int bagSize = numberBag.size();
        System.out.println("How many numbers are in the Bag?\n" + bagSize + "\n");

        int distictNumbers = numberBag.distictNumbers();
        System.out.println("How many distinct numbers are in the Bag?\n" + distictNumbers + "\n");

        System.out.println("Attempting to remove the numbers 10, 4, 1, and 9 from the Bag.\n");
        
        numberBag.remove(10);
        numberBag.remove(4);
        numberBag.remove(1);
        numberBag.remove(9);

        System.out.print("\nHere are the updated counts (#: QTY):");
        System.out.println(numberBag + "\n");

        boolean is_Empty = numberBag.isEmpty();
        System.out.println("Is the Bag empty?\n" + is_Empty + "\n");

        System.out.println("Clearing the Bag.\n");

        numberBag.clear();
        is_Empty = numberBag.isEmpty();

        System.out.println("Is the Bag empty?\n" + is_Empty + "\n"); */
    }
}
