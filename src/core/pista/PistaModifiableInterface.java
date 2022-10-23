package core.pista;

import core.meteo.MeteoInterface;

public interface PistaModifiableInterface extends PistaInterface {

	void preGara(MeteoInterface meteo);

}