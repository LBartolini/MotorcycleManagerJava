package core.moto;

import Exceptions.ValueNotInRangeException;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class Componente {
	
	public static final int MAX_GRADO = 30;
	public static final int MAX_RESISTENZA = 30;
	
	private int MIN_PROB_GUASTO, MAX_PROB_GUASTO;
	
	private String nome;

	private int gradoComponente; // [1, 30]
	private int livelloResistenza; // [1, 30]
	
	public Componente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		initComponente(nome, gradoComponente, livelloResistenza, minProbGuasto, maxProbGuasto);
	}
	
	public Componente(String nome, Difficolta diff) {
		initComponente(nome, 
				diff.getGradoComponenteIniziale(), 
				diff.getResistenzaComponenteIniziale(), 
				diff.getMinProbabiitaGuasto(), 
				diff.getMaxProbabiitaGuasto());
	}
	
	private void initComponente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		this.nome = nome;
		this.gradoComponente = gradoComponente;
		this.livelloResistenza = livelloResistenza;
		this.MIN_PROB_GUASTO = minProbGuasto;
		this.MAX_PROB_GUASTO = maxProbGuasto;
	}
	
	
	public int getProbabilitaGuasto() {
		Funzione f = new FunzioneLineare(MAX_PROB_GUASTO, MIN_PROB_GUASTO, MAX_RESISTENZA);
		
		return f.getValue(livelloResistenza);
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getGrado() {
		return gradoComponente;
	}
	
	public int getResistenza() {
		return livelloResistenza;
	}

	public void upgradeGrado() throws ValueNotInRangeException{
		if(gradoComponente == MAX_GRADO) throw new ValueNotInRangeException("Grado massimo raggiunto!");

		gradoComponente++;
	}	

	public void upgradeResistenza() throws ValueNotInRangeException{
		if(livelloResistenza == MAX_RESISTENZA) throw new ValueNotInRangeException("Resistenza massima raggiunta!");
		
		livelloResistenza++;;
	}
	
}
