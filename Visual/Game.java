package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Creeps.Goli;
import Logics.Board;
import Logics.Coordinate;
import Logics.Level;
import Logics.Tickable;
import Logics.Wave;

public class Game extends JFrame implements Tickable,ActionListener{
	protected Board board;
	private VisualBoard visBoard;
	private JButton nextWave;
	private JButton x2Speed;
	private JButton Restart;
	private JButton Return;
	private JLabel Lives;
	private JLabel currentWave;
	private JLabel time;
	protected double elapsedTime;
	private int currLevel;
	
	public Game(int levelNum){
		currLevel=levelNum;
		this.setTitle("Level " +levelNum);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,900));
		this.setResizable(false);
		Level level = new Level(levelNum);
		board = new Board(level,this);
		board.setGame(this);
		initComponents();
		this.setVisible(true);
		this.pack();
	}
	
	private void initComponents(){
		visBoard = new VisualBoard(board);
		visBoard.setBounds(0,100,800,800);
		nextWave = new JButton("<html>Next<br> Wave</html>");
		nextWave.setFont(new Font("Serif", Font.PLAIN, 22));
		nextWave.setBounds(0,0,100,100);
		nextWave.addActionListener(this);
		x2Speed = new JButton("<html>Double <br> Speed</html>");
		x2Speed.setFont(new Font("Serif", Font.PLAIN, 22));
		x2Speed.setBounds(101,0,100,100);
		x2Speed.addActionListener(this);
		Lives = new JLabel ("Lives: 20");
		Lives.setFont(new Font("Serif", Font.PLAIN, 22));
		Lives.setBounds(521,0,100,100);
		currentWave=new JLabel("<html>Current<br>Wave:   0</html>");
		currentWave.setFont(new Font("Serif", Font.PLAIN, 22));
		currentWave.setBounds(320,0,100,100);
		time=new JLabel("<html>Elapsed<br>Time:   0</html>");
		time.setFont(new Font("Serif", Font.PLAIN, 22));
		time.setBounds(421,0,100,100);
		Restart = new JButton("<html>Restart <br> Level</html>");
		Restart.setFont(new Font("Serif", Font.PLAIN, 22));
		Restart.setBounds(201,0,100,100);
		Restart.addActionListener(this);
		Return = new JButton("<html>Return to<br>Level Selection </html>");
		Return.setFont(new Font("Serif", Font.PLAIN, 22));
		Return.setBounds(680, 0, 120, 100);
		Return.addActionListener(this);
		this.add(nextWave);
		this.add(visBoard);
		this.add(x2Speed);
		this.add(Lives);
		this.add(currentWave);
		this.add(time);
		this.add(Restart);
		this.add(Return);
		elapsedTime=0;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		visBoard.repaint();
	}
	
	@Override
	public void notifyme() {
		int waveCount= board.wavesCounter+1;
		elapsedTime+=0.5;
		currentWave.setText("<html>Current <br> Wave: " +waveCount+"</html>");
		Lives.setText("Lives:  " +board.playerLives);
		if (elapsedTime%1==0)
			time.setText("<html>Elapsed <br> Time:  "+elapsedTime+"</html>");
		this.repaint();
		
	}
	
	public void gameLost(){
		Summary s = new Summary(false,board);
		this.dispose();
	}
	
	public void gameWon(){
		Summary s = new Summary(true,board);
		this.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==nextWave)
			if (!board.waveActive)
				board.startWave();
		if (e.getSource()==x2Speed)
			if (board.waveActive)
				board.doubleSpeed();
		if (e.getSource()==Restart){
			Game g = new Game(currLevel);
			this.dispose();
			
		}
		if (e.getSource()==Return){
			Main m = new Main();
			this.dispose();
		}
			
		
	}

}