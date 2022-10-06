import LIFO.LIFO;

public class Main {
	public static void main(String[] args) throws Exception {
		LIFO newLifo = LIFO.createLIFO();

		System.out.println("Creating data structure: LIFO");
		System.out.println("It's empty: " + newLifo.isEmpty());
		System.out.println("=".repeat(50));
		System.out.println("Putting data into LIFO structure...");
		newLifo.push("a");
		newLifo.push("x");
		newLifo.push("o");
		newLifo.push("k");
		newLifo.push("n");
		System.out.println("Quantity: " + newLifo.count());
		System.out.println("It's empty: " + newLifo.isEmpty());
		System.out.println("\nList LIFO:");
		newLifo.showData();

		System.out.println("\nTaking data from LIFO structure...");
		System.out.println("=".repeat(50));
		newLifo.pop();
		System.out.println("List LIFO:");
		newLifo.showData();


		System.out.println("\nPeeking data from LIFO structure...");
		System.out.println("Peek: " + newLifo.peek());

		/*
		FIFO newFIFO = FIFO.createFIFO();
		System.out.println("\n\nCreating data structure: FIFO");
		System.out.println("It's empty: " + newFIFO.isEmpty());
		System.out.println("=".repeat(50));
		System.out.println("Enqueue data into FIFO structure...");
		newFIFO.enqueue("a");
		newFIFO.enqueue("x");
		newFIFO.enqueue("o");
		newFIFO.enqueue("k");
		newFIFO.enqueue("n");
		System.out.println("Quantity: " + newFIFO.count());
		System.out.println("It's empty: " + newFIFO.isEmpty());
		System.out.println("\nList FIFO:");
		newFIFO.showData();

		System.out.println("\nTaking data from FIFO structure...");
		System.out.println("Data dequeue: " + newFIFO.dequeue());
		System.out.println("=".repeat(50));
		newFIFO.enqueue("Rat");
		System.out.println("Enqueue data into FIFO structure...");
		System.out.println("Quantity: " + newFIFO.count());

		System.out.println("\nList FIFO:");
		newFIFO.showData();

		System.out.println("Peek: " + newFIFO.peek());
		*/
	}
}
