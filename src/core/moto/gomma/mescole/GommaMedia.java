package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneCostante;

public class GommaMedia extends Gomma{
	
	public static final int ADERENZA= 50;
	
	public GommaMedia() {
		super(3);
	}

	private Funzione funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneCostante(ADERENZA, giriTotali);
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return false;
	}

	@Override
	public String getNome() {
		return "Gomma Media";
	}
	
	@Override
	public void usuraGomme(int percentuale) {
		int valoreFinaleAttuale = funzAderenza.getValoreFinale();
		
		funzAderenza.setValoreFinale((int) (valoreFinaleAttuale * (100 - percentuale) / 100));
	}

}
