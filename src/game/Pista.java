package game;

import java.util.Random;

import game.utils.TempoSuGiro;

public class Pista {
	
	private static int progressivo = 0;
	private static final int minNRettilinei = 1, minNCurveTot = 2, minNGiri = 5;
	
	private int idPista;
	private String nomePista;
	
	private int nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente, nGiri, nSpettatori;
	private TempoSuGiro tempoMassimo, tempoMassimoDefault;
	
	private int gommaturaPista, probCaduta;
	

	public Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, TempoSuGiro tempoMassimoDefault) throws Exception {
		this.idPista = progressivo;
		
		this.nomePista = nomePista;
		this.nRettilinei = nRettilinei;
		this.nTrattiGuidati = nTrattiGuidati;
		this.nCurveVeloci = nCurveVeloci;
		this.nCurveLente = nCurveLente;
		this.nGiri = nGiri;
		this.tempoMassimoDefault = tempoMassimo;
		
		if(mismatchCondizioniMinime()) throw new Exception("Match minimum conditions!");
		
		progressivo++;
	}
	
	private boolean mismatchCondizioniMinime() { // true = bad, false = ok
		if(nRettilinei < minNRettilinei || getNCurve() < minNCurveTot || nGiri < minNGiri) return true;
		return false;
	}

	public void initGara(double moltiplicatoreTempoMassimo) {
		Random random = new Random();
		
		this.gommaturaPista = 0;
		this.probCaduta = random.nextInt(100) + 1;
		
		this.tempoMassimo = new TempoSuGiro((int)(this.tempoMassimoDefault.getTempoInMillisecondi() * moltiplicatoreTempoMassimo));
	}
	
	public double getTempoSulGiro(Moto moto, Pilota pilota) {
		// TODO
		return 0;
	}
	
	public int getNCurve() {
		return nCurveLente + nCurveVeloci;
	}
	
	private int getCoeffRettilinei() {
		return Math.min(nRettilinei+1, 5);
	}
	
	private int getCoeffTrattiGuidati() {
		return Math.min(nTrattiGuidati*2 + 1, 10);
	}
	
	public int getCoeffCurveLente() {
		return Math.min(nCurveLente + 1, 10);
	}
	
	public int getCoeffCurveVeloci() {
		return Math.min(nCurveVeloci + 1, 10);
	}
	
}
