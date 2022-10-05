package core.moto.gomma.marche;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaSoft;
import core.moto.gomma.mescole.GommaStradale;

public class Pirelli extends MarcaGomme{

	public Pirelli() {
		super("Pirelli");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
		this.addGomma(new GommaMedia());
		this.addGomma(new GommaHard());
		this.addGomma(new GommaBagnatoPesante());
		this.addGomma(new GommaSoft());
	}

}
