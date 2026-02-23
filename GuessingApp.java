/**
 * Use Case 3: Hint Generation
 * Generating controlled hints based on the number of incorrect attempts made by the player.
 * 
 * @author Developer
 * @version 3.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game!");
        GameConfig config = new GameConfig();
        HintService hs = new HintService();
        config.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while(attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            System.out.println(result);

            if("Correct!".equals(result)){
                break;
            }
            if(attempts == 1 || attempts == 2){
                System.out.println(hs.generateHint(config.getTargetNumber(), attempts));
            }
        }
    }
}