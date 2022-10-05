package core.moto.gomma.marche;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaStradale;

public class Dunlop extends MarcaGomme{

	public Dunlop() {
		super("Dunlop");
		
		this.addGomma(new GommaStradale());
		this.addGomma(new GommaBagnatoLeggero());
		this.addGomma(new GommaMedia());
	}
	
}
