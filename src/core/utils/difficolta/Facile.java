package core.utils.difficolta;

import java.util.Objects;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Pirelli;

public class Facile implements Difficolta {
	
	private static final int GRADO_COMPONENTE_INIZIALE = 10;
	private static final int RESISTENZA_INIZIALE = 15;
	
	private static final int AGGRESSIVITA_INIZIALE = 15;
	private static final int FORZAFISICA_INIZIALE = 15;
	private static final int AGILITA_INIZIALE = 15;
	
	private static final int MIN_PROB_GUASTO = 0;
	private static final int MAX_PROB_GUASTO = 0;
	
	private static final Double MOLTIPLICATORE_CADUTA = 0.5;
	
	private static final double MIN_FUNZ_COEFF_PISTA = 0.85;
	private static final double MAX_FUNZ_COEFF_PISTA = 1.65;
	
	private static final int COEFF_LUCIDITA_CADUTA = 3;
	
	private static Facile obj = null;
	
	public static Facile create() {
		if(Objects.isNull(obj)) {
			obj = new Facile();
		}
		return obj;
	}

	private Facile() {
		
	}
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return Pirelli.create();
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
