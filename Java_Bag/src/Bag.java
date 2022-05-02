/* import org.w3c.dom.Node;

public class Bag<E extends Comparable<E>> {

    private Node<E> root;

    public Bag()
    {
        root = null;
    }

    public Bag(Node newNode)
    {
        root = newNode;
    }

    public  void add(E data)
    {
        if (isEmpty())
        {
            Node<E> newNode = new Node<E>(data);
            root = newNode;
        }

        else
        {
            Node<E> current = root;
            while (true)
            {
                if (data.compareTo(current.getData()) < 0 )
                {
                    if (current.getLeft() != null)
                    {
                        current=current.getLeft();
                    }
                    else
                    {
                        Node<E> newNode = new Node<E>(data);
                        current.setLeft(newNode);
                        break;
                    }
                }
                else if(data.compareTo(current.getData()) > 0)
                {
                    if (current.getRight() != null)
                    {
                        current=current.getRight();
                    }
                    else
                    {
                        Node<E> newNode = new Node<E>(data);
                        current.setRight(newNode);
                        break;
                    }
                }
                else if(data.compareTo(current.getData()) == 0)
                {
                    current.incrementCount();
                    break;
                }
            }
        }
    }

    public boolean remove(E data) {
        if (!contains(data)) {
            System.out.println("Unable to remove the number " + data + " from the Bag.");
            System.out.println("The number " + data + " was not found in the Bag.");
            return false;
        }
        else {
            Node<E> temp = remove(root, data);
            if (contains(temp.getData())) {
                return true;
            } else
                return false;
        }
    }

    private Node<E> remove(Node<E> root,E data) {
        Node<E> current = root;
            if (current == null) {
                return current;
            }
            if (data.compareTo(current.getData()) < 0) {
                 current.setLeft(remove(current.getLeft(), data));
            }
            else if (data.compareTo(current.getData()) > 0) {
                current.setRight( remove(current.getRight(), data));
            }
            else {
                if (current.getCount() > 1) {
                    current.decreaseCount();
                    return current;
                }
                else {
                    if (current.getLeft() != null && current.getRight() != null ) {
                        Node<E> MinFromRightSubTree=findMinFromRight(current.getRight());
                        current.setData(MinFromRightSubTree.getData());
                        remove(current.getRight(),MinFromRightSubTree.getData());
                    }
                    else if (current.getLeft() != null ) {
                        current=current.getLeft();
                    }
                      else if (current.getRight() != null ) {
                           current=current.getRight();
                     }
                     else
                    {
                        current = null;
                    }
                }
            }
            return current;
    }

    private Node<E> findMinFromRight(Node<E> node) {
        while(node.getLeft() != null)
        {
            node=node.getLeft();
        }
        return node;
    }


    public boolean contains(E data)
    {
        Node<E> current = root;
        boolean found = true;
        while (found) 
        {
            if (data.compareTo(current.getData()) < 0) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                }
                else break;
            }

            if (data.compareTo(current.getData()) > 0) 
            {
                if (current.getRight() != null) 
                {
                    current = current.getRight();
                }
                else break;
            }
            if (data.compareTo(current.getData()) == 0) 
            {
               found = false;
            }
        }
        return !found;
    }

    public boolean isEmpty()
    {
        if (root == null)
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    public void clear()
    {
        root = null;
    }

    public int distictNumbers() {
        return (distictNumbers(root));
    }

    private int distictNumbers(Node<E> node)
    {
        if (node == null) {
            return(0);
        }
        else {
            return (distictNumbers(node.getLeft()) + 1 + distictNumbers(node.getRight()));
        }
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node<E> node) {
        int size = 0;
        if (node == null) {
            return(0);
        }
        else {
        return node.getCount() + size(node.getLeft()) + size(node.getRight());
        }
    }


    public static void printInorder(Bag bag)
    {
        if (bag.root == null)
            return;
        else{
            if(bag.root.hasLeft())
                printInorder(new Bag(bag.root.getLeft()));

                System.out.print("\n[" + bag.root.getData() + "] ");

            if(bag.root.hasRight())
                printInorder(new Bag(bag.root.getRight()));
        }
        
    }

    public String toString()
    {
       return toString(root);
    }

    private String toString(Node<E> root) {
        if(isEmpty())
        {
            return "The Bag is currently empty";
        }
       else 
       {
            Node<E> current = root;
            String result = "";
            if (current == null) {
                return "";
            }
            result += toString(current.getLeft());
            result += "\n[" + current.getData().toString() + ": " + current.getCount() + "]";
            result += toString(current.getRight());

            return result;
        }   
    }
}
 */