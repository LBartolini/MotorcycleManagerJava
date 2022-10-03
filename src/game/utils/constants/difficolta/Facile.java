package game.utils.constants.difficolta;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.marche.Pirelli;

public class Facile {
	public static final int GRADO_INIZIALE = 10;
	public static final int RESISTENZA_INIZIALE = 15;
	
	public static final int MIN_PROB_GUASTO = 0;
	public static final int MAX_PROB_GUASTO = 0;
	
	public static MarcaGomme getMarcaGomme() {
		return new Pirelli();
	}
}
