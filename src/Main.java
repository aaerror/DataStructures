import fifo.Queue;
import lifo.Stack;
import list.SinglyLinked;

public class Main {
	public static void main(String[] args) {
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


		SinglyLinked list = SinglyLinked.create();
		System.out.println("\n\n" + "-".repeat(50));
		System.out.println("Creating data structure: Singly Linked List");
		System.out.println("Is it empty?: " + list.isEmpty());
		System.out.println("-".repeat(50));

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Inserting data into list...");
		System.out.println("=".repeat(50));
		list.add("a", 1);
		list.add("x", 2);
		list.add("o", 3);
		list.add("k", 4);
		list.add("n", 5);
		list.add("r", 9);
		list.add("e");

		System.out.println("\nIs it empty?: " + list.isEmpty());
		System.out.println("Quantity: " + list.size());
		list.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Deleting data from list...");
		System.out.println("=".repeat(50));
		Object dataRemoved = list.remove(3);
		System.out.println("Data deleted: " + dataRemoved);
		dataRemoved = list.remove();
		System.out.println("Data deleted: " + dataRemoved);
		System.out.println("Quantity: " + list.size());
		list.show();

		System.out.println("\n" + "=".repeat(50));
		System.out.println("Getting data from list...");
		System.out.println("=".repeat(50));
		Object dataSearched = list.get(3);
		System.out.println("Data searched: " + dataSearched);
	}
}
