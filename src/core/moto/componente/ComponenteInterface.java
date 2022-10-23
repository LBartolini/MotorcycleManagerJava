package core.moto.componente;

import core.utils.campo.CampoInterface;

public interface ComponenteInterface {

	int getProbabilitaGuasto();

	String getNome();

	CampoInterface getGrado();

	CampoInterface getResistenza();

}