package Logics;

import java.util.ArrayList;
import java.util.Collections;

import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;

public class Wave {
	private ArrayList<Creep> creepsList;
	private int waveSize;
	
	public Wave(int waveSize){
		creepsList= new ArrayList<Creep>();
		for (int i=0; i<waveSize/4; i++){
			Goli g = new Goli();
			Naji n = new Naji();
			Knight k = new Knight();
			Mike m = new Mike();
			creepsList.add(g);
			creepsList.add(n);
			creepsList.add(k);
			creepsList.add(m);
		}
		shuffleCreeps();
	}
	
	public void shuffleCreeps(){
		Collections.shuffle(creepsList);
	}

	public ArrayList<Creep> getCreepsList() {
		return creepsList;
	}

	public void setCreepsList(ArrayList<Creep> creepsList) {
		this.creepsList = creepsList;
	}

	public int getWaveSize() {
		return waveSize;
	}

	public void setWaveSize(int waveSize) {
		this.waveSize = waveSize;
	}
	
	
	
	
}
