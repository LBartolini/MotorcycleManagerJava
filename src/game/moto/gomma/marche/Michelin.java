package game.moto.gomma.marche;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.mescole.GommaBagnatoLeggero;
import game.moto.gomma.mescole.GommaBagnatoPesante;
import game.moto.gomma.mescole.GommaHard;
import game.moto.gomma.mescole.GommaMedia;
import game.moto.gomma.mescole.GommaStradale;

public class Michelin extends MarcaGomme{

	public Michelin() {
		super("Michelin");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
		this.addGomma(new GommaMedia());
		this.addGomma(new GommaHard());
		this.addGomma(new GommaBagnatoPesante());
	}

}
