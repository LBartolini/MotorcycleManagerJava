package core;

import core.moto.Moto;
import core.stile_guida.StileGuida;
import core.stile_guida.StileNormale;
import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.campo.CampoPilota;

public class Pilota {
	
	private String nome, cognome;
	private Campo aggressivita, forzaFisica, agilita, feelingMoto;
	
	private Moto moto;
	
	private StileGuida stileScelto;
	
	// TODO costruttore per difficolta che setti i vari campi
	
	public Pilota(String nome, String cognome, Moto moto, int aggressivita, int forzaFisica, int agilita) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new CampoPilota(aggressivita);
		this.forzaFisica = new CampoPilota(forzaFisica);
		this.feelingMoto = new CampoPilota();
		this.agilita = new CampoPilota(agilita);
		this.moto = moto;
		stileScelto = new StileNormale();
	}
	
	public void preGara(StileGuida stileScelto) {
		this.stileScelto = stileScelto;
	}
	
	public StileGuida getStileGuida() {
		return stileScelto;
	}
	
	public void incrementaAggressivita() {
		aggressivita.increment();
	}
	
	public void incrementaForzaFisica() {
		forzaFisica.increment();
	}
	
	public void incrementaFeelingMoto() {
		feelingMoto.increment();
	}
	
	public void incrementaAgilita() {
		agilita.increment();
	}
	
	public void cambioMoto(Moto nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = new CampoPilota();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public CampoInterface getAggressivita() {
		return aggressivita;
	}
	
	public CampoInterface getForzaFisica() {
		return forzaFisica;
	}

	public CampoInterface getFeelingMoto() {
		return feelingMoto;
	}
	
	public CampoInterface getAgilita() {
		return agilita;
	}

	public Moto getMoto() {
		return moto;
	}
	
}
