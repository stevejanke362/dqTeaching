package main;

import java.util.HashMap;
import java.util.Map;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

/**
 * 
 * The abstraction of the game board.
 * 
 * @author Stephen Janke
 *
 */
public class Board {

	public static final int ROWS = 10;
	public static final int COLUMNS = 13;

	private Map<Coordinate, BoardSpace> spaceLookup = new HashMap<>();

	private MutableGraph<BoardSpace> boardGraph = GraphBuilder.undirected().allowsSelfLoops(false)
			.expectedNodeCount(COLUMNS * ROWS).build();

	private boolean isTower(Coordinate coordinate) {
		final int r = coordinate.getRow();
		final int c = coordinate.getCol();
		return //
		((r == 0) && (c == 0)) || //
				((r == 0) && (c == (COLUMNS - 1))) || //
				((r == (ROWS - 1)) && (c == (COLUMNS - 1))) || //
				((r == (ROWS - 1)) && (c == (COLUMNS - 1)));
	}

	private boolean isTreasureChamber(int r, int c) {
		return (((r == 4) && (c == 6)) || ((r == 5) && (c == 6)));
	}

	public Board() {
		super();

		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {

				Coordinate newNodeCoordinate = new Coordinate(r, c);

				BoardSpace newSpace = null;
				if (isTower(newNodeCoordinate)) {
					newSpace = new TowerSquare(newNodeCoordinate);
				} else if (!isTreasureChamber(r, c)) {
					newSpace = new TileBoardSpace(newNodeCoordinate);
				}

				boardGraph.addNode(newSpace);
				spaceLookup.put(newNodeCoordinate, newSpace);

				// up hook
				if (isTopRow(newNodeCoordinate)) {

				} else {
					Coordinate upOne = newNodeCoordinate.above();
					BoardSpace spaceUpOne = spaceLookup.get(upOne);
					boardGraph.putEdge(newSpace, spaceUpOne);

				}
				if (isBottomRow(newNodeCoordinate)) {

				} else {
					Coordinate downOne = newNodeCoordinate.below();
					BoardSpace spaceDownOne = spaceLookup.get(downOne);
					boardGraph.putEdge(newSpace, spaceDownOne);

				}
				if (isFarLeftColumn(newNodeCoordinate)) {

				} else {
					Coordinate leftOne = newNodeCoordinate.left();
					BoardSpace spaceLeftOne = spaceLookup.get(leftOne);
					boardGraph.putEdge(newSpace, spaceLeftOne);
				}
				if (isFarRightColumn(newNodeCoordinate)) {

				} else {
					Coordinate rightOne = newNodeCoordinate.right();
					BoardSpace spaceRightOne = spaceLookup.get(rightOne);
					boardGraph.putEdge(newSpace, spaceRightOne);
				}

				// if we're on the top row, then there is no row above us
				// if we're not on the top row, then there is a row above
				// us, and connect to the square immediately above me
				// if we're on the first column, then there is no column
				// behind us
				// if we're not on the first column, then there is a column
				// behind us, and connect to the square immediately behind
				// me

				// if i am square (r,c) and i want to connect to the square
				// above me, find the square at (r-1,c)
				// if i am square (r,c) and i want to connect to the square
				// behind me, find the square at (r,c-1)

				// to find a square at (r,c), use findAt()

				// when we find the square to connect to, add an edge
				// between them

			}
		}

		boardGraph.addNode(new TreasureSquare());
	}

	private boolean isFarRightColumn(Coordinate newNodeCoordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isFarLeftColumn(Coordinate newNodeCoordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isBottomRow(Coordinate newNodeCoordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isTopRow(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}

}
