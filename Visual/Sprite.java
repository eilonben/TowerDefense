package Visual;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;



public abstract class Sprite {
	protected int x;
	protected int y;
	protected ImageIcon[] images;
	protected boolean pictureSelect;
	protected int imageIndex;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void isHit(){
		
	}
	
	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}
	
	public void paint (Graphics g, JComponent J){
		images[imageIndex].paintIcon(J, g, x*800/32, y*800/32);
			
	}
}
