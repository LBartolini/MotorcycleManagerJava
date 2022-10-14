package core.moto;

import core.utils.campo.Campo;
import core.utils.campo.CampoMoto;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class Componente {
	
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
				diff.getMinProbabiitaGuasto(), 
				diff.getMaxProbabiitaGuasto());
	}
	
	private void initComponente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		this.nome = nome;
		this.gradoComponente = new CampoMoto(gradoComponente);
		this.resistenzaComponente = new CampoMoto(livelloResistenza);
		this.MIN_PROB_GUASTO = minProbGuasto;
		this.MAX_PROB_GUASTO = maxProbGuasto;
	}
	
	
	public int getProbabilitaGuasto() {
		Funzione f = new FunzioneLineare(MAX_PROB_GUASTO, MIN_PROB_GUASTO, new CampoMoto().getMax());
		
		return f.getValue(resistenzaComponente.get());
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getGrado() {
		return gradoComponente.get();
	}
	
	public int getResistenza() {
		return resistenzaComponente.get();
	}

	public void upgradeGrado(){ 
		gradoComponente.increment();
	}	

	public void upgradeResistenza(){
		resistenzaComponente.increment();
	}
	
}
