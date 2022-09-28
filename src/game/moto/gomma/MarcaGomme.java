package game.moto.gomma;

import java.util.List;

public abstract class MarcaGomme {

	private String nome;
	private List<Gomma> gommeDisponibili;
	
	public MarcaGomme(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Gomma> getGommeDisponibili(){
		return gommeDisponibili;
	}
	
	protected void addGomma(Gomma gomma) {
		gommeDisponibili.add(gomma);
	}
	
}
