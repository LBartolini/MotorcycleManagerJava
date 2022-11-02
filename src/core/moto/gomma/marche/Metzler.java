package core.moto.gomma.marche;

import java.util.Set;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.mescole.GommaStradale;

public class Metzler extends MarcaGomme{

	private static Metzler obj;

	public static Metzler create() {
		if(obj == null) {
			obj = new Metzler();
		}
		
		return obj;
	}

	private Metzler() {
		super("Metzler", Set.of(new GommaStradale()));
	}

}
