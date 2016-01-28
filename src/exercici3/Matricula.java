package exercici3;

/**
 * Classe que representa una Matr�cula
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class Matricula {
	private String lletres;
	private String numeros;
	/**
	 * M�tode constructor amb 2 par�metres
	 * @param lletres
	 * @param numeros
	 */
	public Matricula(String lletres, String numeros) {
		super();
		this.lletres = lletres;
		this.numeros = numeros;
	}
	/** M�tode accessor que llegeix el m�tode lletres
	 * @return lletres
	 */
	public String getLletres() {
		return lletres;
	}
	/** M�tode accessor que llegeix el m�tode numeros
	 * @return numeros
	 */
	public String getNumeros() {
		return numeros;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj==null) return false;
		if (getClass()!=obj.getClass()) return false;
		Matricula m = (Matricula) obj;
		return lletres.equals(m.lletres) && numeros.equals(m.numeros);
	}
	
	@Override
	public String toString() {
		return lletres+"-"+numeros;
	}
	
	
}
