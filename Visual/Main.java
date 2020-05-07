package Visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener {
	private JButton level1;
	private JButton level2;
	private JButton level3;
	private JLabel text;
	private JLabel bg;
	private Game g;
	
	
	public Main(){
		bg=new JLabel(new ImageIcon(this.getClass().getResource("/icons/st.png")));
		bg.setBounds(0, 0, 1300, 1000);
		this.add(bg);
		this.setLayout(null);
		initComponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Tower Defense");
		this.setPreferredSize(new Dimension (1300,1000));
		this.setVisible(true);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==level1){
			g = new Game(1);
			this.dispose();
		}
		if (e.getSource()==level2){
			g = new Game(2);
			this.dispose();
		}
		if (e.getSource()==level3){
			g = new Game(3);
			this.dispose();
		}
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		ImageIcon bg=new ImageIcon(this.getClass().getResource("/icons/Logo.png"));
		bg.paintIcon(this, g, 430, 30);
		g.setFont(new Font("Serif", Font.BOLD, 40));
		g.drawString("Click on one of the levels to start the game:", 320, 500);
		
	}
	
	private void initComponents(){
		text=new JLabel("Click on one of the levels to start the game:");
		text.setFont(new Font("Serif", Font.PLAIN, 30));
		text.setBounds(400, 350, 600, 40);
		this.add(text);
		level1=new JButton();
		level1.setIcon(new ImageIcon(this.getClass().getResource("/icons/lvl1.png")));
		level1.setBounds(10,500,411,339);
		level1.addActionListener(this);
		this.add(level1);
		level2=new JButton();
		level2.setIcon(new ImageIcon(this.getClass().getResource("/icons/lvl2.png")));
		level2.setBounds(440,500,411,339);
		level2.addActionListener(this);
		this.add(level2);
		level3=new JButton();
		level3.setIcon(new ImageIcon(this.getClass().getResource("/icons/lvl3.png")));
		level3.setBounds(870,500,411,339);
		level3.addActionListener(this);
		this.add(level3);
	}
	
	public static void main(String[] args){
		Main m= new Main();
	}
	
	
	
}
