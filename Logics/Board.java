package Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Towers.Arrow;
import Towers.Lava;
import Towers.Magic;
import Towers.Poison;
import Towers.Tower;
import Visual.Game;
import Creeps.Creep;

public class Board implements Tickable {

	public Coordinate[][] coordMat;
	public List<Creep> creepList;
	public List<Tower> towersList;
	public Game game;
	private Time timer;
	private Wave[] waves;
	public int tickCounter;
	public int wavesCounter;
	private boolean waveComplete;
	private int currentWave;
	private Coordinate startPoint;
	public Integer[] towerCounters;
	public int playerLives;
	public boolean waveActive;
	public int creepsKilled;

	public Board(Level level,Game game) {
		waveActive=false;
		this.game=game;
		creepsKilled=0;
		playerLives= 20;
		tickCounter = 0;
		wavesCounter = 0;
		waves = generateWaves();
		coordMat = level.getLevelBoard();
		startPoint = level.getStartPoint();
		creepList = new ArrayList<Creep>();
		towersList = new ArrayList<Tower>();
		towerCounters= new Integer[4];
		for (int i=0;i<4;i++)
			towerCounters[i]=4;

	}

	private Wave[] generateWaves() {// a function to generate 5 waves for the current level
		Wave[] output = new Wave[5];
		for (int i = 0; i < 5; i++) {
			Wave wave = new Wave(8 * (i + 1));
			output[i] = wave;
		}
		return output;
	}

	public void startWave() {// what happens when the user presses the nextwave button
		if (timer==null){
			timer = new Time(this);
			timer.setGame(this.game);
		}
		else
			timer.timerStart();
		for(Tower t:towersList)
			timer.register(t);
		currentWave=wavesCounter;
		waveComplete = false;
		waveActive=true;
	}

	@Override
	public void notifyme() {// the board updates everything every tick of the timer
		ArrayList<Creep> waveCreeps = waves[currentWave].getCreepsList();
		int startX = startPoint.getX();
		int startY = startPoint.getY();
		List<Creep> creepCopy = new ArrayList<Creep>(creepList);
		for (Tower t: towersList)
			t.setCreeps(creepList);
		for (Creep c:creepCopy){
			if (c.isPoisoned())
				c.setImageIndex(4);
			else c.setImageIndex(0);
			
			if (c.isKilled()){
				creepList.remove(c);
				timer.unRegister(c);
				creepsKilled++;
			}
			else if (c.getX()==32){
				creepList.remove(c);
				timer.unRegister(c);
				playerLives--;
			}
			if (playerLives<=0){
				timer.timerStop();
				game.gameLost();
				return;
			}
				
		}
			
		if (!waveComplete) {

			if (tickCounter % 4   == 0)
				if (waveCreeps.isEmpty() && !waveComplete) {
					waveComplete = true;
				} else {
					Creep creep = waveCreeps.get(0);
					timer.register(creep);
					creepList.add(creep);
					creep.setX(startX);
					creep.setY(startY);
					creep.setBoard(this);
					waveCreeps.remove(0);
				}
		}else{
			if (creepList.isEmpty()){
				timer.timerStop();
				waveActive=false;
				wavesCounter++;
					if (wavesCounter==5)
						game.gameWon();
			}
			
		}
		tickCounter++;
	}
		
	
	public void addTower(String tower, int x, int y){// tower addition to the board
		if (tower.equals("arrow") && towerCounters[0]>0){
			Arrow a = new Arrow();
			a.setX(x);
			a.setY(y-1);
			towersList.add(a);
			towerCounters[0]--;
			coordMat[x][y].addTower();
			
		}
		if (tower.equals("magic") && towerCounters[1]>0){
			Magic a = new Magic();
			a.setX(x);
			a.setY(y-1);
			towersList.add(a);
			towerCounters[1]--;
			coordMat[x][y].addTower();
			
		}
		if (tower.equals("lava") && towerCounters[2]>0){
			Lava a = new Lava();
			a.setX(x);
			a.setY(y-1);
			towersList.add(a);
			towerCounters[2]--;
			coordMat[x][y].addTower();
			
		}
		if (tower.equals("poison") && towerCounters[3]>0){
			Poison a = new Poison();
			a.setX(x);
			a.setY(y-1);
			towersList.add(a);
			towerCounters[3]--;
			coordMat[x][y].addTower();
			
		}
		game.repaint();
	}

	public void doubleSpeed(){
		timer.DoubleSpeed();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
