package core.utils.difficolta;

import core.moto.gomma.MarcaGomme;

public interface Difficolta {
	
	public int getGradoComponenteIniziale();
	
	public int getResistenzaComponenteIniziale();
	
	public int getAggressivitaIniziale();
	
	public int getForzaFisicaIniziale();
	
	public int getAgilitaIniziale();
	
	public int getMinProbabilitaGuasto();
	
	public int getMaxProbabilitaGuasto();
	
	public double getMoltiplicatoreCaduta();
	
	public MarcaGomme getMarcaGomme();
	
}
