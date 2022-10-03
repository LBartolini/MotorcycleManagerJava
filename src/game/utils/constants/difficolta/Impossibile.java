package game.utils.constants.difficolta;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.marche.Metzler;
import game.moto.gomma.marche.Pirelli;

public class Impossibile {
	public static final int GRADO_INIZIALE = 1;
	public static final int RESISTENZA_INIZIALE = 1;
	
	public static final int MIN_PROB_GUASTO = 5;
	public static final int MAX_PROB_GUASTO = 25;
	
	public static MarcaGomme getMarcaGomme() {
		return new Metzler();
	}
}
