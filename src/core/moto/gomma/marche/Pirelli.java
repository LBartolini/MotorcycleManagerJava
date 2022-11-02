package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaSoft;
import core.moto.gomma.mescole.GommaStradale;

public class Pirelli extends MarcaGomme{

	private static Pirelli obj;

	public static Pirelli create() {
		if(obj == null) {
			obj = new Pirelli();
		}
		
		return obj;
	}

	private Pirelli() {
		super("Pirelli", Set.of(new GommaStradale(),
				new GommaBagnatoLeggero(),
				new GommaMedia(),
				new GommaHard(),
				new GommaBagnatoPesante(),
				new GommaSoft()));
	}

}
