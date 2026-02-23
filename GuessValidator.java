public class GuessValidator {
    public static String validateGuess(int guess, int target) {
        if (guess < target) {
            return "Too low!";
        } else if (guess > target) {
            return "Too high!";
        } else {
            return "Correct!";
        }
        
    }
}