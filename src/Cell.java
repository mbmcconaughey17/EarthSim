
public class Cell {
	private double temp;
	double area;
	public int rLon, lLon, bLat, tLat;
	private double rLen, lLen, bLen, tLen;
	private double sunAngle;
	
	private Cell north, south, east, west;
	
	public Cell(double temp, int tLat, int bLat, int rLon, int lLon, double sideLen){
		this.temp = temp;
		
		
		
		this.bLat = bLat;
		this.tLat = tLat;
		this.lLon = lLon;
		this.rLon = rLon;
		
		rLen = sideLen;
		lLen = sideLen;
	}
	
	public void setSunAngle(double sunAngle){
		this.sunAngle = sunAngle;
	}
	
	public void setTemp(double temp){
		this.temp = temp;
	}
	
	public double getTemp(){
		return temp;
	}
	
	public void setNeighbors(Cell north, Cell south, Cell west, Cell east){
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	
	public void calculateArea(){
		if(tLat == 90)
			tLen = 0;
		else
			tLen = this.north.bLen;			//the length of the top of this cell is the length of the bottom on the north cell
		bLen = (Math.cos(bLat)*rLen) * 2 + tLen;
		
		area = ((tLen + bLen)/ 2)* Math.sin(bLat);
	}
	
	
}