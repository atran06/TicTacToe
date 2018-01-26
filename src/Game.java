
public class Game {

	int ent;
	int player;
	
	public Game(int ent, int player) {
		this.ent = ent;
		this.player = player;
		
		populate();
		print();
	}
	public static boolean win() {
		
		/*
		 * This method uses a double for loop to check every possible win scenario
		 * then return true or false if someone wins or doesn't win
		 * 
		 * Not really the prettiest way to do this but it works :).
		 */
		
		for(int i = 0; i < Runner.arr.length; i++) {
			for(int x = 0; x < Runner.arr[0].length; x++) {
				if(i == 0) {
					if(x == 0) {
						if(Runner.arr[i][x].equals("x")) {
							if(Runner.arr[i][x + 1].equals("x") && Runner.arr[i][x + 2].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							} else if(Runner.arr[i + 1][x].equals("x") && Runner.arr[i + 2][x].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							} else if(Runner.arr[i + 1][x + 1].equals("x") && Runner.arr[i + 2][x + 2].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							}
						} else if(Runner.arr[i][x].equals("o")) {
							if(Runner.arr[i][x + 1].equals("o") && Runner.arr[i][x + 2].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							} else if(Runner.arr[i + 1][x].equals("o") && Runner.arr[i + 2][x].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							} else if(Runner.arr[i + 1][x + 1].equals("o") && Runner.arr[i + 2][x + 2].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							}
						} 
					} else if(x == 1) {
						if(Runner.arr[i][x].equals("x")) {
							if(Runner.arr[i + 1][x].equals("x") && Runner.arr[i + 2][x].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							}
						} else if(Runner.arr[i][x].equals("o")) {
							if(Runner.arr[i + 1][x].equals("o") && Runner.arr[i + 2][x].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							}
						}
					} else if(x == 2) {
						if(Runner.arr[i][x].equals("x")) {
							if(Runner.arr[i + 1][x - 1].equals("x") && Runner.arr[i + 2][x - 2].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							}
						} else if(Runner.arr[i][x].equals("o")) {
							if(Runner.arr[i + 1][x - 1].equals("o") && Runner.arr[i + 2][x - 2].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							}
						}
					}
				} else if(i == 2) {
					if(x == 2) {
						if(Runner.arr[i][x].equals("x")) {
							if(Runner.arr[i - 1][x].equals("x") && Runner.arr[i - 2][x].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							} else if(Runner.arr[i][x - 1].equals("x") && Runner.arr[i][x - 2].equals("x")) {
								System.out.println("Player 1 wins!");
								return true;
							}
						} else if(Runner.arr[i][x].equals("o")) {
							if(Runner.arr[i - 1][x].equals("o") && Runner.arr[i - 2][x].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							} else if(Runner.arr[i][x - 1].equals("o") && Runner.arr[i][x - 2].equals("o")) {
								System.out.println("Player 2 wins!");
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * This method just populates the array 
	 */
	public void populate() {
		int row = 0;
		String xo = "o";
		
		/*
		 * All of this just makes populating easier by setting the 
		 * row the number is on and sets a space of 1-3
		 */
		
		if(ent <= 3) {
			row = 0;
		} else if(ent <= 6 && ent > 3) {
			row = 1;
			ent -= 3;
		} else if(ent <= 9 && ent > 6) {
			row = 2;
			ent -= 6;
		}
		if(player == 1) {
			xo = "x";
		} else if(player == 2) {
			xo = "o";
		}
		Runner.arr[row][ent - 1] = xo;
		
	}
	
	/*
	 * This method uses a double for loop to print each row
	 * then column
	 */
	
	public static void print() {
		int row = 0;
		
		for(int i = 0; i < Runner.arr.length; i++) {
			for(int x = 0; x < Runner.arr[0].length; x++) {
				if(x == 2) {
					System.out.print(Runner.arr[i][x]);
				} else {
					System.out.print(Runner.arr[i][x] + " | ");					
				}
			}
			if(i == 2) {
				System.out.println("");
			} else {
				System.out.println("\n---------");				
			}
		}
	}
}
