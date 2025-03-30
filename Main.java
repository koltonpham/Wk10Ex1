import java.util.Scanner;  // Import the Scanner class
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;


class Main {

    static Map<String, Integer> votings = new LinkedHashMap<>(); //create dictionary to store votes, use linkedhashmap to maintain order 

    public static void CastVote(String candidateName) //method to add to value
    {
        votings.put(candidateName, votings.get(candidateName) + 1); //add to value of candidate selected
    }

    public static void DisplayResults() //method to print results
    {
        //for loop that prints all the key and values of the dictionary
        for (Map.Entry<String, Integer> entry : votings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void ResetVotes() //method to reset all votes
    {
        //for loop that sets all values to 0
        for (String key : votings.keySet()) {
            votings.put(key, 0);
        }    
    }

    public static void main(String[] args) {
    //declarations
    String candidateOne;
    String candidateTwo;
    String candidateThree;
    boolean running = true;
    int userInput;
    
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Presidential Voting");
    
    System.out.println("Please enter candidate one:");
    candidateOne = scanner.nextLine();  // Read user input
    System.out.println("Please enter candidate two:");
    candidateTwo = scanner.nextLine();  // Read user input
    System.out.println("Please enter candidate three:");
    candidateThree = scanner.nextLine();  // Read user input

    //add values to dictionary
    votings.put(candidateOne, 0);
    votings.put(candidateTwo, 0);
    votings.put(candidateThree, 0);

    //while loop that runs until user exits
    while (running) {
        System.out.println("Who do you want to vote for? (1 for " + candidateOne  + " , 2 for " + candidateTwo + " , 3 for " + candidateThree + " , 4 to reset votes, and 5 to exit)");
        userInput = scanner.nextInt(); //take user input for switch case
        switch (userInput) { //switchcase that calls method to either cast the vote, reset, or exit
            case 1:
                CastVote(candidateOne); //call method for candidate one
                DisplayResults(); //print all results
                break; //break from switch 
            case 2:
                CastVote(candidateTwo); //call method for candidate two
                DisplayResults(); //print all results
                break; //break from switch 
            case 3:
                CastVote(candidateThree);
                DisplayResults(); //print all results
                break;    //break from switch 
            case 4:
                ResetVotes(); //reset all votes
                DisplayResults(); //print all results
                break; //break from switch 
            case 5:
                running = false; //break out from while loop
                break; //break from switch 
            default:
                System.out.println("Please enter a valid number 1-5"); //check for valid input
                break; //break from switch 
        }
    }    
  }
}

