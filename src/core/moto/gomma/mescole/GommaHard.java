package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class GommaHard extends Gomma{
	
	public static final int ADERENZA_INIZIALE= 30;
	public static final int ADERENZA_FINALE = 80;
	
	public GommaHard() {
		super(4);
	}

	private Funzione funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
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
		return "Gomma Hard";
	}
	
	@Override
	public void usuraGomme(int percentuale) {
		int valoreFinaleAttuale = funzAderenza.getValoreFinale();
		
		funzAderenza.setValoreFinale((int) (valoreFinaleAttuale * (100 - percentuale) / 100));
	}
	
}
