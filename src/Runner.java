import java.util.Scanner;

/*
 * Arthur Tran, Angelo Arriaga, Parth Mehta
 * 
 * Period 5
 * 
 * 1-21-18
 */

public class Runner {

	////Populating the array initially with numbers////
	public static String[][] arr = { { Integer.toString(1), Integer.toString(2), Integer.toString(3) },
			{ Integer.toString(4), Integer.toString(5), Integer.toString(6) },
			{ Integer.toString(7), Integer.toString(8), Integer.toString(9) } };
	//////////////////////////////////////////////////
	
	private static int ent;
	private static int turns = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int player = 1;

		Game.print(); // Prints the gameboard once initially

		/*
		 * Main "game loop" that handles player input and checks if
		 * win is true or tie is true.
		 * 
		 * Also has a thing that test the input to see if its a valid one
		 */
		
		while (true) {

			if (Game.win()) {
				break;
				
			} else if(turns == 9) {
				System.out.println("It's a tie!");
				break;
				
			} else {
				System.out.println("\nEnter a number for player " + player);

				while (true) {

					try { //incase input isnt an int
						ent = input.nextInt();
					} catch(Exception e) {
						input.next();
					}
					int ent2 = ent;
					int row = 0;

					////making the populating of the array easier////
					if (ent <= 3) {
						row = 0;
					} else if (ent > 3 && ent <= 6) {
						row = 1;
						ent2 -= 3;
					} else if (ent > 6 && ent <= 9) {
						row = 2;
						ent2 -= 6;
					}
					////////////////////////////////////////////////
					
					if (ent > 9 || ent <= 0) {
						System.out.println("Invalid input try again");

					} else if (arr[row][ent2 - 1].equals("o") || arr[row][ent2 - 1].equals("x")) {
						System.out.println("Spot taken");

					} else {
						new Game(ent, player); //Calls to the game class which handles populating the array

						////Switches between players////
						if (player == 1) {
							player++;
						} else {
							player--;
						}
						break;
						////////////////////////////////
					}
				}
			}
			turns++;
		}
	}
}
