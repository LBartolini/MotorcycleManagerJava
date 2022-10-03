package game.moto;

import Exceptions.ValueNotInRangeException;

public class Setup {

	public static final int MIN_VALUE = 1, MAX_VALUE = 10, DEFAULT_VALUE = MAX_VALUE/MIN_VALUE;
	
	private int altezzaAvantreno, altezzaRetrotreno;
	private int durezzaSospensioniFrontali, durezzaSospensioniPosteriori;
	
	public Setup(int altezzaAvantreno, int altezzaRetrotreno, int durezzaSospensioniFrontali,
			int durezzaSospensioniPosteriori) throws ValueNotInRangeException{
		
		if(altezzaAvantreno < MIN_VALUE || altezzaAvantreno > MAX_VALUE) throw new ValueNotInRangeException("altezzaAvantreno: "+altezzaAvantreno);
		if(altezzaRetrotreno < MIN_VALUE || altezzaRetrotreno > MAX_VALUE) throw new ValueNotInRangeException("altezzaRetrotreno: "+altezzaRetrotreno);
		if(durezzaSospensioniFrontali < MIN_VALUE || durezzaSospensioniFrontali > MAX_VALUE) throw new ValueNotInRangeException("durezzaSospensioniFrontali: "+durezzaSospensioniFrontali);
		if(durezzaSospensioniPosteriori < MIN_VALUE || durezzaSospensioniPosteriori > MAX_VALUE) throw new ValueNotInRangeException("durezzaSospensioniPosteriori: "+durezzaSospensioniPosteriori);
		
		this.altezzaAvantreno = altezzaAvantreno;
		this.altezzaRetrotreno = altezzaRetrotreno;
		this.durezzaSospensioniFrontali = durezzaSospensioniFrontali;
		this.durezzaSospensioniPosteriori = durezzaSospensioniPosteriori;
	}
	
	public Setup() {
		this.altezzaAvantreno = DEFAULT_VALUE;
		this.altezzaRetrotreno = DEFAULT_VALUE;
		this.durezzaSospensioniFrontali = DEFAULT_VALUE;
		this.durezzaSospensioniPosteriori = DEFAULT_VALUE;
	}

	public int getAltezzaAvantreno() {
		return altezzaAvantreno;
	}

	public int getAltezzaRetrotreno() {
		return altezzaRetrotreno;
	}

	public int getDurezzaSospensioniFrontali() {
		return durezzaSospensioniFrontali;
	}

	public int getDurezzaSospensioniPosteriori() {
		return durezzaSospensioniPosteriori;
	}
}
