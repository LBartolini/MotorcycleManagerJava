package core.moto.gomma;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public abstract class MarcaGomme {

	private String nome;
	private Collection<Gomma> gommeDisponibili;
	
	public MarcaGomme(String nome) {
		this.nome = nome;
		this.gommeDisponibili = new HashSet<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public Collection<Gomma> getGommeDisponibili(){
		return gommeDisponibili;
	}
	
	public boolean isGommaDisponibile(Gomma gomma) {
		return gommeDisponibili.contains(gomma);
	}
	
	protected void addGomma(Gomma gomma) {
		gommeDisponibili.add(gomma);
	}
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		MarcaGomme other_moto;
		
		try {
			other_moto = (MarcaGomme) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return nome.equals(other_moto.getNome());
	}
	
}
