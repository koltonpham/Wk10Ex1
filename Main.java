import java.util.Scanner;  // Import the Scanner class
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;


class Main {

    static Map<String, Integer> votings = new LinkedHashMap<>(); //create dictionary to store votes

    public static void CastVote(String candidateName)
    {
        votings.put(candidateName, votings.get(candidateName) + 1);
    }

    public static void DisplayResults()
    {
        for (Map.Entry<String, Integer> entry : votings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void ResetVotes()
    {
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


    while (running) {
        System.out.println("Who do you want to vote for? (1 for " + candidateOne  + " , 2 for " + candidateTwo + " , 3 for " + candidateThree + " , 4 to reset votes, and 5 to exit)");
        userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                CastVote(candidateOne);
                DisplayResults();
                break;
            case 2:
                CastVote(candidateTwo);
                DisplayResults();
                break;
            case 3:
                CastVote(candidateThree);
                DisplayResults();
                break;    
            case 4:
                ResetVotes();
                DisplayResults();
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Please enter a valid number 1-5");
                break;
        }
    }    
  }
}

