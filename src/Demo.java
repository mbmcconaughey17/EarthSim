
public class Demo {

	static boolean simInitiative = false;
	static boolean presInitiative = false;
	
	
	public static void main(String[] args) {
		Earth e = new Earth(18, 1);
		
		if(simInitiative){
			
			
			
		}
		Cell[][] g;
		for(int i = 0; i < 5; i++){
			g = e.updateSim(20);
			
			for(int j = 0; j< g.length; j ++){
				for(int l = 0; l < g[0].length; l++)
					System.out.printf("%2.0f ", g[j][l].getTemp());

				System.out.println();
			}
			System.out.println("\n");
		}
		
		
	}
	
	

}
