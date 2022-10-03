package game.utils.constants.difficolta;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.marche.Dunlop;
import game.moto.gomma.marche.Pirelli;

public class Difficile {
	public static final int GRADO_INIZIALE = 2;
	public static final int RESISTENZA_INIZIALE = 5;
	
	public static final int MIN_PROB_GUASTO = 5;
	public static final int MAX_PROB_GUASTO = 15;
	
	public static MarcaGomme getMarcaGomme() {
		return new Dunlop();
	}
}
