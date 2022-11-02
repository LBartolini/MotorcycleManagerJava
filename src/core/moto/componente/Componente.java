package core.moto.componente;

import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.campo.CampoModifiableInterface;
import core.utils.difficolta.Difficolta;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class Componente implements ComponenteModifiableInterface {
	
	protected static int MIN_CAMPO = 1, MAX_CAMPO = 30;
	private int MIN_PROB_GUASTO, MAX_PROB_GUASTO;
	
	private String nome;

	private CampoModifiableInterface gradoComponente, resistenzaComponente; // [1, 30]
	
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
	
	
	@Override
	public int getProbabilitaGuasto() {
		Funzione<Integer> f = new FunzioneLineare<>(MAX_PROB_GUASTO, MIN_PROB_GUASTO, resistenzaComponente.getMax());
		
		return f.getValue(resistenzaComponente.get()).intValue();
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public CampoInterface getGrado() {
		return gradoComponente;
	}
	
	@Override
	public CampoInterface getResistenza() {
		return resistenzaComponente;
	}

	@Override
	public void upgradeGrado(){ 
		gradoComponente.increment();
	}	

	@Override
	public void upgradeResistenza(){
		resistenzaComponente.increment();
	}
	
}
