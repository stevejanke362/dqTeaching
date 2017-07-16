package main;

public abstract class AbstractCoordinateBoardSpace implements CoordinateBoardSpace {

	private final Coordinate coordinate;

	public AbstractCoordinateBoardSpace(Coordinate coordinate) {
		super();
		this.coordinate = coordinate;
	}

	@Override
	public int getRowCoordinate() {
		return coordinate.getRow();
	}

	@Override
	public int getColumnCoordinate() {
		return coordinate.getCol();
	}

}
