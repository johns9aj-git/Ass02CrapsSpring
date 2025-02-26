import java.util.Scanner;
import java.util.Random;

public class CrapsGame {
    public static void main(String[] args) {
        // Initilization Phase
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int die01 = 0;
        int die02 = 0;
        int die03 = 0; // NOTE: Not sure if I'm going to be using these extra dies.
        int die04 = 0; // NOTE: Not sure if I'm going to be using these extra dies.
        int diceSum = 0;
        boolean playAgain = true;
        String playerBName = ""; // <-- I was thinking about adding multiple players, but I'm lazy.
        int rollCount = 0;
        int points = 0;
        int[] stopNumbers = { 2, 3, 12, 7, 11 }; // Wanted to set up an array for stop conditions for the while
                                                 // loop.(DOESN'T WORK)

        // Processing Phase
        do {
            diceSum = 0; // diceSum MUST be zero otherwise it'll continuously fail when the player wants
                         // to play again.

            while (!(diceSum == 2 || diceSum == 3 || diceSum == 7 || diceSum == 11 || diceSum == 12)) {
                System.out.println("Roll\t Die01\t Die02\t DiceSum");
                System.out.println("---------------------------------");
                die01 = rnd.nextInt(6) + 1;
                die02 = rnd.nextInt(6) + 1;
                diceSum = die01 + die02;
                rollCount++;
                points++;

                System.out.printf("%-4d\t%-4d\t%-4d\t%-4d\n", rollCount, die01, die02, diceSum);

            }

            if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
                System.out.println("Looks like you lost with a: \t" + diceSum);
                System.out.println("Would you like to play again Y/N \n");
                String input = scanner.next().toLowerCase();
                playAgain = input.equals("y");

            } else if (diceSum == 7 || diceSum == 11) {
                System.out.println("Congrats, you won with a: \t" + diceSum);
                System.out.println("So, would you like to play again: Y/N \n");
                String input = scanner.next().toLowerCase(); // Have to use to LowerCase to make life easier.
                playAgain = input.equals("y");

            } else {
                System.out.println("Not sure how you got here lol.");
                System.out.println("Anyways, would you like to play again: Y/N \n");
                String input = scanner.next().toLowerCase();
                playAgain = input.equals("y");
            }
            System.out.println("Thanks for playing!");

        } while (playAgain);
    }

}
