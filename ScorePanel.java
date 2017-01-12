import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henryxing on 31/5/2016.
 */
public class ScorePanel extends JPanel {

	private Stats myStats;
	private Timer timer;
	public static final int DELAY = 5, HEIGHT = 100;

	public ScorePanel(Stats stats) {
		myStats = stats;

		timer = new Timer(DELAY / stats.getDifficulty(), new UpdateListener());

		setBackground(Color.CYAN);
		setPreferredSize(new Dimension(Location.X_MAX + Square.SIDE, HEIGHT));

		timer.start();
	}

	private class UpdateListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			repaint();
		}
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setFont(new Font("Arial", Font.BOLD, 20));
		page.drawString("Your name is: " + myStats.getPlayerName(), 20, 30);
		page.drawString("Your score is: " + (myStats.getScore() * myStats.getDifficulty()), 20, 70);
	}
}
