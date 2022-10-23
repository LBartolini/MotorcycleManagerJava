package core.pista;

import Exceptions.ObjectNotInitializedException;
import core.meteo.MeteoInterface;
import core.moto.MotoInterface;
import core.pilota.PilotaInterface;
import core.utils.tempo.TempoInterface;

public interface PistaInterface {

	TempoInterface getTempoSulGiro(int giro, MotoInterface moto) throws ObjectNotInitializedException;

	boolean getCadutaMotoPilota(PilotaInterface pilota, MotoInterface moto);

	int getIdPista();

	String getNomePista();

	int getNGiri();

	int getNSpettatori();

	TempoInterface getTempoMassimo();

	MeteoInterface getMeteo();

	boolean equals(Object other);

}