/*
* Handles game lifecycle decision.
*
* This class is responsible for deciding
* whethere the game should restart or exit
* based on user choice.
*/
import java.util.*;

class GameController {
	/*
	* Ask the player if they want to
	* restart the game after completion
	* 
	* Returns true if the game should restart,
	* flase if the application should exit.
	*/
	
	public static boolean restartGame(Scanner scanner) {
		System.out.print("DO you want to play again? (yes/no): ");
		return scanner.nextLine().equalsIgnoreCase("yes");
	}
}