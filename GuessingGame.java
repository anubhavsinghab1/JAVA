package JAVA;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int closenessThreshold = 5; // Adjust this value to control the closeness range

        Scanner scanner = new Scanner(System.in);
        int totalScore = 0; // Track overall score across rounds
        int roundsPlayed = 0; // Count the number of rounds played

        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;
            int score = 0; // Score for the current round
            int attempts = 0;
            int maxAttempts = 5;
            int randomNumber = random.nextInt(100) + 1;

            System.out.println("\nRound " + roundsPlayed + "!");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Guess a number between 1 and 100 (Attempts: " + attempts + "): ");
                int guess = scanner.nextInt();

                int difference = Math.abs(guess - randomNumber);

                if (guess < randomNumber) {
                    if (difference <= closenessThreshold) {
                        System.out.println("Too low, but you're very close!");
                        score += 3; // Bonus for being close
                    } else {
                        System.out.println("Too low!");
                    }
                } else if (guess > randomNumber) {
                    if (difference <= closenessThreshold) {
                        System.out.println("Too high, but you're very close!");
                        score += 3; // Bonus for being close
                    } else {
                        System.out.println("Too high!");
                    }
                } else {
                    System.out.println("Congratulations! You guessed correctly.");
                    score += maxAttempts - attempts + 1; // Bonus points for fewer attempts
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("You ran out of guesses. The number was: " + randomNumber);
            }

            totalScore = score; // Add round score to total score

            System.out.println("Round Score: " + score);

            System.out.print("Play again? (yes/no): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! Your final score is: " + totalScore + " after " + roundsPlayed + " rounds.");
    }
}