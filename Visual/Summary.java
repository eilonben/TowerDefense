package Visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Logics.Board;

public class Summary extends JFrame implements ActionListener {
	
	private Board board;
	private JButton toMenu;
	private JLabel sum;
	private JLabel Lives;
	private JLabel creepsKilled;
	private JLabel time;
	private JLabel passedcreeps;
	
	public Summary(boolean win, Board board){
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Level Summary");
		this.board=board;
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(null);
		this.setResizable(false);
		if (win)
			sum = new JLabel("Level Complete");
		else 
			sum= new JLabel("Game Lost");
		initComponents();
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==toMenu){
			Main m = new Main();
			this.dispose();
		}
			
		
	}
	
	private void initComponents(){
		sum.setBounds(150,50,200,50);
		sum.setFont(new Font("Serif", Font.PLAIN, 30));
		Lives=new JLabel("Remaining Lives: "+board.playerLives);
		Lives.setBounds(50, 150, 400, 50);
		Lives.setFont(new Font("Serif", Font.PLAIN, 20));
		time=new JLabel("Elapsed Time: "+board.tickCounter/2);
		time.setFont(new Font("Serif", Font.PLAIN, 20));
		time.setBounds(50, 200, 400, 50);
		creepsKilled=new JLabel("Creeps Killed: " +board.creepsKilled);
		creepsKilled.setFont(new Font("Serif", Font.PLAIN, 20));
		creepsKilled.setBounds(50, 250, 400, 50);
		toMenu=new JButton("Return to Level Selection");
		toMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		toMenu.setBounds(100,400,300,50);
		toMenu.addActionListener(this);
		passedcreeps=new JLabel("Creeps who got Away:" +(20-board.playerLives));
		passedcreeps.setFont(new Font("Serif", Font.PLAIN, 20));
		passedcreeps.setBounds(50,300, 400, 50);
		this.add(sum);
		this.add(Lives);
		this.add(time);
		this.add(creepsKilled);
		this.add(toMenu);
		this.add(passedcreeps);
		
	}

}
