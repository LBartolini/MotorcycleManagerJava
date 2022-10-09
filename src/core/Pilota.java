package core;

import Exceptions.ValueNotInRangeException;
import core.moto.Moto;

public class Pilota {

	public static final int MAX_AGGRESSIVITA = 10, MAX_FORZA_FISICA = 30, MAX_FEELING_MOTO = 30;
	
	private String nome, cognome;
	private int aggressivita, forzaFisica, feelingMoto;
	
	private Moto moto;
	
	public Pilota(String nome, String cognome, Moto moto, int aggressivita, int forzaFisica) throws ValueNotInRangeException {
		if(aggressivita < 0 || aggressivita > MAX_AGGRESSIVITA) throw new ValueNotInRangeException("Aggressività out of range!");
		if(forzaFisica < 0 || forzaFisica > MAX_FORZA_FISICA) throw new ValueNotInRangeException("Forza fisica out of range!");
		
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = aggressivita;
		this.forzaFisica = forzaFisica;
		this.feelingMoto = 1;
		this.moto = moto;
	}
	
	public void incrementaAggressivita() throws Exception {
		if(aggressivita == MAX_AGGRESSIVITA) throw new Exception("Max aggressivita reached");
		
		aggressivita++;
	}
	
	public void incrementaForzaFisica() throws Exception {
		if(forzaFisica == MAX_FORZA_FISICA) throw new Exception("Max forza reached");
		
		forzaFisica++;
	}
	
	public void incrementaFeelingMoto() throws Exception {
		if(feelingMoto == MAX_FEELING_MOTO) throw new Exception("Max feeling moto reached");
		
		feelingMoto++;
	}
	
	public void cambioMoto(Moto nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = 1;
	}

	public int getAggressivita() {
		return aggressivita;
	}

	public void setAggressivita(int aggressivita) {
		this.aggressivita = aggressivita;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getForzaFisica() {
		return forzaFisica;
	}

	public int getFeelingMoto() {
		return feelingMoto;
	}

	public Moto getMoto() {
		return moto;
	}
	
}
