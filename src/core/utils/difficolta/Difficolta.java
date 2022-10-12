package core.utils.difficolta;

import core.moto.gomma.MarcaGomme;

public interface Difficolta {
	
	public int getGradoComponenteIniziale();
	
	public int getResistenzaComponenteIniziale();
	
	public int getMinProbabiitaGuasto();
	
	public int getMaxProbabiitaGuasto();
	
	public MarcaGomme getMarcaGomme();
	
}
