package core.moto.gomma;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import core.moto.Moto;

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
		return new ArrayList<Gomma>(gommeDisponibili);
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
