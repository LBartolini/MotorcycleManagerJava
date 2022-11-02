package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaStradale;

public class Michelin extends MarcaGomme{

	private static Michelin obj;

	public static Michelin create() {
		if(obj == null) {
			obj = new Michelin();
		}
		
		return obj;
	}

	private Michelin() {
		super("Michelin", Set.of(new GommaStradale(),
				new GommaBagnatoLeggero(),
				new GommaMedia(),
				new GommaHard(),
				new GommaBagnatoPesante()));
	}

}
