import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Main {
 
// Simple TNode class definition

static class TNode {
    String value;
    TNode left, right;
    List<TNode> nodeList; // For trie-like children

    TNode() {
        this.value = null;
        this.left = null;
        this.right = null;
        this.nodeList = new ArrayList<>();
    }

    TNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.nodeList = new ArrayList<>();
    }

    // New constructor to accept a char
    TNode(char value) {
        this.value = String.valueOf(value);
        this.left = null;
        this.right = null;
        this.nodeList = new ArrayList<>();
    }

    // Method to find a child node with the given char
    public TNode subNode(char c) {
        for (TNode child : this.nodeList) {
            if (child.value != null && child.value.equals(String.valueOf(c))) {
                return child;
            }
        }
        return null;
    }
    //add method to add a new word to the trie structure 
    public void add(String theWord) {
        TNode myNode = usaTree;
        for (char theChar : theWord.toCharArray()) {
            TNode childNode = myNode.subNode(theChar);
            if (childNode != null)
                myNode = childNode;
            else {
                TNode newChild = new TNode(theChar);
                myNode.nodeList.add(newChild);
                myNode = newChild;
            }
        }
    }
}


static TNode usaTree = new TNode(); // Uncomment and declare TNode if needed
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
        usaTree.add(state);
    }
}

////Search function using the bad character rule of the Boyer-Moore algorithm -display the indices of the matches

public static void search(String value) {
    System.out.println("Search functionality is not implemented yet.");
    
    for (char theChar : value.toCharArray()) {
       System.out.println(usaTree.subNode(theChar));
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
       System.out.println("Binary Search Tree Menu:");  
    for (int i = 0; i < options.length; i++) {
        System.out.println((i + 1) + ". " + options[i]);
    }
    System.out.print("Please enter your choice (1-" + options.length + "): ");
    choice = scanner.nextInt();
    switch (choice) {
       
        case 1:
            System.out.print("Enter the value to add: ");
            String searchValue = scanner.next();
            search(searchValue);
            break;
         case 2:
            displayText();
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
    // allow user to  have time to read the introduction before seeing the menu
    String enter = scanner.nextLine(); // Wait for user to press enter
    addStatesToTrie();
    menu(); // Call the menu function to start the program
}
}
