import java.util.ArrayList;

public class _C300P10_Dictionary {
    /*****************************
     * Private Fields
     *****************************/
    
    private _C300P10_DefinitionNode root; // the root definition in the BST
    
    /*****************************
     * Constructors
     *****************************/
    
    /*****************************
     * Public Methods
     *****************************/
    
    /**
     * Inserts a new word along with its meaning into the dictionary.
     * @param word The word to be inserted
     * @param meaning The meaning of the word being inserted
     * @throws IllegalArgumentException when the word is already in this dictionary
     */
    public void insert(String word, String meaning) throws IllegalArgumentException {
        // implement using the DefinitionNode's insertHelper() method
        try {
            //set root if null
            if (this.root == null){
                this.root = new _C300P10_DefinitionNode(word, meaning);
                return;
            }
            this.root.insertHelper(new _C300P10_DefinitionNode(word, meaning));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
     
    /**
     * Searches for the definition of a word, and then return that word's meaning.
     * @param word The word that is being searched for
     * @return The meaning of the word, or null if the word cannot be found.
     */
    public String lookup(String word) {
        // implement using the DefinitionNode's lookupHelper() method
        return this.root.lookupHelper(word);
     }
     
    /**
     * Computes the number of words that are currently in this dictionary.
     * @return That number of words
     */
    public int getWordCount() {
        // implement using the DefinitionNode's getWordCountHelper() method
        return this.root.getWordCountHelper();
    }
     
    /**
     * Computes a list of all of the words that are currently in this dictionary.
     * @return That list of all the words
     */
    public ArrayList<String> getAllWords() {
        // implement using the DefinitionNode's getAllWordsHelper() method
        return this.root.getAllWordsHelper();
    }
}
