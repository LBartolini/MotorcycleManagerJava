package game.moto;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import game.Pilota;
import game.Scuderia;
import game.moto.gomma.Gomma;
import game.moto.gomma.MarcaGomme;
import game.utils.constants.difficolta.Difficile;
import game.utils.constants.difficolta.Difficolta;
import game.utils.constants.difficolta.Facile;
import game.utils.constants.difficolta.Impossibile;
import game.utils.constants.difficolta.Intermedia;


public class Moto {
	
	private static int progressivo = 0;
	
	private int id, numInGara;
	private Scuderia scuderia;
	private Pilota pilota;
	
	private Componente motore, aerodinamica, ciclistica, freni;
	private MarcaGomme marcaGomme;
	
	private Gomma gommaScelta;
	
	public Moto(int numInGara, Scuderia scuderia, Pilota pilota, Difficolta difficolta) {
		this.id = ++progressivo;
		
		this.numInGara = numInGara;
		this.scuderia = scuderia;
		this.pilota = pilota;
		
		initByDifficolta(difficolta);
		
	}
	
	public void initByDifficolta(Difficolta diff) {
		motore = new Componente("Motore", diff);
		aerodinamica = new Componente("Aerodinamica", diff);
		ciclistica = new Componente("Ciclistica", diff);
		freni = new Componente("Freni", diff);
		
		switch(diff) {
		
			case DIFF_FACILE:
				marcaGomme = Facile.getMarcaGomme();
				break;
				
			case DIFF_INTERMEDIA:
				marcaGomme = Intermedia.getMarcaGomme();
				break;
				
			case DIFF_DIFFICILE:
				marcaGomme = Difficile.getMarcaGomme();
				break;
				
			case DIFF_IMPOSSIBILE:
				marcaGomme = Impossibile.getMarcaGomme();
				break;
		
		}
		
	}	
	
	public void cambiaPilota(Pilota nuovoPilota) {
		pilota = nuovoPilota;
	}
	
	public void preGara(Gomma gommaScelta) throws GommaSceltaNotInMarcaGommeException{
		if(!marcaGomme.getGommeDisponibili().contains(gommaScelta)) throw new GommaSceltaNotInMarcaGommeException("Gomma selezionata: "+gommaScelta);
		
		this.gommaScelta = gommaScelta;
	}

	public int getIdMoto() {
		return id;
	}

	public int getNumInGara() {
		return numInGara;
	}

	public Scuderia getScuderia() {
		return scuderia;
	}

	public Pilota getPilota() {
		return pilota;
	}

	public Componente getMotore() {
		return motore;
	}

	public Componente getAerodinamica() {
		return aerodinamica;
	}

	public Componente getCiclistica() {
		return ciclistica;
	}

	public Componente getFreni() {
		return freni;
	}

	public MarcaGomme getMarcaGomme() {
		return marcaGomme;
	}

	public Gomma getGommaScelta() {
		return gommaScelta;
	}
	
}
