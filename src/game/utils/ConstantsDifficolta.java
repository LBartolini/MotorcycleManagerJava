package game.utils;

import game.moto.gomma.MarcaGomme;

public class ConstantsDifficolta {

	// TODO aggiungere moltiplicatore tempo massimo su giro per le piste
	
	
	public final int DIFF_FACILE = 1;
	public final int GRADO_COMPONENTE_FACILE = 10;
	public final int RESISTENZA_COMPONENTE_FACILE = 15;
	public final MarcaGomme GOMME_FACILE = GameConstants.gomme.pirelli;
	
	public final int DIFF_INTERMEDIA = 2;
	public final int GRADO_COMPONENTE_INTERMEDIA = 5;
	public final int RESISTENZA_COMPONENTE_INTERMEDIA = 10;
	public final MarcaGomme GOMME_INTERMEDIA = GameConstants.gomme.michelin;
	
	public final int DIFF_DIFFICILE = 3;
	public final int GRADO_COMPONENTE_DIFFICILE = 2;
	public final int RESISTENZA_COMPONENTE_DIFFICILE = 5;
	public final MarcaGomme GOMME_DIFFICILE= GameConstants.gomme.dunlop;
	
	public final int DIFF_IMPOSSIBILE = 4;
	public final int GRADO_COMPONENTE_IMPOSSIBILE = 1;
	public final int RESISTENZA_COMPONENTE_IMPOSSIBILE = 1;
	public final MarcaGomme GOMME_IMPOSSIBILE= GameConstants.gomme.metzler;
	
}
