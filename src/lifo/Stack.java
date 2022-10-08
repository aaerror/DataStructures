package lifo;

import base.DataStructure;
import base.Node;

public class Stack extends DataStructure {
	private Stack() {
		super();
	}

	public static Stack create() {
		return new Stack();
	}

	public int size() { return nodeQuantities; }

	public boolean isEmpty() {
		return (size() == 0);
	}

	public Object peek() {
		return getRootNode().getNodeData();
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("There isn't data on the stack.");
			return;
		}

		Node newRoot = getRootNode().getNextNode();
		getRootNode().setNextNode(null);

		moveNodeOneStepBackward(newRoot);
		substractNodeQuantity();

		setRootNode(newRoot);
	}

	public void push(Object newData) {
		Node newNode = Node.create(newData);
		addNodeQuantity();
		if (!hasRootNode()) {
			setRootNode(newNode);
		} else {
			Node top = getRootNode();
			newNode.setNextNode(top);
			moveNodeOneStepForward(top);
			setRootNode(newNode);
		}
	}

	public void show() {
		info();
	}
}
