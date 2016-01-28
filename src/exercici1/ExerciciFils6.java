package exercici1;

import exercici1.ExerciciFils5.Fil;



/**
 * Classe que crea 4 fils i els executa. S'executen concurrentment i espera que terminin, 
 * Despr�s de cada iteraci� es bloquejen durant 1 segon i tornen a estar disponibles per
 * l'execuci�
 * Un fil pot invocar el m�tode join d'un altre fil amb la finalitat de quedar-se bloquejat FINS
 * que termini l'execuci� de l'altre fil. Un fil pare pot crear diversos fils fills i despr�s
 * d'iniciar-los esperar fins que la resta terminin.
 * 
 * @author sergi grau
 * @version 1.0, 28.01.2010
 * 
 */


public class ExerciciFils6 {

	private static Runnable runnable1= new Fil("fil1");
	private static Runnable runnable2= new Fil("fil2");
	private static Runnable runnable3= new Fil("fil3");
	private static Runnable runnable4= new Fil("fil4");
	
	public static void main(String[] args) {

		
		Thread fil1= new Thread(runnable1);
		Thread fil2= new Thread(runnable2);
		Thread fil3= new Thread(runnable3);
		Thread fil4= new Thread(runnable4);
		
		fil1.start();
		fil2.start();
		fil3.start();
		fil4.start();
		try {
			fil1.join(); 
 		 	fil2.join(); 
			fil3.join();
			fil4.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	
	}

	/**
	 * Classe interna est�tica que implementa la interf�cie Runnable
	 * Representa un fil que escriu 1000 digits i
	 * acaba. utilitza el m�tode de classe sleep per bloquejar un Fil
	 * durant un segon
	 * permetre que el planificador de fils seleccioni l'altre
	 * 
	 * @author sergi grau
	 * @version 1.0, 28.01.2010
	 */
	public static class Fil implements Runnable {

		private String nom;
		/**
		 * Constructor amb 1 par�metre
		 * @param nom nom del fil
		 */
		public Fil(String nom){
			this.nom= nom;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i + "-" + nom);
				
			}
			System.out.println("final" + nom);

			
		}

	}
}
