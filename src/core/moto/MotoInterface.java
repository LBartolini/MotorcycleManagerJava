package core.moto;

import core.moto.componente.ComponenteInterface;
import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.pilota.PilotaInterface;
import core.scuderia.ScuderiaInterface;

public interface MotoInterface {

	int getId();

	ScuderiaInterface getScuderia();

	ComponenteInterface getMotore();

	ComponenteInterface getAerodinamica();

	ComponenteInterface getCiclistica();

	ComponenteInterface getFreni();

	MarcaGomme getMarcaGomme();

	Gomma getGommaScelta();

	PilotaInterface getPilota();

	boolean isGuasta();

	boolean isIncidentata();

	boolean equals(Object other);

}