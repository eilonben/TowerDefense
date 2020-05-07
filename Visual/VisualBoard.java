package Visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Creeps.Creep;
import Creeps.Goli;
import Logics.Board;
import Logics.Coordinate;
import Towers.Tower;

public class VisualBoard extends JPanel implements MouseListener {
	
	private Board board;
	private towerMenu TM;
	private Tower rangeTower;
	
	public VisualBoard(Board board){
		this.setLayout(new GridLayout(32, 32));
		this.setBorder(BorderFactory.createEmptyBorder(2, 2,2,2));
		this.setPreferredSize(new Dimension(800, 800));
		this.board=board;
		this.addMouseListener(this);
		rangeTower=null;
	}
	
	
	public void paint(Graphics g){
		super.paint(g);	
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/icons/background.png"));
		bgImg.paintIcon(this, g, 0, 0);
		ImageIcon blockImg = new ImageIcon(this.getClass().getResource("/icons/block.png"));
		for (int i =0; i<32; i++){
			for (int j =0; j<32; j++){
				if (board.coordMat[i][j].getX()!=0 || board.coordMat[i][j].getY()!=0 )
					blockImg.paintIcon(this, g, (800/32)*i ,(800/32)*j);
			}
		}
		if (rangeTower!=null){
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g2.setColor(Color.RED);
			g2.drawRect((rangeTower.getX()-rangeTower.getRange())*800/32, (rangeTower.getY()+1-rangeTower.getRange())*800/32, ((rangeTower.getRange()*2)+1)*25, ((rangeTower.getRange()*2)+1)*25);
		}
		for(Creep c:board.creepList)
			c.paint(g, this);
		
		
		for(Tower t:board.towersList)
			t.paint(g, this);
		
		
			
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (rangeTower!=null)
			rangeTower=null;
		int clickX = e.getX() * 32 / 800 ; 
		int clickY = e.getY() * 32 / 800 ; 
		Coordinate click = board.coordMat[clickX][clickY];
		if (click.hasTower()){
			for(Tower t:board.towersList)
				if (t.getX()==clickX && t.getY()==clickY-1)
					rangeTower=t;
		}
		if ((!(click.hasTower())) && click.isGrass() && !board.waveActive)	
			TM = new towerMenu(board,clickX,clickY);
		repaint();
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
