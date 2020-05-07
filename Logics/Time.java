package Logics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import java.util.TimerTask;

import javax.swing.Timer;

import Visual.Game;

public class Time implements ActionListener{
	
	private List<Tickable> ticks;
	private Timer timer;
	private Board board;
	private boolean xSpeed;
	private Game game;
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Time(Board board){
		xSpeed=false;
		ticks = new LinkedList<Tickable>();
		this.board=board;
		timer = new Timer(500,this);
		timer.start();
	}
	
	public void register(Tickable t){
		ticks.add(t);
	}
	
	public void unRegister(Tickable t){
		if (ticks.contains(t))
			ticks.remove(t);
	}
	
	public void DoubleSpeed(){
		if (!xSpeed){
			timer.setDelay(250);
			xSpeed=true;
		}else{
			timer.setDelay(500);
			xSpeed=false;
		}	
	}
	
	public void actionPerformed(ActionEvent e){
		board.notifyme();
		if (!ticks.isEmpty())
			for (Tickable t: ticks){
				t.notifyme();
			}
		game.notifyme();
	}
	
	
	public void timerStart(){
		timer.start();
	}

	
	public void timerStop(){
		timer.stop();
	}
}
