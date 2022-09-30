package game.moto;

import game.Pilota;
import game.Scuderia;
import game.moto.componente.Componente;
import game.moto.componente.ComponenteDifficile;
import game.moto.componente.ComponenteFacile;
import game.moto.componente.ComponenteImpossibile;
import game.moto.componente.ComponenteIntermedia;
import game.moto.gomma.MarcaGomme;
import game.utils.Difficolta;
import game.utils.GameConstants;


public class Moto {
	
	private static int progressivo = 0;
	
	private int idMoto, numInGara;
	private Scuderia scuderia;
	private Pilota pilota;
	
	private Componente motore, aerodinamica, ciclistica, freni;
	private MarcaGomme marcaGomme;
	private Setup setupGara;
	
	public Moto(int numInGara, Scuderia scuderia, Pilota pilota, Difficolta difficolta) {
		this.idMoto = ++progressivo;
		
		this.numInGara = numInGara;
		this.scuderia = scuderia;
		this.pilota = pilota;
		this.setupGara = new Setup();
		
		switch(difficolta) {
		
			case DIFF_FACILE:
				initFacile();
				break;
			
			case DIFF_INTERMEDIA:
				initIntermedia();
				break;
				
			case DIFF_DIFFICILE:
				initDifficile();
				break;
				
			case DIFF_IMPOSSIBILE:
				initImpossibile();
				break;

		}
		
	}
	
	public void initFacile() {
		motore = new ComponenteFacile("Motore");
		aerodinamica = new ComponenteFacile("Aerodinamica");
		ciclistica = new ComponenteFacile("Ciclistica");
		freni = new ComponenteFacile("Freni");
		
		marcaGomme = GameConstants.difficolta.GOMME_FACILE;
	}
	
	private void initIntermedia() {
		motore = new ComponenteIntermedia("Motore");
		aerodinamica = new ComponenteIntermedia("Aerodinamica");
		ciclistica = new ComponenteIntermedia("Ciclistica");
		freni = new ComponenteIntermedia("Freni");
		
		marcaGomme = GameConstants.difficolta.GOMME_INTERMEDIA;
	}
	
	private void initDifficile() {
		motore = new ComponenteDifficile("Motore");
		aerodinamica = new ComponenteDifficile("Aerodinamica");
		ciclistica = new ComponenteDifficile("Ciclistica");
		freni = new ComponenteDifficile("Freni");
		
		marcaGomme = GameConstants.difficolta.GOMME_DIFFICILE;
	}

	
	private void initImpossibile() {
		motore = new ComponenteImpossibile("Motore");
		aerodinamica = new ComponenteImpossibile("Aerodinamica");
		ciclistica = new ComponenteImpossibile("Ciclistica");
		freni = new ComponenteImpossibile("Freni");
		
		marcaGomme = GameConstants.difficolta.GOMME_IMPOSSIBILE;
	}	
	
	public void preGara() {
		// TODO 
		// prepara la moto alla gara, crea setup, scegli mescola di gomme etc
		setupGara.reset();
	}
	
}
