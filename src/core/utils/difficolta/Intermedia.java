package core.utils.difficolta;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Michelin;
import core.moto.gomma.marche.Pirelli;

public class Intermedia implements Difficolta{
	
	private static final int GRADO_COMPONENTE_INIZIALE = 5;
	private static final int RESISTENZA_INIZIALE = 10;
	
	private static final int MIN_PROB_GUASTO = 0;
	private static final int MAX_PROB_GUASTO = 10;
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return new Michelin();
	}
	
	@Override
	public int getGradoComponenteIniziale() {
		return GRADO_COMPONENTE_INIZIALE;
	}

	@Override
	public int getResistenzaComponenteIniziale() {
		return RESISTENZA_INIZIALE;
	}

	@Override
	public int getMinProbabiitaGuasto() {
		return MIN_PROB_GUASTO;
	}

	@Override
	public int getMaxProbabiitaGuasto() {
		return MAX_PROB_GUASTO;
	}
	
}
