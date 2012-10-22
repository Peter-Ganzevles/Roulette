package servertable;

public class Game {
	private static Table[] tables = new Table[6];
	
	public static final void main(String[] args) {
		
	}
	
	public static Table getTable(int tablenr) {
		return tables[tablenr];
	}
	
}
