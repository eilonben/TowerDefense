package Visual;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logics.Board;

public class towerMenu extends JFrame implements ActionListener {
	
	private Board board;
	private JButton arrow;
	private JButton magic;
	private JButton lava;
	private JButton poison;
	private JPanel TowerPanel;
	private int x;
	private int y;
	
	public towerMenu(Board board,int x,int y){
		this.setTitle("Select Tower");
		this.x=x;
		this.y=y;
		this.board=board;
		TowerPanel = new JPanel();
		TowerPanel.setPreferredSize(new Dimension(280,400));
		ImageIcon arrowicon = new ImageIcon(this.getClass().getResource("/icons/Arrow.png"));
		Image arrowpic = arrowicon.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		ImageIcon magicicon = new ImageIcon(this.getClass().getResource("/icons/Magic.png"));
		Image magicpic = magicicon.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		ImageIcon lavaicon = new ImageIcon(this.getClass().getResource("/icons/Lava.png"));
		Image lavapic = lavaicon.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		ImageIcon poisonicon = new ImageIcon(this.getClass().getResource("/icons/Poison.png"));
		Image poisonpic = poisonicon.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		arrow = new JButton(board.towerCounters[0].toString(),new ImageIcon(arrowpic));
		magic = new JButton("",new ImageIcon(magicpic));
		lava = new JButton("",new ImageIcon(lavapic));
		poison = new JButton("",new ImageIcon(poisonpic));
		arrow.setBounds(40,40,80,100);
		magic.setBounds(160,40,80,100);
		lava.setBounds(40,250,80,100);
		poison.setBounds(160,250,80,100);
		JLabel arrowcount = new JLabel(board.towerCounters[0].toString());
		JLabel magiccount = new JLabel(board.towerCounters[1].toString());
		JLabel lavacount = new JLabel(board.towerCounters[2].toString());
		JLabel poisoncount = new JLabel(board.towerCounters[3].toString());
		arrowcount.setBounds(80,140,20,20);
		magiccount.setBounds(200,140,20,20);
		lavacount.setBounds(80,350,20,20);
		poisoncount.setBounds(200,350,20,20);
		TowerPanel.add(arrow);
		TowerPanel.add(magic);
		TowerPanel.add(lava);
		TowerPanel.add(poison);
		TowerPanel.add(arrowcount);
		TowerPanel.add(magiccount);
		TowerPanel.add(poisoncount);
		TowerPanel.add(lavacount);
		this.add(TowerPanel);
		TowerPanel.setLayout(null);
		this.pack();
		arrow.addActionListener(this);
		magic.addActionListener(this);
		poison.addActionListener(this);
		lava.addActionListener(this);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==arrow)
			board.addTower("arrow", x, y);
		else if (e.getSource()==magic)
			board.addTower("magic", x, y);
		else if (e.getSource()==lava)
			board.addTower("lava", x, y);
		else if (e.getSource()==poison)
			board.addTower("poison", x, y);
		this.dispose();
		
			
		
	}
	
}
