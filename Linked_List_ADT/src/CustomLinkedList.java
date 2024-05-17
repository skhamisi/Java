import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {

  // Head of the linked list, initially null
  private Node head;

  /**
   * Inserts a new node containing the given data at the end of the linked list.
   *
   * @param data The data to be inserted into the new node.
   */
  public void insert(int data) {
    // Create a new node to hold the data
    Node newNode = new Node(data);

    // If the list is empty, set the new node as the head
    if (head == null) {
      head = newNode;
    } else {
      // Traverse the list to find the last node
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      // Set the last node's next pointer to the new node
      current.next = newNode;
    }
  }

  /**
   * Deletes the first occurrence of a node containing the given data from the linked list.
   *
   * @param data The data to be deleted.
   */
  public void delete(int data) {
    // If the list is empty, do nothing
    if (head == null) {
      return;
    }

    // Check if the head node needs to be deleted
    if (head.data == data) {
      head = head.next;
      return;
    }

    // Traverse the list to find the node to be deleted and the node before it
    Node current = head;
    while (current.next != null) {
      if (current.next.data == data) {
        // Skip over the node to be deleted by linking the previous node to the next one
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  /**
   * Returns an iterator object that can be used to iterate through the linked list.
   *
   * @return An iterator object for the linked list.
   */
  public Iterator<Integer> iterator() {
    return new LinkedListIterator();
  }

  // Node class to represent a single node in the linked list
  private class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Private iterator class to implement the Iterator interface for custom iteration
  private class LinkedListIterator implements Iterator<Integer> {
    private Node current = head;

    @Override
    public boolean hasNext() {
      // Check if the current node is not null (i.e., not at the end)
      return current != null;
    }

    @Override
    public Integer next() {
      // Throw an exception if there are no more elements
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      // Get the data from the current node and move to the next node
      int data = current.data;
      current = current.next;
      return data;
    }
  }

  public static void main(String[] args) {
    CustomLinkedList linkedList = new CustomLinkedList();

    // Insert some elements
    linkedList.insert(1);
    linkedList.insert(2);
    linkedList.insert(3);

    // Iterate and display elements using the custom iterator
    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();

    // Delete an element and iterate again
    linkedList.delete(2);
    iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
  }
}
