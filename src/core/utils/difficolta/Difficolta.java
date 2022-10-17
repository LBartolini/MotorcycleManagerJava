package core.utils.difficolta;

import core.moto.gomma.MarcaGomme;

public interface Difficolta {
	
	public int getGradoComponenteIniziale();
	
	public int getResistenzaComponenteIniziale();
	
	public int getMinProbabilitaGuasto();
	
	public int getMaxProbabilitaGuasto();
	
	public double getMoltiplicatoreCaduta();
	
	public MarcaGomme getMarcaGomme();
	
}
