package core.utils.difficolta;

import java.util.Objects;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Metzler;

public class Impossibile implements Difficolta{
	
	private static final int COEFF_LUCIDITA_CADUTA = 12;
	private static final int GRADO_COMPONENTE_INIZIALE = 1;
	private static final int RESISTENZA_INIZIALE = 1;
	
	private static final int AGGRESSIVITA_INIZIALE = 5;
	private static final int FORZAFISICA_INIZIALE = 5;
	private static final int AGILITA_INIZIALE = 5;
	
	private static final int MIN_PROB_GUASTO = 5;
	private static final int MAX_PROB_GUASTO = 25;
	
	private static final Double MOLTIPLICATORE_CADUTA = 1.5;
	
	private static final double MIN_FUNZ_COEFF_PISTA = 0.75;
	private static final double MAX_FUNZ_COEFF_PISTA = 1.4;
	
	private static Impossibile obj = null;
	
	public static Impossibile create() {
		if(Objects.isNull(obj)) {
			obj = new Impossibile();
		}
		
		return obj;
	}

	private Impossibile() {
		
	}
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return Metzler.create();
	}
	
	@Override
	public int getGradoComponenteIniziale() {
		return GRADO_COMPONENTE_INIZIALE;
	}

	@Override
	public int getResistenzaComponenteIniziale() {
		return RESISTENZA_INIZIALE;
	}

	@Override
	public int getMinProbabilitaGuasto() {
		return MIN_PROB_GUASTO;
	}

	@Override
	public int getMaxProbabilitaGuasto() {
		return MAX_PROB_GUASTO;
	}

	@Override
	public double getMoltiplicatoreCaduta() {
		return MOLTIPLICATORE_CADUTA;
	}
	
	@Override
	public int getLuciditaIniziale() {
		return AGGRESSIVITA_INIZIALE;
	}

	@Override
	public int getForzaFisicaIniziale() {
		return FORZAFISICA_INIZIALE;
	}

	@Override
	public int getAgilitaIniziale() {
		return AGILITA_INIZIALE;
	}

	@Override
	public double getMinFunzioneCoefficientiPista() {
		return MIN_FUNZ_COEFF_PISTA;
	}

	@Override
	public double getMaxFunzioneCoefficientiPista() {
		return MAX_FUNZ_COEFF_PISTA;
	}

	@Override
	public int getCoeffParametriPilotaCaduta() {
		return COEFF_LUCIDITA_CADUTA;
	}
	
}
