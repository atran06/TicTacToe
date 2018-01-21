
public class Game {

	int ent;
	int player;
	
	public Game(int ent, int player) {
		this.ent = ent;
		this.player = player;
		
		logic();
		win();
		print();
	}
	public static boolean win() {
		 return false;
	}
	public void logic() {
		int row = 0;
		String xo = "o";
		
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
