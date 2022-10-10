import fifo.Queue;
import lifo.Stack;
import list.DoublyLinked;
import list.SinglyLinked;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		/**
		 * DATA STRUCTURE: STACK
		 */
		Stack stack = Stack.create();
		System.out.println("\n" + "-".repeat(50));
		System.out.println("Creating data structure: LIFO");
		System.out.println("Is it empty?: " + stack.isEmpty());
		System.out.println("-".repeat(50));

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Putting data into LIFO structure...");
		System.out.println("=".repeat(50));
		stack.push("a");
		stack.push("x");
		stack.push("o");
		stack.push("k");
		stack.push("n");
		System.out.println("Is it empty?: " + stack.isEmpty());
		System.out.println("Quantity: " + stack.size());
		stack.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Taking data from LIFO structure...");
		System.out.println("=".repeat(50));
		stack.pop();
		stack.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Peeking data from LIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Peek: " + stack.peek());


		/**
		 * DATA STRUCTURE: QUEUE
		 */
		Queue queue = Queue.create();
		System.out.println("\n\n" + "-".repeat(50));
		System.out.println("Creating data structure: FIFO");
		System.out.println("Is it empty?: " +  queue.isEmpty());
		System.out.println("-".repeat(50));

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Enqueue data into FIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Is it empty?: " +  queue.isEmpty());
		queue.enqueue("a");
		queue.enqueue("x");
		queue.enqueue("o");
		queue.enqueue("k");
		queue.enqueue("n");
		System.out.println("Quantity: " + queue.size());
		queue.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Dequeueing data from FIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Data dequeue: " + queue.dequeue());
		queue.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Peeking data from FIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Peek: " + queue.peek());


		/**
		 * DATA STRUCTURE: SINGLY LINKED LIST
		 */
		SinglyLinked singlyLinked = SinglyLinked.create();
		System.out.println("\n\n" + "-".repeat(50));
		System.out.println("Creating data structure: Singly Linked List");
		System.out.println("Is it empty?: " + singlyLinked.isEmpty());
		System.out.println("-".repeat(50));

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Inserting data into singly linked list...");
		System.out.println("=".repeat(50));
		singlyLinked.add("a");
		singlyLinked.add("x");
		singlyLinked.add("o");
		singlyLinked.add("s", 2);
		singlyLinked.add("k");
		singlyLinked.add("n");
		singlyLinked.add("y", 0);
		singlyLinked.add("r", singlyLinked.size());
		System.out.println("Is it empty?: " + singlyLinked.isEmpty());
		System.out.println("Quantity: " + singlyLinked.size());
		singlyLinked.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Deleting data from singly linked list...");
		System.out.println("=".repeat(50));
		Object dataRemoved = singlyLinked.remove(5);
		System.out.println("Data deleted: " + dataRemoved);
		dataRemoved = singlyLinked.remove(0);
		System.out.println("Data deleted: " + dataRemoved);
		dataRemoved = singlyLinked.remove(singlyLinked.size()-1);
		System.out.println("Data deleted: " + dataRemoved);
		System.out.println("Quantity: " + singlyLinked.size());
		singlyLinked.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Getting data from singly linked list...");
		System.out.println("=".repeat(50));
		//Object dataSearched = singlyLinked.get(singlyLinked.size());
		Object dataSearched = singlyLinked.get(0);
		System.out.println("Data searched: " + dataSearched);
		dataSearched = singlyLinked.get(4);
		System.out.println("Data searched: " + dataSearched);


		/**
		 * DATA STRUCTURE: DOUBLE LINKED LIST
		 */
		DoublyLinked doublyLinked = DoublyLinked.create();
		System.out.println("\n\n" + "-".repeat(50));
		System.out.println("Creating data structure: Doubly Linked List");
		System.out.println("Is it empty?: " + doublyLinked.isEmpty());
		System.out.println("-".repeat(50));

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Inserting data into doubly linked list...");
		System.out.println("=".repeat(50));
		doublyLinked.addLast("e");
		doublyLinked.addFirst("H");
		doublyLinked.addLast("l");
		doublyLinked.add("a", 2);
		doublyLinked.addLast("l");
		doublyLinked.add("o", 5);
		doublyLinked.add("i", doublyLinked.size()-1);
		doublyLinked.add("!", doublyLinked.size());
		doublyLinked.show();
		Object head = doublyLinked.get(0);
		System.out.println("HEAD: " + head);
		Object tail = doublyLinked.get(doublyLinked.size()-1);
		System.out.println("TAIL: " + tail);
		System.out.println("Is it empty?: " + doublyLinked.isEmpty());
		System.out.println("Quantity: " + doublyLinked.size());

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Deleting data from doubly linked list...");
		System.out.println("=".repeat(50));
		dataRemoved = doublyLinked.remove(2);
		System.out.println("Data deleted: " + dataRemoved);
		dataRemoved = doublyLinked.remove(4);
		System.out.println("Data deleted: " + dataRemoved);
		System.out.println("Is it empty?: " + doublyLinked.isEmpty());
		System.out.println("Quantity: " + doublyLinked.size());
		doublyLinked.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Getting data from doubly linked list...");
		System.out.println("=".repeat(50));
		dataSearched = doublyLinked.get(0);
		System.out.println("Data searched: " + dataSearched);
		dataSearched = doublyLinked.get(1);
		System.out.println("Data searched: " + dataSearched);
		dataSearched = doublyLinked.get(4);
		System.out.println("Data searched: " + dataSearched);
	}
}
