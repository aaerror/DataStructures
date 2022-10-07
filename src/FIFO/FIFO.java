package FIFO;

import Base.DataStructure;
import Base.Node;

public class FIFO extends DataStructure {
	private Node frontNode;


	private FIFO() {
		super();
		frontNode = null;
	}

	public static FIFO createFIFO() {
		return new FIFO();
	}

	public int size() {
		return nodeQuantities;
	}

	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("There isn't data on the queue.");
			return null;
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
		Node newNode = Node.createNode(data);
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
}