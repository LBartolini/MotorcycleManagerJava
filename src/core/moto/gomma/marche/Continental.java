package core.moto.gomma.marche;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaStradale;

public class Continental extends MarcaGomme{

	public Continental() {
		super("Continental");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
	}

}

