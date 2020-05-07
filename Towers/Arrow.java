package Towers;

import java.awt.Image;

import javax.swing.ImageIcon;

import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import Logics.Visitor;

public class Arrow extends Tower implements Visitor {

	public Arrow() {
		super(2, 2);
		ImageIcon arrowicon = new ImageIcon(this.getClass().getResource("/icons/Arrow.png"));
		Image arrowpic = arrowicon.getImage().getScaledInstance(25, 60, Image.SCALE_SMOOTH);
		images = new ImageIcon[1];
		images[0] = new ImageIcon(arrowpic);
	}

	public void visit(Goli g) {
		g.setHp(g.getHp() - 15);
		g.setImageIndex(1);
	}

	public void visit(Mike m) {
		m.setHp(m.getHp() - 30);
		m.setImageIndex(1);
	}

	public void visit(Knight k) {
		return;
	}

	public void visit(Naji n) {
		n.setImageIndex(1);
		if (n.isPoisoned())
			n.setHp(n.getHp() - 45);
		else if (!n.isPoisoned())
			n.setHp(n.getHp() - 30);
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
