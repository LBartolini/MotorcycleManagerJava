package core.moto.gomma.marche;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaStradale;

public class Metzler extends MarcaGomme{

	public Metzler() {
		super("Metzler");
		
		this.addGomma(new GommaStradale());
	}

}
