package fifo;

import base.DataStructure;
import base.Node;

public class Queue extends DataStructure {
	private Node last;


	private Queue() {
		super();
		last = null;
	}

	public static Queue create() {
		return new Queue();
	}

	public Object dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error: Queue it's empty.");
		}

		Node newLast = getFirstNode();
		// Looking for the previous node who it's going to be the next to be dequeue.
		while (!newLast.getNextNode().equals(last)) {
			newLast = newLast.getNextNode();
		}

		Object dataDequeue = last.getData();
		newLast.setNextNode(null);
		last = newLast;
		substractNodeQuantity();

		return dataDequeue;
	}

	public void enqueue(Object data) {
		Node newNode = Node.create(data);

		if (isEmpty()) {
			setFirstNode(newNode);
			last = getFirstNode();
		} else {
			newNode.setNextNode(getFirstNode());
			moveNodeOneStepForward(getFirstNode());
			setFirstNode(newNode);
		}

		addNodeQuantity();
	}

	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error: Queue it's empty.");
		}

		return last.getData();
	}
}