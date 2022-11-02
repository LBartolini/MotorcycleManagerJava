package core.moto.gomma;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class MarcaGomme {

	private String nome;
	private Collection<Gomma> gommeDisponibili;
	
	protected MarcaGomme(String nome, Collection<Gomma> collection) {
		this.nome = nome;
		this.gommeDisponibili = collection;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Collection<Gomma> getGommeDisponibili(){
		return gommeDisponibili.stream().collect(Collectors.toUnmodifiableSet());
	}
	
	public boolean isGommaDisponibile(Gomma gomma) {
		return gommeDisponibili.contains(gomma);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gommeDisponibili == null) ? 0 : gommeDisponibili.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MarcaGomme))
			return false;
		MarcaGomme other = (MarcaGomme) obj;
		if (gommeDisponibili == null) {
			if (other.gommeDisponibili != null)
				return false;
		} else if (!gommeDisponibili.equals(other.gommeDisponibili))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
