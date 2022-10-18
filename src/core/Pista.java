package core;

import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;

import Exceptions.ObjectNotInitializedException;
import core.moto.Moto;
import core.moto.gomma.Gomma;
import core.utils.TempoSuGiro;
import core.utils.campo.CampoInterface;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.FunzioneLineareDouble;

public class Pista {
	
	private static final int MAX_PROB_CADUTA = 30;
	private static int progressivo = 0;
	
	private int idPista;
	private String nomePista;
	
	private int nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente, nGiri, nSpettatori;
	private TempoSuGiro tempoMassimo;
	
	private int probCadutaPista;
	private Meteo meteo;
	private Difficolta difficolta;
	

	public Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, TempoSuGiro tempoMassimo, Difficolta difficolta) {
		this.idPista = ++progressivo;
		
		this.nomePista = nomePista;
		this.nRettilinei = nRettilinei;
		this.nTrattiGuidati = nTrattiGuidati;
		this.nCurveVeloci = nCurveVeloci;
		this.nCurveLente = nCurveLente;
		this.nGiri = nGiri;
		this.tempoMassimo = tempoMassimo;
		this.difficolta = difficolta;

	}

	public void preGara(Meteo meteo) {
		Random random = new Random();
		
		this.probCadutaPista = random.nextInt(MAX_PROB_CADUTA/3) + 1;
		this.meteo = meteo;
	}
	
	public TempoSuGiro getTempoSulGiro(int giro, Moto moto, Pilota pilota) throws ObjectNotInitializedException {
		if(giro > nGiri) return new TempoSuGiro(0);
		// TODO richiedere solo Moto perchè il pilota può essere ottenuta dala moto
		
		
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
		
		return new TempoSuGiro(tempoMassimo.getTempoInMillisecondi() * 
				(100 - Math.min((int) punteggio, 100)) / 100);
	}
	
	private int getCoeffRettilinei() {
		return Math.min(2*nRettilinei+1, 10);
	}
	
	private int getCoeffTrattiGuidati() {
		return Math.min(2*nTrattiGuidati + 1, 10);
	}
	
	private int getCoeffCurveLente() {
		return Math.min(nCurveLente + 1, 10);
	}
	
	private int getCoeffCurveVeloci() {
		return Math.min(nCurveVeloci + 1, 10);
	}
	
	public boolean getCadutaMotoPilota(Pilota pilota, Moto moto) {
		double soglia = probCadutaPista;
		
		// PIOGGIA
		if(meteo.getQuantitaPioggiaFinale() > 0) {
			soglia *= Meteo.MODIFICATORE_PROB_CADUTA_CON_PIOGGIA;
		}
		
		// GOMME DA ASCIUTTO SU PIOGGIA
		if(meteo.getQuantitaPioggiaFinale() > 0 && moto.getGommaScelta().daAsciutto()) {
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

	public TempoSuGiro getTempoMassimo() {
		return tempoMassimo;
	}

	public Meteo getMeteo() {
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
