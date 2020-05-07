package Creeps;
import Logics.Board;
import Logics.Coordinate;
import Logics.Tickable;
import Logics.Visitor;
import Visual.Sprite;


public abstract class Creep extends Sprite implements Tickable{
	protected int hp;
	protected int poisonTimer;
	protected int speed;
	private int timeCurrent;
	protected Board board;
	
	public Creep(int speed){
		imageIndex=0;
		hp=100;
		poisonTimer = -1;
		this.speed=speed;
		timeCurrent=0;
	}
	

	public void setBoard(Board board) {
		this.board = board;
	}

	public void impact (Visitor v){
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public boolean isPoisoned(){
		return (poisonTimer >= 0 && poisonTimer < 10);
	}
	
	public void setPoisoned(boolean b){
		if (b)
			poisonTimer = 0;
		else if(!b)
			poisonTimer = -1;
	}
	
	
	public boolean isKilled(){
		return hp <= 0;
	}
	
	public void notifyme(){// moves the creep and updates the poison timer if he is poisoned
		if (isPoisoned()){
			poisonTimer++;
			if (poisonTimer==10)
				poisonTimer=-1;
		}
		timeCurrent++;
		Coordinate move = board.coordMat[x][y];
		if (timeCurrent!=speed){
			this.x+=move.getX();
			this.y+=move.getY();
			timeCurrent=0;
		}
		
			
	}
}  
