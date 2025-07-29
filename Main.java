import java.util.*;

public class Main {

// TrieNode class to represent each node in the Trie
 static class TrieNode{
   Map<Character, TrieNode> children;
   boolean endOfWord; // Indicates if this node marks the end of a word

    // Constructor to initialize the TrieNode
    TrieNode() {
         children = new HashMap<>();
         endOfWord = false; // Initialize to false
    }
     
 }

 // Trie class to manage the Trie structure
   static class Trie {
    private TrieNode root;

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currentNode.endOfWord = true; // Mark the end of the word
    }
    
    /// pass back  all words that match the prefix
    public List<String> searchByPrefix(String prefix) {

        List<String> results = new ArrayList<>();
        TrieNode currentNode = root;

        // Traverse the Trie to find the prefix
        for (char c : prefix.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                return results; // No words with this prefix
            }
        }
        // If we reach here, we found the prefix, now collect all words
        System.out.println("Found prefix: " + prefix + ", collecting words..." + results);
        return results;
    }    

}

 static Trie usaTree = new Trie(); 
static Scanner scanner = new Scanner(System.in); // Declare Scanner as static for global access



// array with the names of 50 states in the United States and it's  declare as static for global access    
static String[] states = {
        "Alabama", "Alaska", "Arizona", "Arkansas", "California",
        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
        "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
        "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
        "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
        "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
        "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    };

// add states method to the trie structure
public static void addStatesToTrie() {
    for (String state : states) {
        usaTree.insert(state);
    }
}


////Search function using the bad character rule of the Boyer-Moore algorithm -display the indices of the matches

public static void search(String value) {
    System.out.println("Search functionality is not implemented yet.");
    List<String> results = usaTree.searchByPrefix("o");
    System.out.println("Results: " + results);

  /* 
   // Step 1: Add patterns to Trie
trie.insert("Texas");
trie.insert("Ohio");
trie.insert("California");

// Step 2: Retrieve matches based on user input prefix
List<String> matchedPatterns = trie.searchByPrefix("O");

// Step 3: Run Boyer-Moore on each matched pattern
for (String pattern : matchedPatterns) {
    boyerMooreSearch(documentText, pattern); // documentText is your main corpus
}
// Step 4: Display results
   
   
   */
  
  
  
    // working on trie 
  
  
  
  
    //bad  character rule steps 

  //1. if not  in pattern (value) string , then skip pattern.length
  //2. if in pattern (value) string, then shift the pattern -  lastindex - index of the most right mismatch  character 
  //3. overlook at the last character in  pattern  string 
    


    
 /* for (char theChar : value.toCharArray()) {
       System.out.println(usaTree.subNode(theChar));
}*/ 

    
}

// display the text of the states in the United States
public static void displayText() {
    System.out.println("States in the United States:");
    for (String state : states) {
        System.out.println(state);
    }
}

//menu function to display options and handle user input
public static void menu() {

     int choice;
    String[] options = {"Display the text", "Search", "Exit program"};
    // Display the menu options
       System.out.println(" Searching Text & String Data Menu:");  
    for (int i = 0; i < options.length; i++) {
        System.out.println((i + 1) + ". " + options[i]);
    }
    System.out.print("Please enter your choice (1-" + options.length + "): ");
    choice = scanner.nextInt();
    switch (choice) {
       
         case 1:
            displayText();
            menu();
            break;
        case 2:
            System.out.print("Enter the value to search: ");
            String searchValue = scanner.next();
            search(searchValue);
            break;
        case 3:
            System.out.println("Exiting program.");
            scanner.close(); // Close the scanner to prevent resource leaks
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please try again.");
    }
  
}  



    public static void main(String[] args) {
    //introduction to the program
    System.out.println("Welcome to the  Searching Text & String Data Program!");   
    System.out.println("In this program we will let you search and  display text. We will give you options to pick so please enter numbers that associate with the option and not type in the words. ");
    System.out.println("Here is an example: Who walked across the road?  1.Dog 2.Cat 3.Chicken.");
    System.out.println("You would enter 3 and not the word chicken, then press enter.");
    System.out.println("There  will  be a time when you  will be next to type in letters which  will  be when you search.");
    System.out.println(" press enter to continue");
    addStatesToTrie();
    // allow user to  have time to read the introduction before seeing the menu
    String enter = scanner.nextLine(); // Wait for user to press enter
    menu(); // Call the menu function to start the program
}
}
