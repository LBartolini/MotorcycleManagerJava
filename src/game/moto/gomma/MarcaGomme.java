package game.moto.gomma;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MarcaGomme {

	private String nome;
	private Set<Gomma> gommeDisponibili;
	
	public MarcaGomme(String nome) {
		this.nome = nome;
		this.gommeDisponibili = new HashSet<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Gomma> getGommeDisponibili(){
		return gommeDisponibili.stream().collect(Collectors.toList());
	}
	
	public boolean isGommaDisponibile(Gomma gomma) {
		return gommeDisponibili.contains(gomma);
	}
	
	protected void addGomma(Gomma gomma) {
		gommeDisponibili.add(gomma);
	}
	
}
