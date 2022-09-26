package game.moto;

public class Componente {
	
	private String nome;
	private int gradoComponente;
	private int livelloResistenza;
	private boolean guasto;
	
	public Componente(String nome, int gradoComponente, int livelloResistenza) {
		this.nome = nome;
		this.gradoComponente = gradoComponente;
		this.livelloResistenza = livelloResistenza;
		this.guasto = false;
	}
	
	public int getProbabilitàGuasto() {
		// TODO
		return 0;
	}
	
	public boolean isGuasto() {
		return guasto;
	}
	
}
