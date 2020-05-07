package Towers;

import java.awt.Image;

import javax.swing.ImageIcon;

import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import Logics.Visitor;

public class Lava extends Tower implements Visitor {

	public Lava() {
		super(1, 1);
		ImageIcon lavaicon = new ImageIcon(this.getClass().getResource("/icons/Lava.png"));
		Image lavapic = lavaicon.getImage().getScaledInstance(25, 60, Image.SCALE_SMOOTH);
		images = new ImageIcon[1];
		images[0] = new ImageIcon(lavapic);
	}

	public void visit(Goli g) {
		g.setHp(g.getHp() - 15);
		g.setImageIndex(3);
	}

	public void visit(Mike m) {
		m.setHp(m.getHp() - 15);
		m.setImageIndex(3);
	}

	public void visit(Knight k) {
		k.setImageIndex(3);
		if (k.isPoisoned())
			k.setHp(k.getHp() - 20);
		else if (!k.isPoisoned())
			k.setHp(k.getHp() - 10);
	}

	public void visit(Naji n) {
		n.setImageIndex(3);
		if (n.isPoisoned())
			n.setHp(n.getHp() - 22);
		else if (!n.isPoisoned())
			n.setHp(n.getHp() - 15);
	}
	@Override
	public void notifyme() {// in this tower this function is different because it hits everyone in his range
		timeCurrent++;
		if (timeCurrent != attackSpeed) {
			timeCurrent = 0;
			for (Creep c : creepsList)
				if (inRange(c.getX(), c.getY())) {
					c.impact(this);
				}
		}

	}

}
