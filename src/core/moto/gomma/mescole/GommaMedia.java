package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneCostante;
import core.utils.constants.gomme.Medie;

public class GommaMedia extends Gomma{
	
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
		funzAderenza = new FunzioneCostante(Medie.ADERENZA);
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

}
