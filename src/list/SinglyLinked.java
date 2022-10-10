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
			newNode.setNextNode(getFirstNode());
			moveNodeOneStepForward(getFirstNode());
		}

		addNodeQuantity();
		setFirstNode(newNode);
	}

	public void add(Object data, int atPosition) {
		if (atPosition < 0 || atPosition > size()) {
			throw new IndexOutOfBoundsException("Position " + atPosition + " out of bounds.");
		}

		if (atPosition == 0) {
			add(data);
		} else {
			Node newNode = Node.create(data);

			Node searched = getFirstNode();
			while (searched.getPosition() != (atPosition - 1)) {
				searched = searched.getNextNode();
				newNode.moveToNextPosition();
			}

			if (searched.hasNextNode()) {
				newNode.setNextNode(searched.getNextNode());
				moveNodeOneStepForward(newNode);
			}
			else {
				newNode.moveToNextPosition();
			}

			searched.setNextNode(newNode);
			addNodeQuantity();
		}
	}

	public Object get(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node searched = getFirstNode();
		while (searched.getPosition() != atPosition) {
			if (searched.hasNextNode()) {
				searched = searched.getNextNode();
			}
		}

		return searched.getData();
	}

	public Object remove() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node toRemove = getFirstNode();
		if (toRemove.hasNextNode()) {
			moveNodeOneStepBackward(getFirstNode().getNextNode());
			setFirstNode(getFirstNode().getNextNode());

			toRemove.setNextNode(null);
		} else {
			setFirstNode(null);
		}

		substractNodeQuantity();

		return toRemove.getData();
	}

	public Object remove(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		if (atPosition == 0) {
			return remove();
		}

		int previousPosition = (atPosition != size()) ? atPosition - 1 : atPosition - 2;

		Node previous = getFirstNode();
		while (previous.getPosition() != previousPosition) {
			previous = previous.getNextNode();
		}

		Node toRemove = previous.getNextNode();
		previous.setNextNode(null);

		if (toRemove.hasNextNode()) {
			previous.setNextNode(toRemove.getNextNode());
			moveNodeOneStepBackward(toRemove.getNextNode());
		}

		toRemove.setNextNode(null);
		substractNodeQuantity();

		return toRemove.getData();
	}
}