package Towers;
import java.awt.Image;

import javax.swing.ImageIcon;

import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import Logics.Visitor;


public class Magic extends Tower implements Visitor{
	
	public Magic (){
		super(1, 1);
		ImageIcon magicicon = new ImageIcon(this.getClass().getResource("/icons/Magic.png"));
		Image magicpic = magicicon.getImage().getScaledInstance(25, 60, Image.SCALE_SMOOTH);
		images = new ImageIcon[1];
		images[0]=new ImageIcon(magicpic);
	}

	public void visit(Goli g) {
		g.setImageIndex(2);
		g.setHp(g.getHp()-25);
	}
	
	public void visit(Mike m) {
		m.setImageIndex(2);
		m.setHp(m.getHp()-10);
	}
	
	public void visit(Knight k) {
		k.setImageIndex(2);
		if (k.isPoisoned())
			k.setHp(k.getHp()-60);
		else if(!k.isPoisoned())
			k.setHp(k.getHp()-30);
	}
	public void visit(Naji n) {
		n.setImageIndex(2);
		if(n.isPoisoned())
			n.setHp(n.getHp()-15);
		else if(!n.isPoisoned())
			n.setHp(n.getHp()-10);
	}
	@Override
	public void notifyme() {

		timeCurrent++;
		if (timeCurrent != attackSpeed) {
			timeCurrent = 0;
			for (Creep c : creepsList)
				if (inRange(c.getX(), c.getY())) {
					c.impact(this);
					return;
				}
		}

	}

	

}
