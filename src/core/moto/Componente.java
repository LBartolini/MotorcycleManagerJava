package core.moto;

import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;

public class Componente {
	
	protected static int MIN_CAMPO = 1, MAX_CAMPO = 30;
	private int MIN_PROB_GUASTO, MAX_PROB_GUASTO;
	
	private String nome;

	private Campo gradoComponente; // [1, 30]
	private Campo resistenzaComponente; // [1, 30]
	
	public Componente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		initComponente(nome, gradoComponente, livelloResistenza, minProbGuasto, maxProbGuasto);
	}
	
	public Componente(String nome, Difficolta diff) {
		initComponente(nome, 
				diff.getGradoComponenteIniziale(), 
				diff.getResistenzaComponenteIniziale(), 
				diff.getMinProbabilitaGuasto(), 
				diff.getMaxProbabilitaGuasto());
	}
	
	private void initComponente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		this.nome = nome;
		this.gradoComponente = new Campo(gradoComponente, MIN_CAMPO, MAX_CAMPO);
		this.resistenzaComponente = new Campo(livelloResistenza, MIN_CAMPO, MAX_CAMPO);
		this.MIN_PROB_GUASTO = minProbGuasto;
		this.MAX_PROB_GUASTO = maxProbGuasto;
	}
	
	
	public int getProbabilitaGuasto() {
		Funzione<Integer> f = new FunzioneLineareInt(MAX_PROB_GUASTO, MIN_PROB_GUASTO, resistenzaComponente.getMax());
		
		return f.getValue(resistenzaComponente.get());
	}
	
	public String getNome() {
		return nome;
	}
	
	public CampoInterface getGrado() {
		return gradoComponente;
	}
	
	public CampoInterface getResistenza() {
		return resistenzaComponente;
	}

	public void upgradeGrado(){ 
		gradoComponente.increment();
	}	

	public void upgradeResistenza(){
		resistenzaComponente.increment();
	}
	
}
