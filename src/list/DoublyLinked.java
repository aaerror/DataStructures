package list;

import base.DataStructure;
import base.Node;

public class DoublyLinked extends DataStructure {
	private Node last;


	private DoublyLinked() {
		super();
		last = null;
	}

	public static DoublyLinked create() {
		return new DoublyLinked();
	}

	public void add(Object data, int atPosition) {
		if (atPosition < 0 || atPosition > size()) {
			throw new IndexOutOfBoundsException("Position " + atPosition + " out of bounds.");
		}

		if (atPosition == 0) {
			addFirst(data);
		} else if (atPosition == size()) {
			addLast(data);
		} else {
			Node newNode = Node.create(data);

			// TODO: Make new inserts more efficient by atPosition/2.
			Node searched = getFirstNode();
			while (searched.getPosition() != atPosition) {
				searched = searched.getNextNode();
				newNode.moveToNextPosition();
			}
			moveNodeOneStepForward(searched);

			Node previous = searched.getPreviousNode();

			newNode.setPreviousNode(previous);
			newNode.setNextNode(searched);

			previous.setNextNode(newNode);
			searched.setPreviousNode(newNode);
			addNodeQuantity();
		}
	}

	public void addFirst(Object data) {
		Node newNode = Node.create(data);

		if (isEmpty()) {
			last = newNode;
		} else {
			newNode.setNextNode(getFirstNode());
			getFirstNode().setPreviousNode(newNode);
			moveNodeOneStepForward(getFirstNode());
		}

		addNodeQuantity();
		setFirstNode(newNode);
	}

	public void addLast(Object data) {
		Node newNode = Node.create(data);

		if (isEmpty()) {
			addFirst(data);
			return;
		} else {
			for (int i = 0; i<= last.getPosition(); i+=1) {
				newNode.moveToNextPosition();
			}

			last.setNextNode(newNode);
			newNode.setPreviousNode(last);
		}

		addNodeQuantity();
		last = newNode;
	}

	public Object get(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		if (getFirstNode().getPosition() == atPosition) {
			return getFirstNode().getData();
		} else if (last.getPosition() == atPosition) {
			return last.getData();
		} else {
			Node searched = getFirstNode();

			while (searched.getPosition() != atPosition) {
				if (searched.hasNextNode()) {
					searched = searched.getNextNode();
				}
			}

			return searched.getData();
		}
	}

	public Object remove(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		} else if (atPosition == 0) {
			return removeFirst();
		} else if (atPosition == (size() -1)) {
			return removeLast();
		}

		Node toDelete = getFirstNode();
		while (toDelete.getPosition() != atPosition) {
			toDelete = toDelete.getNextNode();
		}

		if (toDelete.hasNextNode()) {
			Node previous = toDelete.getPreviousNode();

			previous.setNextNode(toDelete.getNextNode());
			previous.getNextNode().setPreviousNode(previous);
			moveNodeOneStepBackward(previous.getNextNode());
		}

		substractNodeQuantity();

		return toDelete.getData();
	}

	public Object removeFirst() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node toRemove = getFirstNode();
		if (toRemove.hasNextNode()) {
			Node newFirst = toRemove.getNextNode();

			moveNodeOneStepBackward(newFirst);
			setFirstNode(newFirst);

			toRemove.setNextNode(null);
			newFirst.setPreviousNode(null);
		} else {
			setFirstNode(null);
			last = null;
		}

		substractNodeQuantity();

		return toRemove.getData();
	}

	public Object removeLast() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		Node toRemove = last;
		if (last.hasPreviousNode()) {
			Node newLast = last.getPreviousNode();

			newLast.setNextNode(null);
			last.setPreviousNode(null);
			last = newLast;
		} else {
			setFirstNode(null);
			last = null;
		}

		substractNodeQuantity();

		return toRemove.getData();
	}

}
