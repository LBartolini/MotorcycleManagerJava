package core.utils.constants.difficolta;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Metzler;
import core.moto.gomma.marche.Pirelli;

public class Impossibile {
	public static final int GRADO_INIZIALE = 1;
	public static final int RESISTENZA_INIZIALE = 1;
	
	public static final int MIN_PROB_GUASTO = 5;
	public static final int MAX_PROB_GUASTO = 25;
	
	public static MarcaGomme getMarcaGomme() {
		return new Metzler();
	}
}
