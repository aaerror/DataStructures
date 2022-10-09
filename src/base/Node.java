package base;

public class Node {
	private final Object data;
	private int position;
	private Node nextNode;
	private Node previousNode;


	private Node(Object data) {
		this.data = data;
		this.position = 1;
	}

	public static Node create(Object data) {
		return new Node(data);
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node next) {
		nextNode = next;
	}

	public Object getNodeData() {
		return data;
	}

	public void setPreviousNode(Node previous) {
		previousNode = previous;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public int getNodePosition() { return position; }

	public void moveToNextPosition() {
		position += 1;
	}

	public void moveToPreviousPosition() {
		if (position >= 2) {
			position -= 1;
		}
	}

	public boolean hasNextNode() {
		return (nextNode != null);
	}

	public boolean hasPreviousNode() { return (previousNode != null); }

	public String toString() {
		return String.format("Node at %s: %s", position, data);
	}
}
