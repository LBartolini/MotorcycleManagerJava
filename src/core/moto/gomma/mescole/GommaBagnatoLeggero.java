package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneCostante;

public class GommaBagnatoLeggero extends Gomma{
	
	public static final int ADERENZA = 40;

	public GommaBagnatoLeggero() {
		super(5);
	}

	private Funzione funzAderenza;
	
	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		return funzAderenza.getValue(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		this.funzAderenza = new FunzioneCostante(ADERENZA, giriTotali);
	}

	@Override
	public boolean daAsciutto() {
		return false;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}

	@Override
	public String getNome() {
		return "Gomma da Bagnato Leggero";
	}

	@Override
	public void usuraGomme(int percentuale) {
		int valoreFinaleAttuale = funzAderenza.getValoreFinale();
		
		funzAderenza.setValoreFinale((int) (valoreFinaleAttuale * (100 - percentuale) / 100));
	}

}
