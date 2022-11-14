package core.pilota;

import core.moto.MotoInterface;
import core.stile_guida.StileGuida;

public interface PilotaModifiableInterface extends PilotaInterface{

	void preGara(StileGuida stileScelto);

	void incrementaLucidita();

	void incrementaForzaFisica();

	void incrementaFeelingMoto();

	void incrementaAgilita();

	void cambioMoto(MotoInterface nuovaMoto);

	void incrementaFama();

	void decrementaFama();

}