package fifo;

import base.DataStructure;
import base.Node;

public class Queue extends DataStructure {
	private Node frontNode;


	private Queue() {
		super();
		frontNode = null;
	}

	public static Queue create() {
		return new Queue();
	}

	public Object dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error: Queue it's empty.");
		}

		Node searchNewFront = getRootNode();
		while (!searchNewFront.getNextNode().equals(frontNode)) {
			searchNewFront = searchNewFront.getNextNode();
		}

		Object dataDequeue = frontNode.getNodeData();
		searchNewFront.setNextNode(null);
		frontNode = searchNewFront;
		substractNodeQuantity();

		return dataDequeue;
	}

	public void enqueue(Object data) {
		Node newNode = Node.create(data);
		addNodeQuantity();

		if (!hasRootNode()) {
			setRootNode(newNode);
			frontNode = getRootNode();
		} else {
			Node rootNode = getRootNode();
			newNode.setNextNode(rootNode);
			moveNodeOneStepForward(rootNode);
			setRootNode(newNode);
		}
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public Object peek() {
		return frontNode.getNodeData();
	}

	public void show() {
		info();
	}

	public int size() {
		return nodeQuantities;
	}
}