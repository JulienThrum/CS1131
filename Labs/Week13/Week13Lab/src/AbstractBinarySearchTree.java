import java.util.ArrayList;

/**
 * Maintains a Binary Search Tree in an array list.
 * 
 * Given the index of a value (node) in the list, 
 * the left child will be at position: index * 2 + 1
 * and the right child will be at position: index * 2 + 2
 * 
 * Empty buckets must be set to null.
 */
public abstract class AbstractBinarySearchTree<V extends Comparable<V>> {
   /**
    * List for storing the tree.
    * The tree:
    *     A
    *      \
    *       C
    *      / \
    *     B   D
    * is stored as
    * [ A, null, C, null, null, B, D ]
    */
   protected ArrayList<V> treeList = new ArrayList<V>( );

   /**
    * The number of elements in the tree.
    * This is not necessarily the size of the array list.
    */
   protected int size = 0;
   
   /**
    * Convenience constructor method that adds the elements to the tree.
    * Useful for testing.
    * @param elements - an array of elements to be added to the tree.
    */
   public AbstractBinarySearchTree( V[ ] elements ) {
      for( V element : elements ) {
         insert( element );
      }
   }
   
   /**
    * Returns true if value is even, false otherwise.
    * @param value
    * @return
    */
   protected boolean isEven( int value ) {
      return ( value % 2 ) == 0;
   }

   /**
    * Returns true if value is odd, false otherwise.
    * @param value
    * @return
    */
   protected boolean isOdd( int value ) {
      return !isEven( value );
   }
   
   /**
    * Returns the position of the left child of the node at the index.
    * @param index
    * @return
    */
   public int leftIndex( int index ) {
      return index * 2 + 1;
   }
   
   /**
    * Returns the position of the right child of the node at index.
    * @param index
    * @return
    */
   public int rightIndex( int index ) {
      return index * 2 + 2;
   }
   
   /**
    * Returns the position of the parent of the node at index.
    * @param index
    * @return
    */
   public abstract int parentIndex( int index );
   
   /**
    * @return true if there are no nodes in the tree.
    */
   public boolean isEmpty ( ) {
      return size == 0;
   }
   
   /**
    * @return the number of nodes in the tree.
    */
   public abstract int size( );

   /**
    * Represent the tree as a string.
    * Uses the stringified array representation.
    */
   @Override
   public String toString( ) {
      return treeList.toString( );
   }

   /**
    * Inserts a value into the Binary Search Tree.
    * According to the rules:
    *    All values in the left subtree of a node are less than the value of the node.
    *    All values in the right subtree of a node are greater than the value of the node.
    *    No duplicates are allowed.
    * @param value
    * @return
    */
   public abstract boolean insert( V value );
   
   /**
    * Returns true if the specified value exists in the tree.
    * @param value
    * @return
    */
   public abstract boolean search( V value );

   /**
    * Prints the elements in sorted order.
    * Each node prints its left subtree, its value, then its right subtree.
    * See the textbook.
    */
   public abstract void inorderPrint ( );
}
