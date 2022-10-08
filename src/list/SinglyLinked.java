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
		if (atPosition < 1 || atPosition > size() + 1) {
			String info = String.format("Invalid position to insert data. List size: %s", size()) +
					String.format("\n\tPosition: %s - Data: %s", atPosition, data);
			System.out.println(info);
			return;
		}

		if (atPosition == 1) {
			add(data);
		} else {
			Node newNode = Node.create(data);
			Node searched = getRootNode();

			/**
			 * Looking for node in position - 1
			 */
			while (searched.getNodePosition() != (atPosition - 1)) {
				/**
				 * Move the newNode position at position - 1
				 */
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

	public Object remove() {
		if (size() == 0) {
			System.out.println("Underflow error. The list is empty.");
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
		if (atPosition < 1 || atPosition > size()) {
			String info = String.format("Invalid position to delete data. List size: %s", size()) +
					String.format("\n\tPosition: %s", atPosition);
			System.out.println(info);
			return null;
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

	public Object get(int atPosition) {
		if (isEmpty()) {
			System.out.println("Underflow error. The list is empty.");
		}

		if (atPosition < 1 || atPosition > size()) {
			System.out.println("Invalid position to get data. List size: %s\", size()");
			return null;
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

	public int size() {
		return nodeQuantities;
	}

	public void show() {
		info();
	}
}
