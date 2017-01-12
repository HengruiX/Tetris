import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;

public class Board extends JPanel {

	public Timer timer, clearTimer;
	private static final int DELAY = 20, CLEAR_DELAY = 1000;
	private List<Pattern> patterns;

	public Board(KeyListener leftRightListener, KeyListener downListener, KeyListener upListener,
			KeyListener pauseListener, ActionListener fallListener, ActionListener clearListener,
			List<Pattern> patterns) {

		this.patterns = patterns;

		addKeyListener(leftRightListener);
		addKeyListener(downListener);
		addKeyListener(upListener);
		addKeyListener(pauseListener);
		timer = new Timer(DELAY, fallListener);
		clearTimer = new Timer(CLEAR_DELAY, clearListener);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Location.X_MAX + Square.SIDE, Location.Y_MAX + Square.SIDE));

		setFocusable(true);
		timer.start();
		clearTimer.start();

		System.out.println("a board is created");
		System.out.println(patterns.isEmpty());
	}

	public void paint(Graphics page) {
		super.paint(page);
		for (Pattern p : patterns) {
			for (Square s : p.fourSquares) {
				s.getIcon().paintIcon(this, page, s.getMyLocation().getX(), s.getMyLocation().getY());
			}
			page.setColor(Color.BLACK);
		}
	}

	public void setDifficulty(int difficulty) {
		timer.setDelay(DELAY / difficulty);
	}

}
