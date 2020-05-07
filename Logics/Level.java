package Logics;

import java.io.BufferedReader;
import java.io.FileReader;

public class Level {
	
	private Coordinate[][] levelBoard;
	private Coordinate startPoint;
	
	public Level(int level){
		levelBoard = parseLevel(level);
	}
	
	public Coordinate[][] parseLevel(int level){
		try{
			String filename="level"+level+".txt";
			BufferedReader br = new BufferedReader(new FileReader("levels/"+filename));
			Coordinate[][] output = new Coordinate[32][32];
			String line =br.readLine();
			int j=0;
			boolean start=false;
			while (line!=null && j<32){
				String[] parse = line.split("\\|");
				for (int i=0; i<32; i++){
					Coordinate c = new Coordinate(0,0);
					if (parse[i].equals("D"))
						c.setY(1);
					else if(parse[i].equals("U"))
						c.setY(-1);
					else if(parse[i].equals("R"))
						c.setX(1);
					else if(parse[i].equals("L"))
						c.setX(-1);	
					if ((c.getX()!=0 || c.getY()!=0) && i==0 && !start){
						startPoint=new Coordinate(i,j);
						start=true;
					}
					output[i][j]=c;			
				}
				j++;
				line =br.readLine();
			}
			return output;
		}
		catch(Exception e){ System.out.println(e);
			return null;
			}
		
		
	}

	public Coordinate[][] getLevelBoard() {
		return levelBoard;
	}

	public void setLevelBoard(Coordinate[][] levelBoard) {
		this.levelBoard = levelBoard;
	}


	public Coordinate getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Coordinate startPoint) {
		this.startPoint = startPoint;
	}
}
