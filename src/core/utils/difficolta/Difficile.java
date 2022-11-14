package core.utils.difficolta;

import java.util.Objects;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Dunlop;

public class Difficile implements Difficolta{
	
	private static final int GRADO_COMPONENTE_INIZIALE = 2;
	private static final int RESISTENZA_INIZIALE = 5;
	
	private static final int AGGRESSIVITA_INIZIALE = 8;
	private static final int FORZAFISICA_INIZIALE = 8;
	private static final int AGILITA_INIZIALE = 8;
	
	private static final int MIN_PROB_GUASTO = 5;
	private static final int MAX_PROB_GUASTO = 15;
	
	private static final Double MOLTIPLICATORE_CADUTA = 1.25;
	
	private static final double MIN_FUNZ_COEFF_PISTA = 0.75;
	private static final double MAX_FUNZ_COEFF_PISTA = 1.5;
	
	private static Difficile obj = null;
	
	public static Difficile create() {
		if(Objects.isNull(obj)) {
			obj = new Difficile();
		}
		
		return obj;
	}

	private Difficile() {
		
	}
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return Dunlop.create();
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
	public int getAggressivitaIniziale() {
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

}
