import java.util.Scanner;

public class Runner {

	public static String[][] arr = { { Integer.toString(1), Integer.toString(2), Integer.toString(3) },
			{ Integer.toString(4), Integer.toString(5), Integer.toString(6) },
			{ Integer.toString(7), Integer.toString(8), Integer.toString(9) } };
	private static int ent;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int player = 1;

		Game.print();

		while (true) {

			if (Game.win()) {
				break;
			} else {
				System.out.println("\nEnter a number for player " + player);

				while (true) {

					ent = input.nextInt();
					int ent2 = ent;
					int row = 0;

					if (ent <= 3) {
						row = 0;
					} else if (ent > 3 && ent <= 6) {
						row = 1;
						ent2 -= 3;
					} else if (ent > 6 && ent <= 9) {
						row = 2;
						ent2 -= 6;
					}
					if (ent > 9 || ent <= 0) {
						System.out.println("Invalid input try again");

					} else if (arr[row][ent2 - 1].equals("o") || arr[row][ent2 - 1].equals("x")) {
						System.out.println("Spot taken");

					} else {
						new Game(ent, player);

						if (player == 1) {
							player++;
						} else {
							player--;
						}
						break;
					}
				}
			}
		}
	}
}
