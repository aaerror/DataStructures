package LIFO;

import Base.DataStructure;
import Base.Node;

public class LIFO extends DataStructure {
	private LIFO() {
		super();
	}

	public static LIFO createLIFO() {
		return new LIFO();
	}

	public int count() { return nodeQuantities; }

	public boolean isEmpty() {
		return (count() == 0);
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
		Node newNode = Node.createNode(newData);
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

	public void showData() {
		listData(getRootNode());
	}
}
