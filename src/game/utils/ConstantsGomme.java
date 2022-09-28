package game.utils;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.marche.Bridgeston;
import game.moto.gomma.marche.Continental;
import game.moto.gomma.marche.Dunlop;
import game.moto.gomma.marche.Metzler;
import game.moto.gomma.marche.Michelin;
import game.moto.gomma.marche.Pirelli;

public class ConstantsGomme {
	
	public final MarcaGomme pirelli = new Pirelli();
	public final MarcaGomme michelin = new Michelin();
	public final MarcaGomme bridgeston = new Bridgeston();
	public final MarcaGomme dunlop = new Dunlop();
	public final MarcaGomme continental = new Continental();
	public final MarcaGomme metzler = new Metzler();
	
	public final double MODIFICATORE_MESCOLA_SBAGLIATA = 0.3;
	
	public final int ADERENZA_INIZIALE_GOMME_SOFT = 100;
	public final int ADERENZA_FINALE_GOMME_SOFT = 30;
	
	public final int ADERENZA_GOMME_MEDIE = 50;
	
	public final int ADERENZA_INIZIALE_GOMME_HARD = 30;
	public final int ADERENZA_FINALE_GOMME_HARD = 80;
	
	public final int ADERENZA_INIZIALE_GOMME_STRADALI = 30;
	public final int ADERENZA_FINALE_GOMME_STRADALI = 20;
	
	public final int ADERENZA_GOMME_BAGNATO_LEGGERO = 40;
	public final int ADERENZA_GOMME_BAGNATO_PESANTE = 55;
	
	
}
