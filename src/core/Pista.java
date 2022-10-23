package core;

import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;

import Exceptions.ObjectNotInitializedException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.Moto;
import core.moto.gomma.Gomma;
import core.pilota.PilotaInterface;
import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.FunzioneLineareDouble;
import core.utils.tempo.Tempo;
import core.utils.tempo.TempoInterface;

public class Pista {
	
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
	
	private int idPista;
	private String nomePista;
	
	private CampoInterface nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente;
	private int nGiri, nSpettatori;
	private TempoInterface tempoMassimo;
	
	private CampoInterface probCadutaPista;
	private MeteoInterface meteo;
	private Difficolta difficolta;
	

	public Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, Tempo tempoMassimo, Difficolta difficolta) {
		this.idPista = ++progressivo;
		
		initCampiPista(nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente);
		this.nomePista = nomePista;
		this.nGiri = nGiri;
		this.tempoMassimo = tempoMassimo;
		this.difficolta = difficolta;

	}
	
	public Pista(String nomePista, int nGiri, int nSpettatori, Tempo tempoMassimo, Difficolta difficolta) {
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
		this.nRettilinei = new Campo(nRettilinei, MIN_RETTILINEI, MAX_RETTILINEI);
		this.nTrattiGuidati = new Campo(nTrattiGuidati, MIN_TRATTI_GUIDATI, MAX_TRATTI_GUIDATI);
		this.nCurveVeloci = new Campo(nCurveVeloci, MIN_CURVE_VELOCI, MAX_CURVE_VELOCI);
		this.nCurveLente = new Campo(nCurveLente, MIN_CURVE_LENTE, MAX_CURVE_LENTE);
	}

	public void preGara(MeteoInterface meteo) {
		Random random = new Random();
		
		this.probCadutaPista = new Campo(random.nextInt(MAX_PROB_CADUTA/3) + 1, MIN_PROB_CADUTA, MAX_PROB_CADUTA);
		this.meteo = meteo;
	}
	
	public Tempo getTempoSulGiro(int giro, Moto moto) throws ObjectNotInitializedException {
		if(giro > nGiri) return new Tempo(0);
		PilotaInterface pilota = moto.getPilota();
		
		
		double punteggio = 1; 
		// TODO aggiungere punteggio base da difficolta e valori iniziali e finali per le funzioni sotto
		
		CampoInterface feelingMoto = pilota.getFeelingMoto();
		CampoInterface aggressivita = pilota.getAggressivita();
		CampoInterface forzaFisica = pilota.getForzaFisica();
		CampoInterface agilita = pilota.getAgilita();
		
		CampoInterface motore = moto.getMotore().getGrado();
		CampoInterface freni = moto.getFreni().getGrado();
		CampoInterface aerodinamica = moto.getAerodinamica().getGrado();
		CampoInterface ciclistica = moto.getCiclistica().getGrado();
		
		// RETTILINEI
		punteggio += getCoeffRettilinei() * new FunzioneLineareDouble(0.75, 1.5, 0, 1)
				.getValue(DoubleStream.of(
						motore.getInPercentuale(), 
						aerodinamica.getInPercentuale()).average().orElse(0)); 
		
		// TRATTI GUIDATI
		punteggio += getCoeffTrattiGuidati() * new FunzioneLineareDouble(0.75, 1.5, 0, 1)
				.getValue(DoubleStream.of(
						agilita.getInPercentuale(), 
						aerodinamica.getInPercentuale(), 
						ciclistica.getInPercentuale(), 
						forzaFisica.getInPercentuale()).average().orElse(0));
		
		// CURVE LENTE
		punteggio += getCoeffCurveLente() * new FunzioneLineareDouble(0.75, 1.5, 0, 1)
				.getValue(DoubleStream.of(
						agilita.getInPercentuale(), 
						freni.getInPercentuale(), 
						aggressivita.getInPercentuale(), 
						forzaFisica.getInPercentuale()).average().orElse(0));
		
		// CURVE VELOCI
		punteggio += getCoeffCurveVeloci() * new FunzioneLineareDouble(0.75, 1.5, 0, 1)
				.getValue(DoubleStream.of(
						aerodinamica.getInPercentuale(), 
						ciclistica.getInPercentuale(), 
						motore.getInPercentuale()).average().orElse(0));
		
		// STILE DI GUIDA
		punteggio *= pilota.getStileGuida().getMoltiplicatorePrestazione();
		
		// FEELING MOTO
		punteggio *= new FunzioneLineareDouble(0.75, 1.5, 0, 1)
				.getValue(feelingMoto.getInPercentuale()); 
		
		// ADERENZA GOMME
		punteggio *= moto.getGommaScelta().getAderenzaAttuale(giro);
		
		return new Tempo(tempoMassimo.getMillisecondi() * 
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
	
	public boolean getCadutaMotoPilota(PilotaInterface pilota, Moto moto) {
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
		
		// DIFFICOLTA
		soglia *= difficolta.getMoltiplicatoreCaduta();
		
		return new Random().nextInt(100) < Math.min((int) soglia, MAX_PROB_CADUTA);
	}

	public int getIdPista() {
		return idPista;
	}

	public String getNomePista() {
		return nomePista;
	}

	public int getNGiri() {
		return nGiri;
	}

	public int getNSpettatori() {
		return nSpettatori;
	}

	public TempoInterface getTempoMassimo() {
		return tempoMassimo;
	}

	public MeteoInterface getMeteo() {
		return meteo;
	}
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		Pista other_pista;
		
		try {
			other_pista = (Pista) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return idPista == other_pista.getIdPista();
	}
	 
}
