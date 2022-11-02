package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaStradale;

public class Dunlop extends MarcaGomme{

	private static Dunlop obj;

	public static Dunlop create() {
		if(obj == null) {
			obj = new Dunlop();
		}
		
		return obj;
	}

	private Dunlop() {
		super("Dunlop", Set.of(new GommaStradale(),
				new GommaBagnatoLeggero(),
				new GommaMedia()));
	}
	
}
