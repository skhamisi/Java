import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

    private Bag<T>.Node first;
    private int size;

    public Bag(){}

    public void add(T item){
    //take current first to variable
        Node oldfirst = first;
        //create new node and first is made point to the new created node.
        first = new Node();
        //Feed the node
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public boolean isEmpty(){
        //return true, if size=0;
    	return size == 0;
    }

    public int size(){
        //return size
    	return size;
    }

    // helper linked list inner class
    private class Node {
        //data item for node
        private T item;
        //next pointer to a node.
        private Node next;
    }

    /*** ListIterator. an implementation class for Iterating through collection.*/
    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext(){ 
        	return current != null;                     
        }

        public void remove(){ 
        	//currently, not being considered for our simplicity.
        	throw new UnsupportedOperationException();  
        }

        public T next() {
            if (!hasNext()) { 
                throw new NoSuchElementException();
            }
            
            T item = current.item;
            current = current.next; 
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
