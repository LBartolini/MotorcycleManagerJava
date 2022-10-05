package core.moto.gomma.marche;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaStradale;

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
