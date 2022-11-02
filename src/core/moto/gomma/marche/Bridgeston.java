package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaStradale;

public class Bridgeston extends MarcaGomme{
	
	private static Bridgeston obj = null;

	public static Bridgeston create() {
		if(obj == null) {
			obj = new Bridgeston();
		}
		
		return obj;
	}

	private Bridgeston() {
		super("Bridgeston", Set.of(new GommaStradale(),
				new GommaBagnatoLeggero(),
				new GommaMedia(),
				new GommaHard()));
	}

}
