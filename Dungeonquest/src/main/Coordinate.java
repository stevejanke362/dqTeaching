package main;

public class Coordinate {
	private final int row;
	private final int col;

	public Coordinate(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public Coordinate above() {
		return new Coordinate(this.row - 1, this.col);
	}

	public Coordinate below() {
		return new Coordinate(this.row + 1, this.col);
	}

	public Coordinate left() {
		return new Coordinate(this.row, this.col - 1);
	}

	public Coordinate right() {
		return new Coordinate(this.row, this.col + 1);
	}

}
