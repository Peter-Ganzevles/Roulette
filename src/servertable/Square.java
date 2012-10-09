package servertable;

public class Square {
	private int number;
	private int color;
	
	public Square(int number, int color) {
		this.number = number;
		this.color = color;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public boolean equals(Square square) {
		return (square.getNumber() == number && square.getColor() == color);
	}
}
