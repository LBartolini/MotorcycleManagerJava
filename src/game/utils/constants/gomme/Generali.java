package game.utils.constants.gomme;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.marche.Bridgeston;
import game.moto.gomma.marche.Continental;
import game.moto.gomma.marche.Dunlop;
import game.moto.gomma.marche.Metzler;
import game.moto.gomma.marche.Michelin;
import game.moto.gomma.marche.Pirelli;

public class Generali {
	
	public static final MarcaGomme pirelli = new Pirelli();
	public static final MarcaGomme michelin = new Michelin();
	public static final MarcaGomme bridgeston = new Bridgeston();
	public static final MarcaGomme dunlop = new Dunlop();
	public static final MarcaGomme continental = new Continental();
	public static final MarcaGomme metzler = new Metzler();
	
	public static final double MODIFICATORE_MESCOLA_SBAGLIATA = 0.3;
	
}
