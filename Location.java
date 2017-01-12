/**
 * represents a location on the board
 */
public class Location {

	private int x;
	private int y;
	// soft boundary: the location can exceed
	static final int Y_MIN = 0;
	// hard boundaries: the location cannot exceed
	static final int X_MIN = 0, X_MAX = 600, Y_MAX = 480;

	/**
	 * initializes the location
	 *
	 * @param horizontal
	 *            the initial horizontal location
	 * @param vertical
	 *            the initial vertical location
	 * @throws IllegalArgumentException
	 *             when the horizontal/vertical location is out of the hard
	 *             boundaries
	 */
	public Location(int horizontal, int vertical) throws IllegalArgumentException {

		if (horizontal >= X_MIN && horizontal <= X_MAX) {
			x = horizontal;
		} else {
			throw new IllegalArgumentException("not a valid location");
		}

		if (vertical <= Y_MAX) {
			y = vertical;
		} else {
			throw new IllegalArgumentException("not a valid location");
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * move the location, move the location to the boundary if the arguments
	 * attempt to move the location beyond the hard boundaries
	 *
	 * @param xInc
	 *            the movement along the horizontal direction
	 * @param yInc
	 *            the movement along the vertical direction
	 */
	public void move(int xInc, int yInc) {
		x += xInc;
		y += yInc;

		x = (x > X_MIN) ? x : X_MIN;
		x = (x < X_MAX) ? x : X_MAX;
		y = (y < Y_MAX) ? y : Y_MAX;
	}
}
