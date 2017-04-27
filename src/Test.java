public class Test {

	   public static void main(String args[]) {
	      Simulation R1 = new Simulation( "Thread-1");
	      R1.start();
	      
	      Simulation R2 = new Simulation( "Thread-2");
	      R2.start();
	   }   
	}
