package game.moto.gomma.marche;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.mescole.GommaBagnatoLeggero;
import game.moto.gomma.mescole.GommaHard;
import game.moto.gomma.mescole.GommaMedia;
import game.moto.gomma.mescole.GommaStradale;

public class Bridgeston extends MarcaGomme{

	public Bridgeston() {
		super("Bridgeston");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
		this.addGomma(new GommaMedia());
		this.addGomma(new GommaHard());
	}

}
