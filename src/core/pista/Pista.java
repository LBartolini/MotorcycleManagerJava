package core.pista;

import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;

import Exceptions.ObjectNotInitializedException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.MotoInterface;
import core.moto.gomma.Gomma;
import core.pilota.PilotaInterface;
import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.FunzioneLineare;
import core.utils.tempo.Tempo;
import core.utils.tempo.TempoInterface;

public class Pista implements PistaModifiableInterface {
	
	private static final int MAX_RETTILINEI=5, 
			MAX_CURVE_VELOCI=10, 
			MAX_CURVE_LENTE=10, 
			MAX_TRATTI_GUIDATI=5;
	
	private static final int MIN_RETTILINEI=1, 
			MIN_CURVE_VELOCI=1, 
			MIN_CURVE_LENTE=1, 
			MIN_TRATTI_GUIDATI=1;
	
	private static final int MAX_PROB_CADUTA = 30,
			MIN_PROB_CADUTA = 0;
	private static int progressivo = 0;
	
	public static Pista createPista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci,
			int nCurveLente, int nGiri, int nSpettatori, Tempo tempoMassimo, Difficolta difficolta) {
		return new Pista(nomePista, nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente, nGiri, nSpettatori,
				tempoMassimo, difficolta);
	}

	public static Pista createPistaRandom(String nomePista, int nGiri, int nSpettatori, Tempo tempoMassimo,
			Difficolta difficolta) {
		return new Pista(nomePista, nGiri, nSpettatori, tempoMassimo, difficolta);
	}

	private int idPista;
	private String nomePista;
	
	private CampoInterface nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente;
	private int nGiri, nSpettatori;
	private TempoInterface tempoMassimo;
	
	private CampoInterface probCadutaPista;
	private MeteoInterface meteo;
	private Difficolta difficolta;
	

	private Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, Tempo tempoMassimo, Difficolta difficolta) {
		this.idPista = ++progressivo;
		
		initCampiPista(nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente);
		this.nomePista = nomePista;
		this.nGiri = nGiri;
		this.tempoMassimo = tempoMassimo;
		this.difficolta = difficolta;

	}
	
	private Pista(String nomePista, int nGiri, int nSpettatori, Tempo tempoMassimo, Difficolta difficolta) {
		Random random = new Random();
		
		initCampiPista(random.nextInt(MAX_RETTILINEI), 
				random.nextInt(MAX_TRATTI_GUIDATI), 
				random.nextInt(MAX_CURVE_VELOCI), 
				random.nextInt(MAX_CURVE_LENTE));
		this.nomePista = nomePista;
		this.nGiri = nGiri;
		this.tempoMassimo = tempoMassimo;
		this.difficolta = difficolta;
	}
	
	private void initCampiPista(int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente) {
		this.nRettilinei = Campo.createCampo(nRettilinei, MIN_RETTILINEI, MAX_RETTILINEI);
		this.nTrattiGuidati = Campo.createCampo(nTrattiGuidati, MIN_TRATTI_GUIDATI, MAX_TRATTI_GUIDATI);
		this.nCurveVeloci = Campo.createCampo(nCurveVeloci, MIN_CURVE_VELOCI, MAX_CURVE_VELOCI);
		this.nCurveLente = Campo.createCampo(nCurveLente, MIN_CURVE_LENTE, MAX_CURVE_LENTE);
	}

	@Override
	public void preGara(MeteoInterface meteo) {
		Random random = new Random();
		
		this.probCadutaPista = Campo.createCampo(random.nextInt(MAX_PROB_CADUTA/3) + 1, MIN_PROB_CADUTA, MAX_PROB_CADUTA);
		this.meteo = meteo;
	}
	
	@Override
	public TempoInterface getTempoSulGiro(int giro, MotoInterface moto) throws ObjectNotInitializedException {
		if(giro > nGiri) return Tempo.createTempoFromMillisecondi(0);
		PilotaInterface pilota = moto.getPilota();
		
		
		double punteggio = 1; 
		
		CampoInterface feelingMoto = pilota.getFeelingMoto();
		CampoInterface aggressivita = pilota.getLucidita();
		CampoInterface forzaFisica = pilota.getForzaFisica();
		CampoInterface agilita = pilota.getAgilita();
		
		CampoInterface motore = moto.getMotore().getGrado();
		CampoInterface freni = moto.getFreni().getGrado();
		CampoInterface aerodinamica = moto.getAerodinamica().getGrado();
		CampoInterface ciclistica = moto.getCiclistica().getGrado();
		
		
		FunzioneLineare funzioneLineare = new FunzioneLineare(difficolta.getMinFunzioneCoefficientiPista(), difficolta.getMaxFunzioneCoefficientiPista(), 0.0, 1.0);
		
		// RETTILINEI
		punteggio += getCoeffRettilinei() * funzioneLineare
				.getValue(DoubleStream.of(
						motore.getPercentuale(), 
						aerodinamica.getPercentuale()).average().orElse(0)).doubleValue(); 
		
		// TRATTI GUIDATI
		punteggio += getCoeffTrattiGuidati() * funzioneLineare
				.getValue(DoubleStream.of(
						agilita.getPercentuale(), 
						aerodinamica.getPercentuale(), 
						ciclistica.getPercentuale(), 
						forzaFisica.getPercentuale()).average().orElse(0)).doubleValue();
		
		// CURVE LENTE
		punteggio += getCoeffCurveLente() * funzioneLineare
				.getValue(DoubleStream.of(
						agilita.getPercentuale(), 
						freni.getPercentuale(), 
						aggressivita.getPercentuale(), 
						forzaFisica.getPercentuale()).average().orElse(0)).doubleValue();
		
		// CURVE VELOCI
		punteggio += getCoeffCurveVeloci() * funzioneLineare
				.getValue(DoubleStream.of(
						aerodinamica.getPercentuale(), 
						ciclistica.getPercentuale(), 
						motore.getPercentuale()).average().orElse(0)).doubleValue();
		
		// STILE DI GUIDA
		punteggio *= pilota.getStileGuida().getMoltiplicatorePrestazione();
		
		// FEELING MOTO
		punteggio *= funzioneLineare
				.getValue(feelingMoto.getPercentuale()).doubleValue(); 
		
		// ADERENZA GOMME
		punteggio *= moto.getGommaScelta().getAderenzaAttuale(giro);
		
		return Tempo.createTempoFromMillisecondi(tempoMassimo.getMillisecondi() * 
				(100 - Math.min((int) punteggio, 100)) / 100);
	}
	
	private int getCoeffRettilinei() {
		return Math.min(2*nRettilinei.get()+1, 10);
	}
	
	private int getCoeffTrattiGuidati() {
		return Math.min(2*nTrattiGuidati.get() + 1, 10);
	}
	
	private int getCoeffCurveLente() {
		return Math.min(nCurveLente.get() + 1, 10);
	}
	
	private int getCoeffCurveVeloci() {
		return Math.min(nCurveVeloci.get() + 1, 10);
	}
	
	@Override
	public boolean getCadutaMotoPilota(PilotaInterface pilota, MotoInterface moto) {
		double soglia = probCadutaPista.get();
		
		// PIOGGIA
		if(meteo.getPioggiaFinale() > 0) {
			soglia *= Meteo.MODIFICATORE_PROB_CADUTA_CON_PIOGGIA;
		}
		
		// GOMME DA ASCIUTTO SU PIOGGIA
		if(meteo.getPioggiaFinale() > 0 && moto.getGommaScelta().daAsciutto()) {
			soglia *= Gomma.MODIFICATORE_CADUTA_GOMME_SBAGLIATE;
		}
		
		// STILE GUIDA
		soglia *= pilota.getStileGuida().getMoltiplicatoreCaduta();
		
		//LUCIDITA
		soglia += (pilota.getLucidita().getPercentualeInversa()-0.5)
					*difficolta.getCoeffParametriPilotaCaduta();
		
		//LUCIDITA
		soglia += (pilota.getAgilita().getPercentualeInversa()-0.5)
					*difficolta.getCoeffParametriPilotaCaduta();
		
		// DIFFICOLTA
		soglia *= difficolta.getMoltiplicatoreCaduta();
		
		return new Random().nextInt(100) < Math.min(Math.max(MIN_PROB_CADUTA, (int) soglia), MAX_PROB_CADUTA);
	}

	@Override
	public int getIdPista() {
		return idPista;
	}

	@Override
	public String getNomePista() {
		return nomePista;
	}

	@Override
	public int getNGiri() {
		return nGiri;
	}

	@Override
	public int getNSpettatori() {
		return nSpettatori;
	}

	@Override
	public TempoInterface getTempoMassimo() {
		return tempoMassimo;
	}

	@Override
	public MeteoInterface getMeteo() {
		return meteo;
	}
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		PistaInterface other_pista;
		
		try {
			other_pista = (PistaInterface) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return idPista == other_pista.getIdPista();
	}
	 
}
