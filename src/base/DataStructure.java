package base;

public abstract class DataStructure {
	private Node root;
	private int nodeQuantities;


	protected DataStructure() {
		nodeQuantities = 0;
		root = null;
	}

	public void setRootNode(Node newRoot) {
		if (newRoot.getPosition() == 0) {
			root = newRoot;
		}
	}

	public Node getRootNode() {
		return root;
	}

	protected void checkRange(int position) {
		if (position < 0 || position > size()) {
			throw new IndexOutOfBoundsException("Position " + position + " out of bounds.");
		}
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
		checkRange(nodeToMove.getPosition());

		nodeToMove.moveToPreviousPosition();
		if (nodeToMove.hasNextNode()) {
			moveNodeOneStepBackward(nodeToMove.getNextNode());
		}
	}

	protected void moveNodeOneStepForward(Node nodeToMove) {
		checkRange(nodeToMove.getPosition());

		nodeToMove.moveToNextPosition();
		if (nodeToMove.hasNextNode()) {
			moveNodeOneStepForward(nodeToMove.getNextNode());
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
