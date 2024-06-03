import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private Queue<Object> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Add the item to the back of the queue (may throw exception)
    public void enqueue(Object item) {
        queue.add(item);
    }

    // Remove and return the element from the front (may throw exception)
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Dequeue from empty queue");
        }
        return queue.remove();
    }

    // Return the element at the front without removing (may throw exception)
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Peek from empty queue");
        }
        return queue.element();
    }

    // Return the number of elements in the queue
    public int size() {
        return queue.size();
    }

    // Override toString() to print the queue contents
    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue after enqueuing 1, 2, 3: " + queue);
        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("\nQueue after dequeue: " + queue);
        System.out.println("\nPeek: " + queue.peek());
        System.out.println("\nSize of queue: " + queue.size());
    }
}
