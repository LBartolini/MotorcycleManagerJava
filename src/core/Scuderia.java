package core;

import java.util.ArrayList;
import java.util.List;

import Exceptions.LivelloMassimoDelParametroException;
import core.moto.Moto;

public class Scuderia {

	private static final int MAX_MOTO = 2;
	
	private String nome;
	private List<Moto> moto;
	
	public Scuderia(String nome) {
		this.nome = nome;
		moto = new ArrayList<>();
	}
	
	public void addMoto(Moto m) throws LivelloMassimoDelParametroException {
		if(moto.size() >= MAX_MOTO) throw new LivelloMassimoDelParametroException();
		
		moto.add(m);
	}
	
	public String getNome() {
		return nome;
	}
	public List<Moto> getMoto() {
		return moto;
	}
	
}
