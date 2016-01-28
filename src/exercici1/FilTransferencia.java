package exercici1;

public class FilTransferencia implements Runnable {

	private Banc banc;
	private int compteOrigen;
	private double quantitatMaxima;
	private int DEMORA = 10;

	/**
	 * Constructor del fil
	 * 
	 * @param b
	 *            banc del qual volem transferir els diners
	 * @param origen
	 *            el compte del qual volem treure els diners
	 * @param max
	 *            quantitat m�xima en cada transfer�ncia
	 */
	public FilTransferencia(Banc b, int origen, double max) {
		banc = b;
		compteOrigen = origen;
		quantitatMaxima = max;
	}

	public void run() {
		try {
			while (true) {
				int compteDestinacio = (int) (banc.size() * Math.random());
				double quantitat = quantitatMaxima * Math.random();
				banc.transferir(compteOrigen, compteDestinacio, quantitat);
				Thread.sleep((int) (DEMORA * Math.random()));

			}
		} catch (InterruptedException e) {

		}
	}

}