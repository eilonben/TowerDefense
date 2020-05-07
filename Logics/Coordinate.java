package Logics;

public class Coordinate {
	private int x;
	private int y;
	private boolean hasTower;
	
	public Coordinate(int x, int y){
		this.x=x;
		this.y=y;
		hasTower=false;
	}
	
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
	
	public String toString(){
		return "("+x+","+y+")";
	}
	
	public void addTower(){
		hasTower=true;
	}

	public boolean hasTower() {
		return hasTower;
	}
	
	public boolean isGrass(){
		return (x==0 && y==0);
	}
	
	
	
}
