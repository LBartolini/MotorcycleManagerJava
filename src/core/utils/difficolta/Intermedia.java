package core.utils.difficolta;

import java.util.Objects;

import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Michelin;

public class Intermedia implements Difficolta{
	
	private static final int COEFF_LUCIDITA_CADUTA = 5;
	private static final int GRADO_COMPONENTE_INIZIALE = 5;
	private static final int RESISTENZA_INIZIALE = 10;
	
	private static final int AGGRESSIVITA_INIZIALE = 12;
	private static final int FORZAFISICA_INIZIALE = 12;
	private static final int AGILITA_INIZIALE = 12;
	
	private static final int MIN_PROB_GUASTO = 0;
	private static final int MAX_PROB_GUASTO = 10;
	
	private static final Double MOLTIPLICATORE_CADUTA = 0.9;
	
	private static final double MIN_FUNZ_COEFF_PISTA = 0.8;
	private static final double MAX_FUNZ_COEFF_PISTA = 1.6;
	
	private static Intermedia obj = null;
	
	public static Intermedia create() {
		if(Objects.isNull(obj)) {
			obj = new Intermedia();
		}
		return obj;
	}

	private Intermedia(){
		
	}
	
	@Override
	public MarcaGomme getMarcaGomme() {
		return Michelin.create();
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
		// TODO Auto-generated method stub
		return MIN_FUNZ_COEFF_PISTA;
	}

	@Override
	public double getMaxFunzioneCoefficientiPista() {
		// TODO Auto-generated method stub
		return MAX_FUNZ_COEFF_PISTA;
	}

	@Override
	public int getCoeffParametriPilotaCaduta() {
		return COEFF_LUCIDITA_CADUTA;
	}
	
}
