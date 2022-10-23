package core.pilota;

import core.moto.Moto;
import core.stile_guida.StileGuida;
import core.utils.campo.CampoInterface;

public interface PilotaInterface {

	StileGuida getStileGuida();

	String getNome();

	String getCognome();

	CampoInterface getAggressivita();

	CampoInterface getForzaFisica();

	CampoInterface getFeelingMoto();

	CampoInterface getAgilita();

	Moto getMoto();

}