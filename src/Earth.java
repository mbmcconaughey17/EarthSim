
public class Earth {
	private int d, sunLon = 0;
	private static int DEFAULT_SPACING = 15, EARTH_CIRCUMFERENCE = 40075000;
	private static double INITIAL_TEMP = 15;
	private Cell[][] globe;

	public Earth(int spacing, int timeInterval) {
		this.d = 180 / spacing;
		initializeGlobe();
		updateSim(timeInvterval);
	}

	public Earth() {
		new Earth(DEFAULT_SPACING);
	}

	private void initializeGlobe() {
		int tLat = 90;

		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {

				globe[i][j] = new Cell(INITIAL_TEMP, tLat, tLat - 180 / d, j * (180 / d), (j * (180 / d) + (180 / d)),
						(double) (EARTH_CIRCUMFERENCE) / (2 * d)); 

			}
			tLat -= 180 / d;
		}

		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {

				globe[i][j].setNeighbors(globe[((i - 1) % d > 0) ? (i - 1) % d : i + (d / 2) % d][j],
						globe[(i + 1) % d][j], globe[i][((j - 1) % d > 0) ? (j - 1) % d : d - 1],
						globe[i][(j + 1) % d]);// check north and west of globe[0][0]
				globe[i][j].calculateArea();
				// System.out.printf("%3d ", globe[i][j].tLat);
			}
			//System.out.println();
		}
	}
	
	
	private void updateSim(int timeInterval){
		double cellAverages, sunTemp;
		Cell thisCell;
		
		
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				thisCell = globe[i][j];
				cellAverages = (thisCell.getTemp() + thisCell.north.getTemp() + thisCell.south.getTemp() + thisCell.west.getTemp() + thisCell.east.getTemp())/5;
				//sunTemp = 
				
				
				
			}
		}
		
		//increment sunPos
		
	}
}
