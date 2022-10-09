package core;

import java.util.Objects;
import java.util.Random;

import core.moto.Moto;
import core.utils.TempoSuGiro;

public class Pista {
	
	private static final int MAX_PROB_CADUTA = 10;
	private static int progressivo = 0;
	
	private int idPista;
	private String nomePista;
	
	private int nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente, nGiri, nSpettatori;
	private TempoSuGiro tempoMassimo;
	
	private int gommaturaPista, probCadutaPista;
	private Meteo meteo;
	

	public Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, TempoSuGiro tempoMassimo) {
		this.idPista = ++progressivo;
		
		this.nomePista = nomePista;
		this.nRettilinei = nRettilinei;
		this.nTrattiGuidati = nTrattiGuidati;
		this.nCurveVeloci = nCurveVeloci;
		this.nCurveLente = nCurveLente;
		this.nGiri = nGiri;
		this.tempoMassimo = tempoMassimo;

	}

	public void initGara(Meteo meteo) {
		Random random = new Random();
		
		this.gommaturaPista = 0;
		this.probCadutaPista = random.nextInt(MAX_PROB_CADUTA) + 1;
		this.meteo = meteo;
	}
	
	public double getTempoSulGiro(Moto moto, Pilota pilota) {
		// TODO
		return 0;
	}
	
	public int getNCurve() {
		return nCurveLente + nCurveVeloci;
	}
	
	private int getCoeffRettilinei() {
		return 2*Math.min(nRettilinei+1, 5);
	}
	
	private int getCoeffTrattiGuidati() {
		return Math.min(nTrattiGuidati*2 + 1, 10);
	}
	
	private int getCoeffCurveLente() {
		return Math.min(nCurveLente + 1, 10);
	}
	
	private int getCoeffCurveVeloci() {
		return Math.min(nCurveVeloci + 1, 10);
	}
	
	private boolean getCadutaMotoPilota(Pilota pilota, Moto moto) {
		
		// TODO da calcolare all'inizio della gara e poi decidere un giro in cui far cadere il pilota
		
		return false;
	}

	public int getIdPista() {
		return idPista;
	}

	public String getNomePista() {
		return nomePista;
	}

	public int getnGiri() {
		return nGiri;
	}

	public int getnSpettatori() {
		return nSpettatori;
	}

	public TempoSuGiro getTempoMassimo() {
		return tempoMassimo;
	}

	public int getGommaturaPista() {
		return gommaturaPista;
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
