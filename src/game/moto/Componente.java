package game.moto;

import game.utils.constants.difficolta.Difficile;
import game.utils.constants.difficolta.Difficolta;
import game.utils.constants.difficolta.Facile;
import game.utils.constants.difficolta.Impossibile;
import game.utils.constants.difficolta.Intermedia;

public class Componente {
	
	private int MIN_PROB_GUASTO, MAX_PROB_GUASTO;
	
	private String nome;
	private int gradoComponente;
	private int livelloResistenza;
	
	public Componente(String nome, int gradoComponente, int livelloResistenza, int minProbGuasto, int maxProbGuasto) {
		initComponente(nome, gradoComponente, livelloResistenza, minProbGuasto, maxProbGuasto);
	}
	
	public Componente(String nome, Difficolta diff) {
		switch(diff) {
			case DIFF_FACILE:
				initComponente(nome, 
						Facile.GRADO_COMPONENTE, 
						Facile.RESISTENZA_COMPONENTE, 
						Facile.MIN_PROB_GUASTO_COMPONENTE, 
						Facile.MAX_PROB_GUASTO_COMPONENTE);
				break;
				
			case DIFF_INTERMEDIA:
				initComponente(nome, 
						Intermedia.GRADO_COMPONENTE, 
						Intermedia.RESISTENZA_COMPONENTE, 
						Intermedia.MIN_PROB_GUASTO_COMPONENTE, 
						Intermedia.MAX_PROB_GUASTO_COMPONENTE);
				break;
			
			case DIFF_DIFFICILE:
				initComponente(nome, 
						Difficile.GRADO_COMPONENTE, 
						Difficile.RESISTENZA_COMPONENTE,
						Difficile.MIN_PROB_GUASTO_COMPONENTE, 
						Difficile.MAX_PROB_GUASTO_COMPONENTE);
				break;
			
			case DIFF_IMPOSSIBILE:
				initComponente(nome, 
						Impossibile.GRADO_COMPONENTE, 
						Impossibile.RESISTENZA_COMPONENTE,
						Impossibile.MIN_PROB_GUASTO_COMPONENTE, 
						Impossibile.MAX_PROB_GUASTO_COMPONENTE);
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
	
	
	public int getProbabilitàGuasto() {
		// TODO
		return 0;
	}
	
}
