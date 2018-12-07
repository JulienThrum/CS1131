public class Chapter25<V extends Comparable<V>> {
    public class Node {
        private V value;
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

        public String toString() {
            return getValue().toString();
        }
    }

    private Node root = null;
    private int size = 0;
    private int leaves = 0;

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
        else if(node.getValue().compareTo(value) > 0) {
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

    public Node find(V value) {
        return find(root, value);
    }

    private Node find(Node node, V value) {
        if(node == null) {  //Value not found
            return null;
        }

        if(value.compareTo(node.getValue()) > 0) {  //Go right
            return find(node.getRightChild(), value);
        } else if(value.compareTo(node.getValue()) < 0) {// Go left
            return find(node.getLeftChild(), value);
        } else {    // Found it
            return node;
        }
    }

    public interface Visitor {
        public void visit(Chapter25.Node node);
    }

    public void preorder(Node node, Visitor v) {
        if(node == null) {
            return;
        }
        v.visit(node);
        preorder(node.getLeftChild(), v);
        preorder(node.getRightChild(), v);
    }

    public void inorder(Node node, Visitor v) {
        if(node == null) {
            return;
        }
        preorder(node.getLeftChild(), v);
        v.visit(node);
        preorder(node.getRightChild(), v);
    }

    public void postorder(Node node, Visitor v) {
        if(node == null) {
            return;
        }
        preorder(node.getLeftChild(), v);
        preorder(node.getRightChild(), v);
        v.visit(node);
    }

    private void zeroLeaves() {
        leaves = 0;
    }

    public int getNumberOfLeaves() {
        zeroLeaves();
        inorder(root, e -> {
            if(e.getLeftChild() == null && e.getRightChild() == null) {
                leaves++;
            }
        });
        return leaves;
    }

    public static void main(String[] args) {
        Chapter25<String> tree = new Chapter25<>();
        tree.add("D");
        tree.add("G");
        tree.add("B");
        tree.add("A");
        System.out.println("preorder:");
        tree.preorder(tree.root, n -> {
            System.out.print(n + " ");
        });
        System.out.println("\ninorder:");
        tree.inorder(tree.root, n -> {
            System.out.print(n + " ");
        });
        System.out.println("\npostorder:");
        tree.postorder(tree.root, n -> {
            System.out.print(n + " ");
        });
    }
}
