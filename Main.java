import java.util.Scanner;

public class Main {
 
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


static Scanner scanner = new Scanner(System.in); // Declare Scanner as static for global access

////Search function using the bad character rule of the Boyer-Moore algorithm -display the indices of the matches

public static void search(String value) {
    System.out.println("Search functionality is not implemented yet.");
    // Placeholder for search functionality
    // You can implement the search logic here
    // Return to the menu after search
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

    menu(); // Call the menu function to start the program
}
}
