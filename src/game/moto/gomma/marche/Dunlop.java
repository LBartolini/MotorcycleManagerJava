package game.moto.gomma.marche;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.mescole.GommaBagnatoLeggero;
import game.moto.gomma.mescole.GommaMedia;
import game.moto.gomma.mescole.GommaStradale;

public class Dunlop extends MarcaGomme{

	public Dunlop() {
		super("Dunlop");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
		this.addGomma(new GommaMedia());
	}
	
}
