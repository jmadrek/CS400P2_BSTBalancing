<<<<<<< HEAD
/**
 * 2-3 Tree Basics
 *  Every non-leaf node has either 2 or 3 children
 *  All leaves are at the same depth
 *  Keys stored only at leaves
 *  Keys at leaves ordered left to right
 *  In addition to child pointers, each internal node stores
 *      leftMax
 *      midMax
 *  If a node only has two children, they are left and middle (not left and right)
 * @author devbox
 *
 * @param <T>
 */



=======
>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8
// starter class for a BalancedSearchTree
// you may implement AVL, Red-Black, 2-3 Tree, or 2-3-4 Tree
// be sure to include in class header which tree you have implemented
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

<<<<<<< HEAD
    
    /*##########################################
    # Inner class - Tree Node
    ##########################################*/
    
	// inner node class used to store key items and links to other nodes
	protected class Treenode<K extends Comparable<K>> {
	    
	    /*********************
         * Private Class Fields
         ********************/
	    
	    K key;
	    K leftMax;
	    K midMax;
	    
        Treenode<K> left;
        Treenode<K> mid;
        Treenode<K> right;
        
        
	    /*********************
	     * Constructors
	     ********************/
	    
	    /**
	     * Default COnstructur, send in key
	     * 
	     * @param item - Key value
	     */
	    public Treenode(K item) {
			this(item,null,null, null);
		}
	    
	    
	    //TODO: This may not be needed for a 2-3 tree
		/**
		 * Set key along with left, mid, and\or right
		 * 
		 * @param item - item we are adding
		 * @param left - left child
		 * @param mid - middle child
		 * @param right - right child
		 * 
		 */
		public Treenode(K item, Treenode<K> left, Treenode<K> mid, Treenode<K> right) {
			key = item;
			this.left = left;
			this.mid = mid;
			this.right = right;
		}
		
		
		
		/**
		 * Create internal node to organize leaf nodes
		 * 
		 * @param left
		 * @param leftMax
		 * @param mid
		 * @param midMax
		 * @param right
		 */
		public Treenode(Treenode<K> left, Treenode<K> mid, Treenode<K> right) {
		    key = null;
		    
		    //set left and left max
		    this.left = left;
		    this.leftMax = left.getMax();
		    
		    //set mid and mid max
		    this.mid = mid;
		    this.midMax = mid.getMax();
		    
		    //set right if present
		    this.right = right;
        }

		//TODO:  I should consider if I want this as part of the node or the tree itself
		//If tree itself then I still need to send in leftMax and midMax
		/**
		 * Returns max nodes max value
		 * if leaf, returns value
		 * if not leaf returns max child
		 * 
		 * @return max value of children
		 */
		private K getMax(){
		    //If key, then leaf nod, return leaf
		    if (key != null)
		    //If right then 3 items, 
		    //we need to go a level down because we need the full max, not mid max
		    if (this.right != null) return this.right.getMax();
		    //if no right then must have mid max, because no mid max would mean leaf
		    else if (this.mid != null) return this.mid.getMidMax();
		}
		
		/*********************
         * Getters and Setters - autogen by Source
         ********************/
		
		
        public K getKey() {
            return key;
        }


        public void setKey(K key) {
            this.key = key;
        }


        public K getLeftMax() {
            return leftMax;
        }


        public void setLeftMax(K leftMax) {
            this.leftMax = leftMax;
        }


        public K getMidMax() {
            return midMax;
        }


        public void setMidMax(K midMax) {
            this.midMax = midMax;
        }


        public Treenode<K> getLeft() {
            return left;
        }


        public void setLeft(Treenode<K> left) {
            this.left = left;
        }


        public Treenode<K> getMid() {
            return mid;
        }


        public void setMid(Treenode<K> mid) {
            this.mid = mid;
        }


        public Treenode<K> getRight() {
            return right;
        }


        public void setRight(Treenode<K> right) {
            this.right = right;
        }
		
		
	}

	
	/*##########################################
    # Balanced Search Tree (2-3 Tree)
    ##########################################*/
	
	/*********************
     * Private Class Fields
     ********************/
	
	protected Treenode<T> root;

	
	/*********************
     * Public interface
     ********************/
	
	
	/**
	 * inAscendingOrder()
	 * 
     * returns a string with the values in ascending order
     * The form of the string returned is a comma separated list
     * without additional spaces between keys ending with a comma.
     * For example if the keys in the tree are A,B, and C
     * then the String returned would be:
     * 
     *  <pre>
     *  A,B,C,
     *  </pre>
     *  
     *  If no keys have been inserted, return an empty string "" without any keys
     *  
     * @return comma-separated list of keys for this search tree in ascending order
     */
=======
	// inner node class used to store key items and links to other nodes
	protected class Treenode<K extends Comparable<K>> {
		public Treenode(K item) {
			this(item,null,null);
		}
		public Treenode(K item, Treenode<K> left, Treenode<K> right) {
			key = item;
			this.left = left;
			this.right = right;
		}
		K key;
		Treenode<K> left;
		Treenode<K> right;
	}

	protected Treenode<T> root;

>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8
	public String inAscendingOrder() {
		//TODO : must return comma separated list of keys in ascending order
		return "" ;
	}
<<<<<<< HEAD
	
	

	/**
	 * isEmpty()
	 * 
	 * returns true if root is null
	 */
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * height()
	 * 
     * Computes and returns the height of this tree.
     * The height of a tree is the number of nodes 
     * along the path from root to lowest leaf node.
     * 
     * For example, the height of a tree with no keys is zero
     * and the height of a tree with one key is 1.
     *
     * @return the height of this tree
     */
=======

	public boolean isEmpty() {
		//TODO return empty if there are no keys in structure
		return true;
	}

>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8
	public int height() {
		//TODO return the height of this tree
		return 0; 
	}

<<<<<<< HEAD
	
	/**
	 * lookup(T)
	 * 
	 * if key is in this BST, return true; otherwise, return false
	 */
=======
>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8
	public boolean lookup(T item) {
		//TODO must return true if item is in tree, otherwise false
		return false;
	}

<<<<<<< HEAD
	// add the item (key) to this search tree
    // throw IllegalArgumentException if item is null
	public void insert(T item) throws IllegalArgumentException{
	    
	    //Throw exception if null
	    if (item == null) throw new IllegalArgumentException("Attempting to insert a null key");
	    
		//Insert
	    
	    // 1) If root is null, add root
	    if (root == null) {
	        root = new Treenode<T>(item);
	        
	    } else if (root.getLeft()== null) {
        /* 2) if tree is just 1 node (no kids) then
         *     a) create new leaf node containing K
         *     b) create new internal node with m and n as its children
         *         and with appropriate values for left max and middle max
         */
	        //a
	        Treenode<T> newNode = new Treenode<T>(item);
	        
	        //b
	        Treenode<T> newParent;
	        if (newParent.getKey().compareTo(root.getKey()) < 0) {
	            newParent = new Treenode<T>(newParent, root, null);
	        } else
	            
	        }

	        
	    } else {
	        
	    }
	    
	}

	
	/**
	 * delete (T)
	 * 
	 * remove the item (key) to this search tree
     * if the item is not found, return without error or side-effect
	 */
=======
	public void insert(T item) {
		//TODO if item is null throw IllegalArgumentException, 
		// otherwise insert into balanced search tree
	}

>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8
	public void delete(T item) {
		//TODO if item is null or not found in tree, return without error
		// else remove this item key from the tree and rebalance

		// NOTE: if you are unable to get delete implemented
		// it will be at most 5% of the score for this program assignment
	}

<<<<<<< HEAD
	
	
	
	/*********************
     * Private Class Methods
     ********************/
	
=======
>>>>>>> da593bb8058b12557b4eee3005d9769dc543a2c8

	// HINT: define this helper method that can find the smallest key 
	// in a sub-tree with "node" as its root
	// PRE-CONDITION: node is not null
	private T leftMost(Treenode<T> node) {
		// TODO return the key value of the left most node in this subtree
		// or return node's key if node does not have a left child
		return node.key;
	}

}

