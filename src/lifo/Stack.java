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

	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error: Stack it's empty.");
		}

		return getFirstNode().getData();
	}

	public void pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error: Stack it's empty.");
		}

		Node newFirst = getFirstNode().getNextNode();
		getFirstNode().setNextNode(null);

		moveNodeOneStepBackward(newFirst);
		substractNodeQuantity();

		setFirstNode(newFirst);
	}

	public void push(Object newData) {
		Node newNode = Node.create(newData);

		if (isEmpty()) {
			setFirstNode(newNode);
		} else {
			Node oldFirst = getFirstNode();
			newNode.setNextNode(oldFirst);
			moveNodeOneStepForward(oldFirst);
			setFirstNode(newNode);
		}

		addNodeQuantity();
	}
}
