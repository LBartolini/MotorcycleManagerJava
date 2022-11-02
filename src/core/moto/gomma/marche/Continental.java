package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaStradale;

public class Continental extends MarcaGomme{

	private static Continental obj;

	public static Continental create() {
		if(obj == null) {
			obj = new Continental();
		}
		
		return obj;
	}

	private Continental() {
		super("Continental", Set.of(new GommaStradale(),
				new GommaBagnatoLeggero()));
	}

}

