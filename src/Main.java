import FIFO.FIFO;
import LIFO.LIFO;

public class Main {
	public static void main(String[] args) {
		LIFO newLifo = LIFO.createLIFO();

		System.out.println("Creating data structure: LIFO");
		System.out.println("It's empty: " + newLifo.isEmpty());

		System.out.println("\nPutting data into LIFO structure...");
		System.out.println("=".repeat(50));
		newLifo.push("a");
		newLifo.push("x");
		newLifo.push("o");
		newLifo.push("k");
		newLifo.push("n");
		System.out.println("Quantity: " + newLifo.size());
		System.out.println("It's empty: " + newLifo.isEmpty());
		System.out.println("\nList LIFO:");
		newLifo.show();

		System.out.println("Taking data from LIFO structure...");
		System.out.println("=".repeat(50));
		newLifo.pop();
		System.out.println("List LIFO:");
		newLifo.show();

		System.out.println("Peeking data from LIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Peek: " + newLifo.peek());


		FIFO newFIFO = FIFO.createFIFO();
		System.out.println("\n\nCreating data structure: FIFO");
		System.out.println("It's empty: " + newFIFO.isEmpty());

		System.out.println("\nEnqueue data into FIFO structure...");
		System.out.println("=".repeat(50));
		newFIFO.enqueue("a");
		newFIFO.enqueue("x");
		newFIFO.enqueue("o");
		newFIFO.enqueue("k");
		newFIFO.enqueue("n");
		System.out.println("Quantity: " + newFIFO.size());
		System.out.println("It's empty: " + newFIFO.isEmpty());
		System.out.println("\nList FIFO:");
		newFIFO.show();

		System.out.println("Dequeueing data from FIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Data dequeue: " + newFIFO.dequeue());
		System.out.println("Quantity: " + newFIFO.size());
		System.out.println("\nList FIFO:");
		newFIFO.show();

		System.out.println("Peeking data from FIFO structure...");
		System.out.println("=".repeat(50));
		System.out.println("Peek: " + newFIFO.peek());
	}
}
