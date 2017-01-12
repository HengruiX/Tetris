import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Displayer {

	public static int total = 0;

	public Displayer() {

		total = 0;

		JFrame frame = new JFrame("welcome");
		JPanel panel = new JPanel();
		JButton button = new JButton("start");
		JLabel label = new JLabel("                    Tetris");

		label.setFont(new Font("Arial", Font.BOLD, 40));
		button.setFont(new Font("Arial", Font.ITALIC, 20));

		panel.setBackground(Color.CYAN);
		panel.setLayout(new BorderLayout());

		panel.add(label, BorderLayout.NORTH);
		panel.add(button, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(550, 300));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		StartListener listener = new StartListener();
		button.addActionListener(listener);

		// RepaintManager.currentManager(frame.getRootPane()).setDoubleBufferingEnabled(false);
		// ((JComponent)
		// frame.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);

	}

	public static void play() {

		Controller controller = new Controller();

		JFrame frame = new JFrame("game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel primary = new JPanel();

		frame.getContentPane().add(primary);
		primary.setPreferredSize(
				new Dimension(Location.X_MAX + Square.SIDE, Location.Y_MAX + Square.SIDE + ScorePanel.HEIGHT));
		primary.add(controller.board);
		primary.add(controller.scorePanel);
		frame.pack();
		frame.setBackground(Color.CYAN);
		frame.setVisible(true);
	}

	private class StartListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			play();
		}
	}

}
