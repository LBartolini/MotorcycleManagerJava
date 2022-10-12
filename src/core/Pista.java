package core;

import java.util.Objects;
import java.util.Random;

import core.moto.Moto;
import core.moto.gomma.Gomma;
import core.utils.TempoSuGiro;
import core.utils.difficolta.Difficolta;

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

	public void initGara(Meteo meteo) {
		Random random = new Random();
		
		this.probCadutaPista = random.nextInt(MAX_PROB_CADUTA/3) + 1;
		this.meteo = meteo;
	}
	
	public double getTempoSulGiro(int giro, Moto moto, Pilota pilota) {
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
