package core.utils.difficolta;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Metzler;
import core.moto.gomma.marche.Pirelli;

public class Impossibile implements Difficolta{
	
	private static final int GRADO_COMPONENTE_INIZIALE = 1;
	private static final int RESISTENZA_INIZIALE = 1;
	
	private static final int MIN_PROB_GUASTO = 5;
	private static final int MAX_PROB_GUASTO = 25;
	
	private static final Double MOLTIPLICATORE_CADUTA = 1.5;
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return new Metzler();
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

	@Override
	public double getMoltiplicatoreCaduta() {
		return MOLTIPLICATORE_CADUTA;
	}
}
