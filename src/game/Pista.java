package game;

import java.util.Random;

import game.moto.Moto;
import game.utils.TempoSuGiro;

public class Pista {
	
	private static int progressivo = 0;
	private static final int minNRettilinei = 1, minNCurveTot = 2, minNGiri = 5;
	
	private int idPista;
	private String nomePista;
	
	private int nRettilinei, nTrattiGuidati, nCurveVeloci, nCurveLente, nGiri, nSpettatori;
	private TempoSuGiro tempoMassimo, tempoMassimoDefault;
	
	private int gommaturaPista, probCadutaPista;
	private Meteo meteo;
	

	public Pista(String nomePista, int nRettilinei, int nTrattiGuidati, int nCurveVeloci, int nCurveLente, int nGiri, int nSpettatori, TempoSuGiro tempoMassimoDefault) throws Exception {
		// TODO bad path testing
		
		this.idPista = ++progressivo;
		
		this.nomePista = nomePista;
		this.nRettilinei = nRettilinei;
		this.nTrattiGuidati = nTrattiGuidati;
		this.nCurveVeloci = nCurveVeloci;
		this.nCurveLente = nCurveLente;
		this.nGiri = nGiri;
		this.tempoMassimoDefault = tempoMassimo;

	}

	public void initGara(double moltiplicatoreTempoMassimo, Meteo meteo) {
		Random random = new Random();
		
		this.gommaturaPista = 0;
		this.probCadutaPista = random.nextInt(100) + 1;
		this.meteo = meteo;
		
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
	
	private int getProbCadutaMotoPilota(Pilota pilota, Moto moto) {
		// TODO considerare anche lo stato di usura delle gomme
		
		return 0;
	}
	
}
