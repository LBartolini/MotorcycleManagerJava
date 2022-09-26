package game.moto;

import game.Pilota;
import game.Scuderia;
import game.utils.GameConstants;


public class Moto {
	
	private static int progressivo = 0;
	
	private int idMoto, numInGara;
	private Scuderia scuderia;
	
	private Pilota pilota;
	
	private Componente motore, aerodinamica, ciclistica, freni;
	private MarcaGomme marcaGomme;
	private Setup setupGara;
	
	public Moto(int numInGara, Scuderia scuderia, Pilota pilota, int difficoltà) {
		this.idMoto = progressivo;
		progressivo++;
		
		this.numInGara = numInGara;
		this.scuderia = scuderia;
		this.pilota = pilota;
		this.setupGara = new Setup();
		
		switch(difficoltà) {
		
			case GameConstants.DIFF_FACILE:
				initFacile();
				break;
				
			case GameConstants.DIFF_INTERMEDIA:
				initIntermedia();
				break;
				
			case GameConstants.DIFF_DIFFICILE:
				initDifficile();
				break;
				
			case GameConstants.DIFF_IMPOSSIBILE:
				initImpossibile();
				break;	
		}
	}
	
	public void initFacile() {
		motore = new Componente("Motore", GameConstants.GRADO_COMPONENTE_FACILE, GameConstants.RESISTENZA_COMPONENTE_FACILE);
		aerodinamica = new Componente("Aerodinamica", GameConstants.GRADO_COMPONENTE_FACILE, GameConstants.RESISTENZA_COMPONENTE_FACILE);
		ciclistica = new Componente("Ciclistica", GameConstants.GRADO_COMPONENTE_FACILE, GameConstants.RESISTENZA_COMPONENTE_FACILE);
		freni = new Componente("Freni", GameConstants.GRADO_COMPONENTE_FACILE, GameConstants.RESISTENZA_COMPONENTE_FACILE);
		
		marcaGomme = GameConstants.GOMME_FACILE;
	}
	
	private void initIntermedia() {
		
	}
	
	private void initDifficile() {
		
	}

	
	private void initImpossibile() {
		
	}	
	
	public void preGara() {
		// TODO 
		// prepara la moto alla gara, crea setup, scegli mescola di gomme etc
		setupGara.reset();
	}
	
}
