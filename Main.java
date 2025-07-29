
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
    // Helper method to recursively collect words
    private void collectWords(TrieNode node, String prefix, List<String> result) {
    if (node.endOfWord) {
        result.add(prefix); // Found a full word
    }
    for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
        collectWords(entry.getValue(), prefix + entry.getKey(), result);
    }
}
    /// pass back  all words that match the prefix
    public List<String> searchByPrefix(String prefix) {

        List<String> results = new ArrayList<>();
        TrieNode current = root;

        // Traverse the Trie to find the prefix
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return results; // No words with this prefix
            }
        }
        // If we reach here, we found the prefix, now collect all words
        
         collectWords(current, prefix, results);
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
        usaTree.insert(state.toLowerCase());
    }
}


////Search function using the bad character rule of the Boyer-Moore algorithm -display the indices of the matches

public static void search(String value) {
    char[] charValue = value.toCharArray();
    // cut down the search to the first character from value 
    List<String> results = usaTree.searchByPrefix(String.valueOf(Character.toLowerCase(charValue[0])));
    if (charValue.length == 1 && !results.isEmpty()) {
        System.out.println("Results: " + results);
        return;
    }
    // If no results found, return early
    if (results.isEmpty()) {
        System.out.println("Findings:");
        System.out.println("No matches found.");
        return;
    }
    // If the value is longer than one character, we will use the Boyer-Moore algorithm
     String pattern = value.toLowerCase();
     String data = String.join(",", results);
     ArrayList<String> findings = new ArrayList<>();
   
       for(int i = 0; i < data.length(); ) {
        int j = pattern.length() - 1; // Start from the end of the pattern
        while (j >= 0 && i + j < data.length() && pattern.charAt(j) == data.charAt(i + j)) {
            j--; // Move left in the pattern
        }
        if (j < 0) {
            // Match found at index i
           
            String matchSlice = data.substring(i, data.length());
            String match = matchSlice.split(",")[0]; // Get the first part of the match
             
             if (!findings.contains(match)) {
                findings.add(match); // Add to findings if not already present
             }
            i += (i + pattern.length() < data.length()) ? pattern.length() : 1; // Shift by pattern length or 1
        } 
        //if (value)pattern not in string section , then  shift  search  section 
        else {
            if (i + j < data.length()) {
                char mismatchChar = data.charAt(i + j);
                int lastIndex = pattern.lastIndexOf(mismatchChar);
                if (lastIndex == -1) {
                    // Mismatched character not in pattern, shift by full length
                    i += pattern.length();
                } else {
                    // Shift by the difference between mismatch index and last index in pattern
                    i += Math.max(1, j - lastIndex);
                }
            } else {
                // If out of bounds, break the loop to avoid exception
                break;
            }
        }
       
    }
    // Display the findings
    System.out.println("Findings:");
    if (findings.isEmpty()) {
        System.out.println("No matches found.");
        return;
    }
    else{

        for( String finding : findings) {
        finding = finding.substring(0, 1).toUpperCase() + finding.substring(1); // Capitalize the first letter
        System.out.println(finding); 
    }
    }
    
   
    
       
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
            menu();
            break;
        case 3:
            System.out.println("Exiting program.");
            scanner.close(); // Close the scanner to prevent resource leaks
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please try again.");
            menu();
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
