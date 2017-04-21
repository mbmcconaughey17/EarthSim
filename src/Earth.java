
public class Earth {
	private int d, sunLon = 0;
	private static int DEFAULT_SPACING = 15, EARTH_CIRCUMFERENCE = 40075000;
	private static double INITIAL_TEMP = 15;
	private Cell[][] globe;
	
	public Earth(int spacing){
		this.d = 180 / spacing;
		initializeGlobe();
	}
	
	public Earth(){
		new Earth(DEFAULT_SPACING);
	}
	
	private void initializeGlobe(){
		globe = new Cell[d][d];
		int tLat = 90, bLat = 90 -(180/d);
		
		for(int i = 0; i < d; i++){
			for(int j = 0; j < d; j++){
	
				globe[i][j] = new Cell(INITIAL_TEMP, tLat, bLat, j*(180/d), (j*(180/d)+(180/d)), (double)(EARTH_CIRCUMFERENCE)/(2*d));	//check north and west of globe[0][0]
				
			}

			if(i < d/2){
				tLat -= 180/d;
				bLat -= 180/d;
			}
			
			else{
				tLat += 180/d;
				bLat += 180/d;
			}
			
		}
		
		for(int i = 0; i < d; i++){
			for(int j = 0; j < d; j++){
		
				globe[i][j].setNeighbors(globe[((i - 1)%d > 0)?(i - 1)%d : i + (d/2)%d][j], globe[(i + 1)%d][j], globe[i][((j - 1)%d > 0)? (j - 1)%d : d-1], globe[i][(j+1)%d]);
				globe[i][j].calculateArea();
				System.out.printf("%3f ", globe[i][j].area);
				
				
			}
			
			System.out.println();
		}
		
		
		
	}
}
