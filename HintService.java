/**
 * Use Case 3: Hint Generation
 * 
 * This class is responsible for generating
 * controlled hints ased on the number of 
 * incorrect attempts made by the player.
 * 
 * Hint logic s isolated to avoid cluttering the main game flow.

 */

public class HintService{
    public static String generateHint(int t, int hintC){
        if(hintC == 1){
            return (t%2 ==0)
                ? "Hint: The number is even."
                : "Hint: The number is odd.";
        }
        else if(hintC ==2){
            return (t>50)
                ? "Hint: The number is greater than 50."
                : "Hint: The number is less than or equal to 50.";
        }
        return "No more hints available.";
    }
}