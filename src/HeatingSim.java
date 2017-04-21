public class HeatingSim{

	static double[][] oldPlate;
	static double[][] newPlate;
	static int counter = 0;
	static int d;

	public HeatingSim(double top, double bot, double left, double right, int d) {
		// Create arrays oldPlate and newPlate with linear dimension d
		this.d = d;
		oldPlate = new double[d][d];
		newPlate = new double[d][d];

		//initial condition: 15 degrees Celcius
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[0].length; j++) {
				oldPlate[i][j] = 15;	
			}
		}
	} // end constructor

	public static boolean done() {
		counter++;

		if ((counter > d && (Math.abs(newPlate[d / 2][d / 2] - oldPlate[d / 2][d / 2]) <= 0.1)) || counter == 1000) {
			return true;
		} else {
			return false;
		}

	} // end done method

	public static void swap(double[][] oldPlate, double[][] newPlate) {
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[0].length; j++) {
				double temp = oldPlate[i][j];
				oldPlate[i][j] = newPlate[i][j];
				newPlate[i][j] = temp;
			}
		}
	} // end swap

	public static String print() {
		String result = "";
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[0].length; j++) {
				result += String.format("%5.2f", newPlate[i][j]) + " ";
			}
			result += "\n";
		}
		return result;
	}

	public static void updatePlates() {

		// Loop until exit criteria are met, updating each newPlate cell from
		// the average temperatures of the corresponding neighbors in oldPlate
		do {
			for (int i = 1; i <= d; i++) {
				for (int j = 1; j <= d; j++) {
					// Compute lattice point temperature as average of neighbors
					// %d to wrap edges around
					newPlate[i][j] = (oldPlate[(i + 1)%d][j % d] + oldPlate[(i - 1) % d][j%d] + oldPlate[i%d][(j + 1)%d] + oldPlate[i%d][(j - 1)%d])
							/ 4.0 ;//+ heat from the sun

				}
			}
			// Swap the plates and continue
			swap(oldPlate, newPlate);
		} while (!done());
	}

}
