import javax.swing.*;

public class Square {

	private ImageIcon icon;
	private Location myLocation;
	// the side length of a Square
	public static final int SIDE = 30;

	/**
	 * the default Square is a red square in the center of the top of the board
	 */
	public Square() {
		myLocation = new Location(Location.X_MAX / 2, 0);
		icon = new ImageIcon("./src/image/1.png");
	}

	/**
	 * creates a Square with the specified location and image
	 *
	 * @param x
	 *            the initial horizontal location
	 * @param y
	 *            the initial vertical location
	 * @param icon
	 *            a 30*30 image of a square
	 */
	public Square(int x, int y, ImageIcon icon) {
		myLocation = new Location(x, y);
		this.icon = icon;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public Location getMyLocation() {
		return myLocation;
	}
}
