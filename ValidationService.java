/**
 * Handles validation of user input
 * before it is used in game logic.
 * 
 * All input checks are centralized here to maintain
 * clean separation of concerns and improve code maintainability.
 */

public class ValidationService {

    /**
     * Validates that the input is an integer within the specified range (1-100).
     * @param input
     * @return
     * @throws InvalidInputException
     */
    public static int validateInput(String input) throws InvalidInputException{
        try{
            int value = Integer.parseInt(input);

            if (value < 1 || value > 100){
                throw new InvalidInputException("Input must be between 1 and 100.");
            }
            return value;
        }
        catch(NumberFormatException e){
            throw new InvalidInputException("Input must be a valid integer.");
        }
    }
}