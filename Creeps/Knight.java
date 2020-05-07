package Creeps;
import java.awt.Image;

import javax.swing.ImageIcon;

import Logics.Visitor;


public class Knight extends Creep{

	public Knight(){
		super(1);
		pictureSelect=false;
		images = new ImageIcon[5];
		initPics();
	}
	
	public void impact(Visitor v){
		v.visit(this); 
	}

	private void initPics(){// initiallize the pictures of the creep
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/icons/abir-1.png"));
		Image scale1 = img1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/icons/abir-2.png"));
		Image scale2 = img2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/icons/abir-3.png"));
		Image scale3 = img3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon img4 = new ImageIcon(this.getClass().getResource("/icons/abir-4.png"));
		Image scale4 = img4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon img5 = new ImageIcon(this.getClass().getResource("/icons/abir-5.png"));
		Image scale5 = img5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		images[0] = new ImageIcon(scale1);
		images[1] = new ImageIcon(scale2);
		images[2] = new ImageIcon(scale3);
		images[3] = new ImageIcon(scale4);
		images[4] = new ImageIcon(scale5);
	}
	
}
