package Base;

public abstract class DataStructure {
	private Node root;
	protected int nodeQuantities;


	protected DataStructure() {
		root = null;
		nodeQuantities = 0;
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
		if (nodeToMove.getNodePosition() < nodeQuantities) {
			nodeToMove.moveToNextPosition();
			if (nodeToMove.hasNextNode()) {
				moveNodeOneStepForward(nodeToMove.getNextNode());
			}
		}
	}

	private Node getNodeAtPosition(Node fromNode, int atPosition) throws Exception {
		if (atPosition >= nodeQuantities) {
			throw new IllegalArgumentException("Position is greater than node quantity.");
		}

		if (hasRootNode()) {
			throw new Exception("There isn't nodes on the list.");
		}

		int nodePosition = fromNode.getNodePosition();
		if (nodePosition == atPosition) {
			return fromNode;
		} else {
			Node next = fromNode.getNextNode();

			return getNodeAtPosition(next, atPosition);
		}
	}

	protected Object retrieveData(int atPosition) {
		Object result;
		try {
			Node nodeAtPosition = getNodeAtPosition(root, atPosition);
			result = nodeAtPosition.getNodeData();
		} catch (Exception ex) {
			result = ex.getMessage();
		}

		return result;
	}

	protected void info() {
		StringBuilder info = new StringBuilder();
		Node node = getRootNode();
		info.append(node);
		
		while (node.hasNextNode()) {
			info.append("\n").append(node.getNextNode());
			node = node.getNextNode();
		}
		System.out.println(info);
	}
}
