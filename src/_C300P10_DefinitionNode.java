import java.util.ArrayList;

/**
 * Represents the word and associated word definition for the dictionary binary search tree
 * 
 * @author hayesbirchle
 *
 */
public class _C300P10_DefinitionNode {
    /*****************************
     * Private Fields
     *****************************/
    private final String word;      // the word this definition defines
    private final String meaning;   // the meaning of that word    
    private _C300P10_DefinitionNode leftChild;   // nodes preceding this one alphabetically
    private _C300P10_DefinitionNode rightChild;  // nodes following this one alphabetically
     
    /*****************************
     * Constructors
     *****************************/
    
    /**
     * :DONE:
     * Constructs a DefinitionNode with the specified word and meaning.
     * @param word The word associated with this definition
     * @param meaning The meaning of that word
     * @throws IllegalArgumentException when the word or meaning are either
     *         references to an empty string or null references.
     */
    public _C300P10_DefinitionNode(String word, String meaning) {
        if( blank(word) || blank(meaning)) throw new IllegalArgumentException();
        this.word = word;
        this.meaning = meaning;
    }
     
    
    /*****************************
     * Public Methods
     *****************************/
    
    /**
     * This helper method inserts a new node into the tree or subtree that is 
     * rooted at this node.  If it cannot directly add the new node as a child 
     * of this node, then it must recursively call this method on its appropriate
     * child, to eventually complete this insertion.
     * @param newNode The new node that is being inserted into the tree
     * @throws IllegalArgumentException when the word inside newNode is already in
     *         the tree.  Multiple definitions for the same word are not allowed.
     */
    public void insertHelper(_C300P10_DefinitionNode newNode) throws IllegalArgumentException { 
        //New node is prior to current node
        if (newNode.word.compareToIgnoreCase(this.word) < 0){
            if (this.leftChild == null) this.leftChild = newNode;
            else this.leftChild.insertHelper(newNode);
        //Check left child
        } else if (newNode.word.compareToIgnoreCase(this.word) > 0){
            if (this.rightChild == null) this.rightChild = newNode;
            else this.rightChild.insertHelper(newNode);
        //Check right child
        } else { //Words are equal, should not happen in this assignment
            throw new IllegalArgumentException();
        }
    }
     
    /**
     * This helper method retrieves the meaning of a particular word from the
     * tree or subtree rooted at this node.  Like the insertHelper method above, 
     * this method should also be defined recursively.
     * @param word The word associated with the meaning being looked up
     * @return The meaning of that word, or null if the word is not found
     */
    public String lookupHelper(String word) {
        //Check for match first
        if (word.equalsIgnoreCase(this.word)) return this.meaning;
        
        //Check children                
        if (word.compareToIgnoreCase(this.word) < 0){
            if (this.leftChild != null) return this.leftChild.lookupHelper(word);
        } else if (word.compareToIgnoreCase(this.word) > 0){
            if (this.rightChild != null) return this.rightChild.lookupHelper(word);
        }

        return null; 
    }
    
     
    /**
     * This recursive helper method retrieves the number of words in the tree
     * or subtree rooted at this node.
     * @return The number of definitions in this tree or subtree
     */
    public int getWordCountHelper() {
        int count = 0; 
        if (!blank(this.word)) {
            count = 1; //One for current
            //add left subtree
            if (this.leftChild != null) count += this.leftChild.getWordCountHelper();
            //add right sub tree
            if (this.rightChild != null) count += this.rightChild.getWordCountHelper();
        }
        
        return count;
        
    } 
     
    /**
     * This recursive helper method retrieves a list containing all of the
     * words in the tree or subtree rooted at this node.
     * @return The list of all words in this words tree or subtree
     */
    public ArrayList<String> getAllWordsHelper() {
        ArrayList<String> mArray = new ArrayList<String>();
        if (!blank(this.word)) {
            //add left subtree
            if (this.leftChild != null) mArray.addAll(this.leftChild.getAllWordsHelper());
            //Add current
            mArray.add(this.word);
            //add right sub tree
            if (this.rightChild != null) mArray.addAll(this.rightChild.getAllWordsHelper());   
        }
        return mArray; 
    }
    
    
    
    
    /*****************************
     * Private Helper Methods
     *****************************/
    
    /**
     * Checks to see if a string is blank or null
     * @param comp
     * @return - true if blank or null, false if values present
     */
    private boolean blank(String comp){
        return ((comp.equals("") || comp == null));
    }
    
    
}
