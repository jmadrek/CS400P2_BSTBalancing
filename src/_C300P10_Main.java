import java.util.ArrayList;
import java.util.Scanner;

public class _C300P10_Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _C300P10_Dictionary dic = new _C300P10_Dictionary();
        Scanner scnr = new Scanner(System.in);
        
        boolean exit = false;
        String command = "";
        String word = "";
        String meaning = "";
        String dicResponse = "";
        
        while (!exit){
            displayPrompt();
            
            command = scnr.next();
            try{
                switch (command.toUpperCase()){
                    case "I": //Insert new word
                        try{
                            word = scnr.next();
                            meaning = scnr.nextLine().trim();
                            dic.insert(word, meaning);
                        } catch (IllegalArgumentException e){
                            System.out.println("\nWARNING: failed to insert duplicate word: " 
                                            +  word + ".");
                        }
                        break;
                    case "L": //Lookup def of word
                        try{
                            System.out.println();
                            word = scnr.next();
                            dicResponse = dic.lookup(word);
                            if (dicResponse == null)
                                dicResponse = "No definition found for the word " + word;
                            else
                                 dicResponse = word + " - " + dicResponse;
                             
                            System.out.println(dicResponse);
                        } catch (NullPointerException e) {
                            System.out.println("There are no definitions in this empty " + 
                                                "dictionary.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "A": //See all words in dictionary
                        System.out.println();
                        try{
                            printDic(dic);
                        } catch (NullPointerException e) {
                            System.out.println("Dictionary is empty.");
                        }
                        break;
                    case "C": //Return word count
                        System.out.println();
                        try{
                            System.out.println(dic.getWordCount());
                        } catch (NullPointerException e) {
                            System.out.println("0");
                        }
                        break;
                    case "Q": //Exit function
                        exit = true;
                        break;
                    default:
                        System.out.println("WARNING: Unrecognized command.");
                }
            } catch (NullPointerException e) {
                System.out.println("The dictionary must have at least one word before you " + 
                                    "attempt this command");
            } 
            System.out.println();
        }
        
        scnr.close();
        
        
    }
    
    /**
     * Prints out the dictionary
     * @param dic - dictionary sent in
     */
    private static void printDic(_C300P10_Dictionary dic){
        ArrayList<String> mArray;
        int count = 0;
        
        mArray = dic.getAllWords();
        if (mArray.size() > 0){
            for (String s : mArray){
                count++;
                System.out.print(s);
                if (count != mArray.size())  System.out.print(", ");
                else System.out.print(" ");
            }
            System.out.println();
        } else {
            System.out.println("Dictionary is empty.");
        }
    }
    
    /**
     * Display the prompt for users
     */
    private static void displayPrompt(){
        System.out.println("==================Dictionary =================");
        System.out.println("Enter 'I' to Insert a definition in the dictionary");
        System.out.println("Enter 'L' to Lookup a definition in the dictionary");
        System.out.println("Enter 'A' to print All the words in the dictionary");
        System.out.println("Enter 'C' to print the Count of all words in the dictionary");
        System.out.println("Enter 'Q' to quit the program");
        System.out.println("===========================================");
        System.out.print("Please enter your command: ");
    }

}
