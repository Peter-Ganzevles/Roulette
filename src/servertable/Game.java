package servertable;

public class Game {
	private Table[] tables = new Table[6];
	

	public Table getTable(int tablenr) {
		return tables[tablenr];
	}
	
}
