public class Lab13 extends AbstractBinarySearchTree{
    /*
        Julien Thrum, Drew Rosales, Sean Parker
        all of our methods work(we think), except for the insert method.
        we think it is the if conditions, and the while loop
     */
    /**
     * Convenience constructor method that adds the elements to the tree.
     * Useful for testing.
     *
     * @param elements - an array of elements to be added to the tree.
     */
    public Lab13(Comparable[] elements) {
        super(elements);
    }

    /**
     * Returns the position of the parent of the node at index.
     *
     * @param index
     * @return
     */
    @Override
    public int parentIndex(int index) {
        if(isEven(index)) {
            return rightIndex(index);
        } else {
            return leftIndex(index);
        }
    }

    /**
     * @return the number of nodes in the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Inserts a value into the Binary Search Tree.
     * According to the rules:
     * All values in the left subtree of a node are less than the value of the node.
     * All values in the right subtree of a node are greater than the value of the node.
     * No duplicates are allowed.
     *
     * @param value
     * @return
     */
    @Override
    public boolean insert(Comparable value) {
        int i = 0;
        if(isEmpty()) {
            treeList.add(value);
        } else {
            while(search(value) == false) {
                if(treeList.get(leftIndex(i)) == null) {      //Go left
                    treeList.set(leftIndex(i), value);
                } else if(treeList.get(rightIndex(i)) == null) { //Go right
                    treeList.set(rightIndex(i), value);
                }
                i++;
            }
        }
        size++;
        return true; //returns true
    }

    /**
     * Returns true if the specified value exists in the tree.
     *
     * @param value
     * @return
     */
    @Override
    public boolean search(Comparable value) {
        int i = 0;
        while(treeList.get(i) != null) {
            if(treeList.get(i) != null && value.compareTo(treeList.get(i)) < 0) {      //Go left
                i = leftIndex(i);
            } else if(value.compareTo(treeList.get(i)) > 0) { //Go right
                i = rightIndex(i);
            } else if(value.compareTo(treeList.get(i)) == 0) {
                return true;
            }
        }
        return false;
    }

    public Comparable getValue(int index) {
        return (Comparable)treeList.get(index);
    }

    public int getIndex(Comparable value) {
        for(int i = 0; i < treeList.size(); i++) {
            if(value.compareTo(treeList.get(i)) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Prints the elements in sorted order.
     * Each node prints its left subtree, its value, then its right subtree.
     * See the textbook.
     */
    @Override
    public void inorderPrint() {
        for(int i = 0; i < treeList.size(); i++) {
            if(treeList.get(i) != null) {
                System.out.print(treeList.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {
        Integer[] list = {1, 2, 5, 4};
        Lab13 obj = new Lab13(list);
        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        obj.inorderPrint();
//        obj.insert(2);
//        obj.inorderPrint();
    }

}
