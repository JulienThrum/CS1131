public class BinarySearchTree<V extends Comparable<V>> {
    public class Node {
        private V value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node root = null;
    private int size = 0;

    public boolean isEmpty() {
        //return root == null;
        //return size == 0;
        return size == 0 || root == null;   //this is if shit goes down and the tree doesn't work (e.i. bad programmer)
    }

    public int size() {
        return size;
    }

    public void add(V value) {
        if(isEmpty()) {
            root = new Node(value);
        } else {
            add(root, value);
        }
        size++;
    }

    private void add(Node node, V value) {
        // Value greater than node value
        if(node.getValue().compareTo(value) < 0) {
            if(node.getRightChild() == null) {
                node.setRightChild(new Node(value));
            } else {
                add(node.getRightChild(), value);
            }
        }
        // Value less than node value
        else if(node.getValue().compareTo(value) > 0){
            if(node.getLeftChild() == null) {
                node.setLeftChild(new Node(value));
            } else {
                add(node.getLeftChild(), value);
            }
        }
        // Value equals node value
        else {
            throw new IllegalArgumentException("Value already exists in tree");
        }
    }
}
