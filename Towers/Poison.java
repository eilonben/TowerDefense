package Towers;
import java.awt.Image;

import javax.swing.ImageIcon;

import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import Logics.Visitor;


public class Poison extends Tower implements Visitor{

	public Poison (){
		super(1, 1);
		ImageIcon poisonicon = new ImageIcon(this.getClass().getResource("/icons/Poison.png"));
		Image poisonpic = poisonicon.getImage().getScaledInstance(25, 60, Image.SCALE_SMOOTH);
		images = new ImageIcon[1];
		images[0]=new ImageIcon(poisonpic);
	}
	
	
	public void visit(Goli g) {
		g.setImageIndex(4);
		g.setHp(g.getHp()-20);
	}
	
	public void visit(Mike m) {
		return;
	}
	
	public void visit(Knight k) {
		k.setImageIndex(4);
		k.setPoisoned(true);
	}
	public void visit(Naji n) {
		n.setImageIndex(4);
		n.setPoisoned(true);
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
