package core.pilota;

import core.moto.MotoInterface;
import core.stile_guida.StileGuida;
import core.stile_guida.StileNormale;
import core.utils.campo.Campo;
import core.utils.campo.CampoInterface;
import core.utils.campo.CampoModifiableInterface;
import core.utils.difficolta.Difficolta;

public class Pilota implements PilotaModifiableInterface {
	
	private static int MIN_CAMPO=1, MAX_CAMPO=30;
	
	private String nome, cognome;
	private CampoModifiableInterface aggressivita, forzaFisica, agilita, feelingMoto;
	
	private MotoInterface moto;
	private StileGuida stileScelto;
	
	public Pilota(String nome, String cognome, MotoInterface moto, Difficolta difficolta) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new Campo(difficolta.getAggressivitaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = new Campo(difficolta.getForzaFisicaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
		this.agilita = new Campo(difficolta.getAgilitaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.moto = moto;
		stileScelto = StileNormale.createStile();
	}
	
	public Pilota(String nome, String cognome, MotoInterface moto, int aggressivita, int forzaFisica, int agilita) {
		this.nome = nome;
		this.cognome = cognome;
		this.aggressivita = new Campo(aggressivita, MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = new Campo(forzaFisica, MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
		this.agilita = new Campo(agilita, MIN_CAMPO, MAX_CAMPO);
		this.moto = moto;
		stileScelto = StileNormale.createStile();
	}
	
	@Override
	public void preGara(StileGuida stileScelto) {
		this.stileScelto = stileScelto;
	}
	
	@Override
	public final StileGuida getStileGuida() {
		return stileScelto;
	}
	
	@Override
	public final void incrementaAggressivita() {
		aggressivita.increment();
	}
	
	@Override
	public final void incrementaForzaFisica() {
		forzaFisica.increment();
	}
	
	@Override
	public final void incrementaFeelingMoto() {
		feelingMoto.increment();
	}
	
	@Override
	public final void incrementaAgilita() {
		agilita.increment();
	}
	
	@Override
	public final void cambioMoto(MotoInterface nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = new Campo(MIN_CAMPO, MAX_CAMPO);
	}

	@Override
	public final String getNome() {
		return nome;
	}

	@Override
	public final String getCognome() {
		return cognome;
	}

	@Override
	public final CampoInterface getAggressivita() {
		return aggressivita;
	}
	
	@Override
	public final CampoInterface getForzaFisica() {
		return forzaFisica;
	}

	@Override
	public final CampoInterface getFeelingMoto() {
		return feelingMoto;
	}
	
	@Override
	public final CampoInterface getAgilita() {
		return agilita;
	}

	@Override
	public final MotoInterface getMoto() {
		return moto;
	}
	
}
