package game.moto.gomma.marche;

import game.moto.gomma.MarcaGomme;
import game.moto.gomma.mescole.GommaStradale;

public class Metzler extends MarcaGomme{

	public Metzler() {
		super("Metzler");
		
		this.addGomma(new GommaStradale());
	}

}
