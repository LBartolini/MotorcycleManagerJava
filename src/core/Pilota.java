package core;

import core.moto.Moto;
import core.stile_guida.StileGuida;
import core.stile_guida.StileNormale;
import core.utils.campo.Campo;
import core.utils.campo.CampoPilota;

public class Pilota {
	
	private String nome, cognome;
	private Campo aggressivita, forzaFisica, feelingMoto;
	
	private Moto moto;
	
	private StileGuida stileScelto;
	
	public Pilota(String nome, String cognome, Moto moto, int aggressivita, int forzaFisica) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new CampoPilota(aggressivita);
		this.forzaFisica = new CampoPilota(forzaFisica);
		this.feelingMoto = new CampoPilota();
		this.moto = moto;
		stileScelto = new StileNormale();
	}
	
	public void preGara(StileGuida stileScelto) {
		this.stileScelto = stileScelto;
	}
	
	public StileGuida getStileGuida() {
		return stileScelto;
	}
	
	public void incrementaAggressivita() throws Exception {
		aggressivita.increment();
	}
	
	public void incrementaForzaFisica() throws Exception {
		forzaFisica.increment();
	}
	
	public void incrementaFeelingMoto() throws Exception {
		feelingMoto.increment();
	}
	
	public void cambioMoto(Moto nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = new CampoPilota();
	}

	public int getAggressivita() {
		return aggressivita.get();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getForzaFisica() {
		return forzaFisica.get();
	}

	public int getFeelingMoto() {
		return feelingMoto.get();
	}

	public Moto getMoto() {
		return moto;
	}
	
}
