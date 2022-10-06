package core.moto;

import Exceptions.LivelloMassimoDelParametroException;
import core.utils.constants.difficolta.Difficile;
import core.utils.constants.difficolta.Difficolta;
import core.utils.constants.difficolta.Facile;
import core.utils.constants.difficolta.Impossibile;
import core.utils.constants.difficolta.Intermedia;
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
		switch(diff) {
			case DIFF_FACILE:
				initComponente(nome, 
						Facile.GRADO_INIZIALE, 
						Facile.RESISTENZA_INIZIALE, 
						Facile.MIN_PROB_GUASTO, 
						Facile.MAX_PROB_GUASTO);
				break;
				
			case DIFF_INTERMEDIA:
				initComponente(nome, 
						Intermedia.GRADO_INIZIALE, 
						Intermedia.RESISTENZA_INIZIALE, 
						Intermedia.MIN_PROB_GUASTO, 
						Intermedia.MAX_PROB_GUASTO);
				break;
			
			case DIFF_DIFFICILE:
				initComponente(nome, 
						Difficile.GRADO_INIZIALE, 
						Difficile.RESISTENZA_INIZIALE,
						Difficile.MIN_PROB_GUASTO, 
						Difficile.MAX_PROB_GUASTO);
				break;
			
			case DIFF_IMPOSSIBILE:
				initComponente(nome, 
						Impossibile.GRADO_INIZIALE, 
						Impossibile.RESISTENZA_INIZIALE,
						Impossibile.MIN_PROB_GUASTO, 
						Impossibile.MAX_PROB_GUASTO);
				break;
		}
	}
	
	public void initComponente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
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

	public void upgradeGrado() throws LivelloMassimoDelParametroException{
		if(gradoComponente == MAX_GRADO) throw new LivelloMassimoDelParametroException();

		gradoComponente++;
	}	

	public void upgradeResistenza() throws LivelloMassimoDelParametroException{
		if(livelloResistenza == MAX_RESISTENZA) throw new LivelloMassimoDelParametroException();
		
		livelloResistenza++;;
	}
	
}