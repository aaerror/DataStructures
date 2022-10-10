package list;

import base.DataStructure;
import base.Node;

public class DoublyLinked extends DataStructure {
	private Node tail;


	private DoublyLinked() {
		super();
		tail = null;
	}

	public static DoublyLinked create() {
		return new DoublyLinked();
	}

	public void add(Object data, int atPosition) {
		checkRange(atPosition);

		if (atPosition == 1) {
			addFirst(data);
		} else if (atPosition == (size() + 1)) {
			addLast(data);
		} else {
			Node newNode = Node.create(data);

			// TODO: Make new inserts more efficient by atPosition/2.
			Node searched = getRootNode();
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
			tail = newNode;
		} else {
			newNode.setNextNode(getRootNode());
			getRootNode().setPreviousNode(newNode);
			moveNodeOneStepForward(getRootNode());
		}

		addNodeQuantity();
		setRootNode(newNode);
	}

	public void addLast(Object data) {
		Node newNode = Node.create(data);

		if (isEmpty()) {
			addFirst(data);
			return;
		} else {
			for (int i=1; i<=(size()); i+=1) {
				newNode.moveToNextPosition();
			}
			tail.setNextNode(newNode);
			newNode.setPreviousNode(tail);
		}

		addNodeQuantity();
		tail = newNode;
	}

	public Object get(int atPosition) {
		checkRange(atPosition);

		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow error. The list it's empty.");
		}

		if (getRootNode().getPosition() == atPosition) {
			return getRootNode();
		} else if (tail.getPosition() == atPosition) {
			return tail;
		} else {
			Node searched = getRootNode();

			while(searched.getPosition() != atPosition) {
				if (searched.hasNextNode()) {
					searched = searched.getNextNode();
				}
			}

			return searched.getData();
		}
	}
}
