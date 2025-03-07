// Define a Node class to represent each element in the queue
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a Queue class to represent the queue implemented as a linked list 
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }
	
	// Enqueue operation: adds an item to the end of the queue, pseudocode found in PA 5.5.1
    public void enqueue(int item) {
        // Allocate new node and assign data
        // newNode.next is automatically set to null in the Node constructor
		Node newNode = new Node(item);
        
        if (front == null) {
            // If the queue is empty, set front to the new node
            front = newNode;
        } else {
            // Otherwise, link the new node at the end of the queue
            rear.next = newNode;
        }
        // Update the rear pointer to the new node
        rear = newNode;
    }
    
    // Dequeue operation: removes and returns the item from the front of the queue, pseudocode found in PA 5.5.1
    public int dequeue() {
		// If queue is empty return -1 (assuming only positive integers will be added) 
        if (front == null) {
            return -1;
        }
        // Save the data from the front node
        int dequeuedItem = front.data;
        // Move the front pointer to the next node
        front = front.next;
        // If the queue becomes empty, update the rear pointer to null
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
        if (front == null) {
			return true;
		} else {
			return false;
		}
    }
    
    // Method to peek at the front item without removing it
    public int peek() {
        if (front != null) {
			return front.data;
		} else {
			return 0;
		}
    }

    // Method to get the length of the queue
    public int getLength() {
		int length = 0;
		Node current = front;
		while (current != null) {
			length++;
			current =current.next;
		}
		return length;
    }	
	
    // Method to traverse and print the list, pseudocode found in PA 4.8.1
    public void displayQueue() {
		Node current = front;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("NULL");
    }
    
}

// Main class to demonstrate the queue operations
public class QueueAsLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
		
		queue.displayQueue(); // display the queue
		
		// call isEmpty() to display if the queue is empty
		if (queue.isEmpty()) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The queue is not empty.");
		}
		
		// call peek()
		if (queue.peek() == 0) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The top item on the queue is: " + queue.peek());
		}
		
		System.out.println("The queue's length is: " + queue.getLength()); // display the queue’s length
		
		// enqueue items 1 and 2
		queue.enqueue(1);
		queue.enqueue(2);
		
		// call peek()
		if (queue.peek() == 0) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The top item on the queue is: " + queue.peek());
		}
		
		queue.enqueue(3); // enqueue item 3
		System.out.println("The queue's length is: " + queue.getLength()); // display the queue’s length
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		
		// call peek()
		if (queue.peek() == 0) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The top item on the queue is: " + queue.peek());
		}
		
		queue.enqueue(4); // enqueue item 4
		queue.displayQueue(); // display the queue
		queue.enqueue(5); // enqueue item 5
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		queue.enqueue(6); // enqueue item 6
		System.out.println("The queue's length is: " + queue.getLength()); // display the queue’s length
		queue.displayQueue(); // display the queue
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		
		// call isEmpty() to display if the queue is empty
		if (queue.isEmpty()) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The queue is not empty.");
		}
		
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		System.out.println("The queue's length is: " + queue.getLength()); // display the queue’s length
		System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // call dequeue() and display the item's value
		
		// if the queue is empty then don't dequeue; else call dequeue() and display the item's value
		// this could be implemented for all dequeue() calls but this one in particular will not dequeue anything
		if (queue.isEmpty()) {
            System.out.println("An item was not dequeued.");
        } else {
            System.out.println("Item " + queue.dequeue() + " was removed from the queue.");
        }
		
		// call isEmpty() to display if the queue is empty
		if (queue.isEmpty()) {
			System.out.println("The queue is empty.");
		} else {
			System.out.println("The queue is not empty.");
		}
		
	}
}
