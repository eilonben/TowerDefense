package Towers;


import java.util.List;

import Creeps.Creep;
import Logics.Tickable;
import Logics.Visitor;
import Visual.Sprite;


public abstract class Tower extends Sprite implements Tickable {

	protected int range;
	protected int attackSpeed;
	protected List<Creep> creepsList;
	protected int timeCurrent;
	
	
	
	public int getRange() {
		return range;
	}

	public Tower (int range, int attackSpeed){
		this.range = range;
		this.attackSpeed = attackSpeed;
		timeCurrent=0;
		imageIndex=0;
	}
	
	
	public void setCreeps(List<Creep> cList){
		creepsList=cList;
	}
	
	public void notifyme(){
			
	}
	
	protected boolean inRange(int creepX, int creepY){
		if (this.x+range>= creepX &&  this.x-range<= creepX && this.y+1+range>= creepY && this.y+1-range<= creepY)
			return true;
		return false;
	}
}
