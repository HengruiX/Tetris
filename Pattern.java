import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Pattern {

	public List<Square> fourSquares = new ArrayList<>();
	public Location reference;
	private URL url1 = getClass().getResource("image/1.png");
	private URL url2 = getClass().getResource("image/2.png");
	private URL url3 = getClass().getResource("image/3.png");
	private URL url4 = getClass().getResource("image/4.png");
	private URL url5 = getClass().getResource("image/5.png");
	private URL url6 = getClass().getResource("image/6.png");
	private URL url7 = getClass().getResource("image/7.png");

	/**
	 *
	 * @param pattern
	 *            the number associated with the specified pattern: Pattern 1: #
	 *            # # #
	 *
	 *            Pattern 2: # # # #
	 *
	 *            Pattern 3: # # # #
	 *
	 *            Pattern 4: # # # #
	 *
	 *            Pattern 5: # # # #
	 *
	 *            Pattern 6: # # # #
	 *
	 *            Pattern 7 (default): # # # #
	 */
	private Pattern(int pattern) {

		switch (pattern) {
		case 1:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 0 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 2 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url1)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url1)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url1)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url1)));
			break;
		case 2:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url2)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url2)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url2)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url2)));
			break;
		case 3:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url3)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url3)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url3)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url3)));
			break;
		case 4:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url4)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url4)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url4)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url4)));
			break;
		case 5:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url5)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url5)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url5)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url5)));
			break;
		case 6:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url6)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url6)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url6)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url6)));
			break;
		case 7:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url7)));
			break;
		default:
			reference = new Location(Location.X_MAX / 2, Location.Y_MIN - 1 * Square.SIDE);
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 1 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 - 0 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url7)));
			fourSquares.add(new Square(Location.X_MAX / 2 + 1 * Square.SIDE, Location.Y_MIN - 0 * Square.SIDE,
					new ImageIcon(url7)));
		}
	}

	/**
	 *
	 * @return a random initialized pattern
	 */
	public static Pattern getRand() {
		int num = (int) (Math.random() * 7) + 1;
		return new Pattern(num);
	}

	/**
	 * move all squares in the pattern if there is any
	 *
	 * @param x
	 *            the movement in the horizontal direction
	 * @param y
	 *            the movement in the horizontal direction
	 */
	public void move(int x, int y) {
		if (!fourSquares.isEmpty()) {
			for (Square square : fourSquares) {
				square.getMyLocation().move(x, y);
			}
		}
		reference.move(x, y);
	}

	private void rightTurn() {
		if (!fourSquares.isEmpty()) {
			for (Square square : fourSquares) {
				int x = square.getMyLocation().getX();
				int y = square.getMyLocation().getY();
				int x_r = reference.getX();
				int y_r = reference.getY();

				square.getMyLocation().move(y_r - y + x_r - x, x - x_r + y_r - y);

			}
		}
	}

	private void leftTurn() {
		if (!fourSquares.isEmpty()) {
			for (Square square : fourSquares) {
				int x = square.getMyLocation().getX();
				int y = square.getMyLocation().getY();
				int x_r = reference.getX();
				int y_r = reference.getY();

				square.getMyLocation().move(y - y_r + x_r - x, x_r - x + y_r - y);

			}
		}
	}

	/**
	 *
	 * @param direction
	 *            the direction that the pattern should turn 'R' for clockwise
	 *            'L' for counterclockwise
	 */
	public void turn(char direction) {
		switch (direction) {
		case 'L':
			leftTurn();
			break;
		case 'R':
			rightTurn();
			break;
		}
	}
}
