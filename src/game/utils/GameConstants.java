package game.utils;

import game.moto.MarcaGomme;

public class GameConstants {
	
	public static final MarcaGomme PIRELLI = new MarcaGomme();
	public static final MarcaGomme MICHELIN = new MarcaGomme();
	public static final MarcaGomme BRIDGESTON = new MarcaGomme();
	public static final MarcaGomme DUNLOP = new MarcaGomme();
	public static final MarcaGomme CONTINENTAL = new MarcaGomme();
	public static final MarcaGomme METZLER = new MarcaGomme();
	
	public static final int DIFF_FACILE = 1;
	public static final int GRADO_COMPONENTE_FACILE = 10;
	public static final int RESISTENZA_COMPONENTE_FACILE = 15;
	public static final MarcaGomme GOMME_FACILE = PIRELLI;
	
	public static final int DIFF_INTERMEDIA = 2;
	public static final int GRADO_COMPONENTE_INTERMEDIA = 5;
	public static final int RESISTENZA_COMPONENTE_INTERMEDIA = 10;
	public static final MarcaGomme GOMME_INTERMEDIA = MICHELIN;
	
	public static final int DIFF_DIFFICILE = 3;
	public static final int GRADO_COMPONENTE_DIFFICILE = 2;
	public static final int RESISTENZA_COMPONENTE_DIFFICILE = 5;
	public static final MarcaGomme GOMME_DIFFICILE= DUNLOP;
	
	public static final int DIFF_IMPOSSIBILE = 4;
	public static final int GRADO_COMPONENTE_IMPOSSIBILE = 1;
	public static final int RESISTENZA_COMPONENTE_IMPOSSIBILE = 1;
	public static final MarcaGomme GOMME_IMPOSSIBILE= METZLER;
	
}
