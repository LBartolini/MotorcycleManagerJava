package game.moto.gomma;

import java.util.ArrayList;
import java.util.List;

public abstract class MarcaGomme {

	private String nome;
	private List<Gomma> gommeDisponibili;
	
	public MarcaGomme(String nome) {
		this.nome = nome;
		this.gommeDisponibili = new ArrayList<Gomma>();
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
