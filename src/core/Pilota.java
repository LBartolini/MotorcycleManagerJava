package core;

import core.moto.Moto;
import core.stile_guida.StileGuida;
import core.stile_guida.StileNormale;
import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.campo.CampoInterfaceModifiable;
import core.utils.difficolta.Difficolta;

public class Pilota {
	
	private static int MIN_CAMPO=1, MAX_CAMPO=30;
	
	private String nome, cognome;
	private CampoInterfaceModifiable aggressivita, forzaFisica, agilita, feelingMoto;
	
	private Moto moto;
	private StileGuida stileScelto;
	
	public Pilota(String nome, String cognome, Moto moto, Difficolta difficolta) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new Campo(difficolta.getAggressivitaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = new Campo(difficolta.getForzaFisicaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
		this.agilita = new Campo(difficolta.getAgilitaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.moto = moto;
		stileScelto = new StileNormale();
	}
	
	public Pilota(String nome, String cognome, Moto moto, int aggressivita, int forzaFisica, int agilita) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new Campo(aggressivita, MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = new Campo(forzaFisica, MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
		this.agilita = new Campo(agilita, MIN_CAMPO, MAX_CAMPO);
		this.moto = moto;
		stileScelto = new StileNormale();
	}
	
	public void preGara(StileGuida stileScelto) {
		this.stileScelto = stileScelto;
	}
	
	public final StileGuida getStileGuida() {
		return stileScelto;
	}
	
	public final void incrementaAggressivita() {
		aggressivita.increment();
	}
	
	public final void incrementaForzaFisica() {
		forzaFisica.increment();
	}
	
	public final void incrementaFeelingMoto() {
		feelingMoto.increment();
	}
	
	public final void incrementaAgilita() {
		agilita.increment();
	}
	
	public final void cambioMoto(Moto nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
	}

	public final String getNome() {
		return nome;
	}

	public final String getCognome() {
		return cognome;
	}

	public final CampoInterface getAggressivita() {
		return aggressivita;
	}
	
	public final CampoInterface getForzaFisica() {
		return forzaFisica;
	}

	public final CampoInterface getFeelingMoto() {
		return feelingMoto;
	}
	
	public final CampoInterface getAgilita() {
		return agilita;
	}

	public final Moto getMoto() {
		return moto;
	}
	
}
