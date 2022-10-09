package base;

public abstract class DataStructure {
	private Node root;
	protected int nodeQuantities;


	protected DataStructure() {
		nodeQuantities = 0;
		root = null;
	}

	public void setRootNode(Node newRoot) {
		if (newRoot.getNodePosition() == 1) {
			root = newRoot;
		}
	}

	public Node getRootNode() {
		return root;
	}

	protected void addNodeQuantity() {
		nodeQuantities += 1;
	}

	protected void substractNodeQuantity() {
		nodeQuantities -= 1;
	}

	protected boolean hasRootNode() {
		return (root != null);
	}

	protected void moveNodeOneStepBackward(Node nodeToMove) {
		if (nodeToMove.getNodePosition() <= nodeQuantities) {
			nodeToMove.moveToPreviousPosition();
			if (nodeToMove.hasNextNode()) {
				moveNodeOneStepBackward(nodeToMove.getNextNode());
			}
		}
	}

	protected void moveNodeOneStepForward(Node nodeToMove) {
		if (nodeToMove.getNodePosition() <= nodeQuantities) {
			nodeToMove.moveToNextPosition();
			if (nodeToMove.hasNextNode()) {
				moveNodeOneStepForward(nodeToMove.getNextNode());
			}
		}
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public void show() {
		StringBuilder info = new StringBuilder(8);
		Node node = getRootNode();
		info.append(node);

		while (node.hasNextNode()) {
			info.append("\n").append(node.getNextNode());
			node = node.getNextNode();
		}

		System.out.println(info);
	}

	public int size() {
		return nodeQuantities;
	}
}
