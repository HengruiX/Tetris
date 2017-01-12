import java.awt.event.*;

public class Controller {

	public Board board;
	public Game game;
	public ScorePanel scorePanel;
	private KeyListener leftRightListener, downListener, upListener, pauseListener;
	private ActionListener fallListener, clearListener;
	private Handler handler;

	public Controller() {
		Stats stats = new Stats();
		leftRightListener = new LeftRightListener();
		downListener = new DownListener();
		upListener = new UpListener();
		pauseListener = new PauseListener();
		fallListener = new FallListener();
		clearListener = new ClearListener();
		handler = new Handler();

		game = new Game(stats, handler);
		board = new Board(leftRightListener, downListener, upListener, pauseListener, fallListener, clearListener,
				game.patterns);
		scorePanel = new ScorePanel(stats);
		handler.setDifficulty(game.getDifficulty());

		System.out.println("a controller is created");
	}

	class Handler {
		public void repaint() {
			board.repaint();
		}

		public void haltTime() {
			board.timer.stop();
			board.clearTimer.stop();
		}

		public void resumeTime() {
			board.timer.restart();
			board.clearTimer.restart();
		}

		public boolean timeIsRunning() {
			return board.timer.isRunning();
		}

		public void setDifficulty(int d) {
			board.setDifficulty(d);
		}
	}

	class LeftRightListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				game.moveLeft();
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				game.moveRight();

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	class DownListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				game.moveDown();
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	class UpListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				game.turn();
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	class PauseListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_P)
				game.pause();
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	class FallListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			game.fall();
		}
	}

	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			game.clearPatterns();
		}
	}

}
