package core.pilota;

import core.moto.Moto;
import core.stile_guida.StileGuida;

public interface PilotaModifiableInterface extends PilotaInterface{

	void preGara(StileGuida stileScelto);

	void incrementaAggressivita();

	void incrementaForzaFisica();

	void incrementaFeelingMoto();

	void incrementaAgilita();

	void cambioMoto(Moto nuovaMoto);

}