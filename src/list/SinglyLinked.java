package list;

import base.DataStructure;
import base.Node;

public class SinglyLinked extends DataStructure {
	private SinglyLinked() {
		super();
	}


	public static SinglyLinked create() {
		return new SinglyLinked();
	}

	private void checkRange(int position) {
		if (position < 1 || position > size()) {
			throw new IndexOutOfBoundsException("Position " + position + "out of bounds.");
		}
	}

	public void add(Object data) {
		Node newNode = Node.create(data);

		if (!isEmpty()) {
			newNode.setNextNode(getRootNode());
			moveNodeOneStepForward(getRootNode());
		}

		addNodeQuantity();
		setRootNode(newNode);
	}

	public void add(Object data, int atPosition) {
		checkRange(atPosition);

		if (atPosition == 1) {
			add(data);
		} else {
			Node newNode = Node.create(data);
			Node searched = getRootNode();

			while (searched.getNodePosition() != (atPosition - 1)) {
				newNode.moveToNextPosition();
				searched = searched.getNextNode();
			}

			newNode.moveToNextPosition();
			if (searched.hasNextNode()) {
				newNode.setNextNode(searched.getNextNode());
				moveNodeOneStepForward(searched.getNextNode());
			}

			addNodeQuantity();
			searched.setNextNode(newNode);
		}
	}

	public Object get(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node searched = getRootNode();
		while (atPosition != searched.getNodePosition()) {
			if (searched.hasNextNode()) {
				searched = searched.getNextNode();
			}
		}

		return searched.getNodeData();
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public Object remove() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node toRemove = getRootNode();
		if (toRemove.hasNextNode()) {
			moveNodeOneStepBackward(getRootNode().getNextNode());
			setRootNode(getRootNode().getNextNode());
		}

		toRemove.setNextNode(null);
		substractNodeQuantity();

		return toRemove.getNodeData();
	}

	public Object remove(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		if (atPosition == 1) {
			return remove();
		}

		Node previous = getRootNode();
		while (previous.getNodePosition() != (atPosition - 1)) {
			previous = previous.getNextNode();
		}

		Node toRemove = previous.getNextNode();
		if (toRemove.hasNextNode()) {
			previous.setNextNode(toRemove.getNextNode());
			moveNodeOneStepBackward(toRemove.getNextNode());
		}

		toRemove.setNextNode(null);
		substractNodeQuantity();

		return toRemove.getNodeData();
	}

	public void show() {
		info();
	}

	public int size() {
		return nodeQuantities;
	}
}
