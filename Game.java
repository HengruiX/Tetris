import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

	private static final int INC = Square.SIDE, LITTLE_INC = 1;

	private static final int TOLERANCE = 10;
	private Stats myStats;
	public List<Pattern> patterns = new ArrayList<>();
	private int current;
	private Controller.Handler handler;

	public Game(Stats stats, Controller.Handler handler) {
		this.handler = handler;
		myStats = stats;
		patterns.add(Pattern.getRand());
		current = 0;
		System.out.println("a game is created");
	}

	public int getDifficulty() {
		return myStats.getDifficulty();
	}

	/**
	 * check whether a Square object's location is out of the soft boundary
	 * always follow the method call: eliminate();
	 *
	 * @return whether the game has been lost
	 */
	private boolean isLose() {
		for (Pattern p : patterns) {
			for (Square s : p.fourSquares) {
				if (s.getMyLocation().getY() == Location.Y_MIN)
					return true;
			}
		}
		return false;
	}

	/**
	 * show "You lose." message and restart the game if the game has been lost
	 *
	 * @return whether the game has been lost (invokes isLose())
	 */
	private boolean checkLost() {
		if (isLose()) {
			handler.haltTime();
			JOptionPane.showMessageDialog(null, "You lose.");
			JOptionPane.showMessageDialog(null, "Congrats, " + myStats.getPlayerName() + ", your final score is "
					+ (myStats.getScore() * myStats.getDifficulty()));
			int ans = JOptionPane.showConfirmDialog(null, "wanna try again?");
			if (ans == JOptionPane.YES_OPTION) {
				myStats.reset();
				handler.setDifficulty(myStats.getDifficulty());
				patterns.clear();
				patterns.add(Pattern.getRand());
				current = 0;
				handler.resumeTime();
			} else {
				System.exit(1);
			}
		}
		return isLose();
	}

	// private void addPattern(){
	// patterns.add(Pattern.getRand());
	// current = patterns.size() - 1;
	// }

	/**
	 * @param pos
	 *            the vertical position that the method checks
	 * @return whether the Square objects has filled the row at vertical
	 *         position pos
	 */
	private boolean isFull(int pos) {

		int count = 0;

		for (Pattern p : patterns) {
			for (Square s : p.fourSquares) {
				if (s.getMyLocation().getY() == pos) {
					count++;
				}
			}
		}

		return count == Location.X_MAX / Square.SIDE + 1;
	}

	private boolean eliminatable() {
		for (int pos = Location.Y_MAX; pos > 0; pos -= Square.SIDE) {
			if (isFull(pos))
				return true;
		}
		return false;
	}

	private void eliminate() {
		List<Integer> eliminated = new ArrayList<>();
		for (int pos = Location.Y_MAX; pos > 0; pos -= Square.SIDE) {
			if (isFull(pos)) {
				eliminated.add(pos);
				myStats.increaseScore(5);
				Iterator<Pattern> itr1 = patterns.iterator();
				while (itr1.hasNext()) {
					Pattern nextPattern = itr1.next();
					Iterator<Square> sub_itr1 = nextPattern.fourSquares.iterator();
					while (sub_itr1.hasNext()) {
						if (sub_itr1.next().getMyLocation().getY() == pos) {
							sub_itr1.remove();
						}
					}
				}
			}
		}
		assert !eliminatable();
		current = patterns.size() - 1;
		if (!patterns.isEmpty()) {

			for (int pos = Location.Y_MAX; pos >= 0; pos -= Square.SIDE) {

				int down = 0;
				for (int line : eliminated) {
					if (pos < line) {
						down++;
					}
				}

				for (Pattern p : patterns) {

					boolean atPos = false;

					if (!p.fourSquares.isEmpty()) {
						int largestY = Location.Y_MIN;
						for (Square s : p.fourSquares) {
							largestY = (largestY > s.getMyLocation().getY()) ? largestY : s.getMyLocation().getY();
						}
						atPos = largestY == pos;
					}

					if (atPos) {
						p.move(0, down * Square.SIDE);
					}
				}
			}
		}
		handler.repaint();
	}

	private int getVerticalDistance(Square currentSquare, Pattern currentPattern) {

		int x = currentSquare.getMyLocation().getX();
		int y = currentSquare.getMyLocation().getY();

		int result = Location.Y_MAX - y;

		for (Pattern p : patterns) {
			if (!p.fourSquares.isEmpty() && p != currentPattern) {
				for (Square s : p.fourSquares) {
					if (s != currentSquare && s.getMyLocation().getX() == x
							&& s.getMyLocation().getY() - Square.SIDE - y < result
							&& s.getMyLocation().getY() - Square.SIDE - y >= 0) {
						result = s.getMyLocation().getY() - Square.SIDE - y;
					}

				}
			}
		}
		return result;
	}

	private int getVerticalDistance(Pattern pattern) {
		if (pattern.fourSquares.isEmpty()) {
			return 0;
		}
		int result = Location.Y_MAX;
		for (Square square : pattern.fourSquares) {
			int temp = getVerticalDistance(square, pattern);
			result = (result < temp) ? result : temp;
		}
		return result;
	}

	private boolean leftIsEmpty() {

		Pattern currentPattern = patterns.get(current);
		if (patterns.isEmpty() || currentPattern.fourSquares.isEmpty()) {
			return false;
		} else {
			for (Square currentSquare : currentPattern.fourSquares) {

				int x = currentSquare.getMyLocation().getX();
				int y = currentSquare.getMyLocation().getY();

				for (Pattern p : patterns)
					if (p != currentPattern && !p.fourSquares.isEmpty()) {
						for (Square s : p.fourSquares) {
							if (s.getMyLocation().getX() == x - Square.SIDE
									&& s.getMyLocation().getY() - y < Square.SIDE
									&& y - s.getMyLocation().getY() < Square.SIDE - TOLERANCE) {
								return false;
							}
						}
					}

				if (x <= Location.X_MIN) {
					return false;
				}
			}
		}

		return true;
	}

	// @return whether the current pattern can move to the right
	private boolean rightIsEmpty() {

		Pattern currentPattern = patterns.get(current);
		if (patterns.isEmpty() || currentPattern.fourSquares.isEmpty()) {
			return false;
		} else {
			for (Square currentSquare : currentPattern.fourSquares) {

				int x = currentSquare.getMyLocation().getX();
				int y = currentSquare.getMyLocation().getY();

				for (Pattern p : patterns)
					if (p != currentPattern && !p.fourSquares.isEmpty()) {
						for (Square s : p.fourSquares) {
							if (s.getMyLocation().getX() == x + Square.SIDE
									&& s.getMyLocation().getY() - y < Square.SIDE
									&& y - s.getMyLocation().getY() < Square.SIDE) {
								return false;
							}
						}
					}

				if (x >= Location.X_MAX) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * @return whether the current pattern can still move
	 */
	private boolean shouldStop() {
		Pattern currentPattern = patterns.get(current);
		boolean stop = false;

		// currentPattern should not move if it does not have any square
		if (currentPattern.fourSquares.isEmpty()) {
			stop = true;
		}

		// check if any of the squares in currentPattern.fourSquares has reached
		// bottom or another square that
		// is in another pattern
		else {
			for (Square currentSquare : currentPattern.fourSquares) {
				for (Pattern p : patterns) {
					if (p != currentPattern && !p.fourSquares.isEmpty()) {
						for (Square s : p.fourSquares) {
							if (currentSquare.getMyLocation().getX() == s.getMyLocation().getX()
									&& currentSquare.getMyLocation().getY() + Square.SIDE == s.getMyLocation().getY()) {
								stop = true;
							}
						}
					}
				}
				if (currentSquare.getMyLocation().getY() == Location.Y_MAX) {
					stop = true;
				}
			}
		}
		return stop;
	}

	private boolean rightTurnable(Pattern pattern) {
		if (pattern.fourSquares.isEmpty()) {
			return false;
		}
		boolean result = true;
		pattern.turn('R');
		for (Square square : pattern.fourSquares) {
			for (Pattern p : patterns) {
				if (!p.fourSquares.isEmpty() && p != pattern) {
					for (Square s : p.fourSquares) {
						if (Math.abs(s.getMyLocation().getX() - square.getMyLocation().getX()) < Square.SIDE
								&& Math.abs(s.getMyLocation().getY() - square.getMyLocation().getY()) < Square.SIDE) {
							result = false;
						}
					}
				}
			}
		}
		pattern.turn('L');
		return result;
	}

	public void moveLeft() {
		if (leftIsEmpty())
			patterns.get(current).move(-INC, 0);
		handler.repaint();
	}

	public void moveRight() {
		if (rightIsEmpty())
			patterns.get(current).move(INC, 0);
		handler.repaint();
	}

	public void moveDown() {
		if (shouldStop()) {
			eliminate();
			if (!checkLost()) {
				patterns.add(Pattern.getRand());
				current++;
				myStats.increaseScore(1);
			}
		} else {
			patterns.get(current).move(0, getVerticalDistance(patterns.get(current)));
		}
		handler.repaint();
	}

	public void fall() {
		if (shouldStop()) {
			eliminate();
			if (!checkLost()) {
				patterns.add(Pattern.getRand());
				current++;
				myStats.increaseScore(1);
			}
		} else {
			patterns.get(current).move(0, LITTLE_INC);

		}
		handler.repaint();
	}

	public void turn() {
		if (rightTurnable(patterns.get(current)))
			patterns.get(current).turn('R');
		handler.repaint();
	}

	public void clearPatterns() {
		Iterator<Pattern> itr = patterns.iterator();
		while (itr.hasNext()) {
			if (itr.next().fourSquares.isEmpty()) {
				itr.remove();
			}
		}

		current = patterns.size() - 1;
		handler.repaint();
	}

	public void pause() {
		if (handler.timeIsRunning())

		{
			handler.haltTime();
			int ans = JOptionPane.NO_OPTION;
			while (ans != JOptionPane.YES_OPTION) {
				ans = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
			}
			handler.resumeTime();
		}
	}
}
