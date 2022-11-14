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
	private CampoModifiableInterface lucidita, forzaFisica, agilita, feelingMoto;
	private CampoModifiableInterface fama;
	
	private MotoInterface moto;
	private StileGuida stileScelto;
	
	public Pilota(String nome, String cognome, MotoInterface moto, Difficolta difficolta) {
		this.nome = nome;
		this.cognome = cognome;
		this.lucidita = Campo.createCampo(difficolta.getLuciditaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = Campo.createCampo(difficolta.getForzaFisicaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = Campo.createCampoMinDefault(MIN_CAMPO, MAX_CAMPO);
		this.agilita = Campo.createCampo(difficolta.getAgilitaIniziale(), MIN_CAMPO, MAX_CAMPO);
		this.fama = Campo.createCampoMinDefault(MIN_CAMPO, MAX_CAMPO);
		
		this.moto = moto;
		stileScelto = StileNormale.createStile();
	}
	
	public Pilota(String nome, String cognome, MotoInterface moto, int lucidita, int forzaFisica, int agilita) {
		this.nome = nome;
		this.cognome = cognome;
		this.lucidita = Campo.createCampo(lucidita, MIN_CAMPO, MAX_CAMPO);
		this.forzaFisica = Campo.createCampo(forzaFisica, MIN_CAMPO, MAX_CAMPO);
		this.feelingMoto = Campo.createCampoMinDefault(MIN_CAMPO, MAX_CAMPO);
		this.agilita = Campo.createCampo(agilita, MIN_CAMPO, MAX_CAMPO);
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
	public final void incrementaLucidita() {
		lucidita.increment();
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
	public final void incrementaFama() {
		fama.increment();
	}
	
	@Override
	public final void decrementaFama() {
		fama.decrement();
	}
	
	@Override
	public final void cambioMoto(MotoInterface nuovaMoto) {
		moto = nuovaMoto;
		feelingMoto = Campo.createCampoMinDefault(MIN_CAMPO, MAX_CAMPO);
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
	public final CampoInterface getLucidita() {
		return lucidita;
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
	public final CampoInterface getFama() {
		return fama;
	}

	@Override
	public final MotoInterface getMoto() {
		return moto;
	}
	
}
