package game.moto.gomma.marche;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.mescole.GommaBagnatoLeggero;
import game.moto.gomma.mescole.GommaStradale;

public class Continental extends MarcaGomme{

	public Continental() {
		super("Continental");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
	}

}

