package core.moto;

import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.pilota.PilotaInterface;

public interface MotoModifiableInterface extends MotoInterface{

	void preGara(Gomma gommaScelta, MeteoInterface meteo, int nGiri) throws Exception;

	void setPilota(PilotaInterface pilota);

	void notifyGuasto();

	void notifyIncidente();
	
	void upgradeMotoreGrado();

	void upgradeMotoreResistenza();
	
	void upgradeAeroidinamicaGrado();

	void upgradeAeroidinamicaResistenza();
	
	void upgradeCiclisticaGrado();

	void upgradeCiclisticaResistenza();
	
	void upgradeFreniGrado();

	void upgradeFreniResistenza();
	
	void setMarcaGomme(MarcaGomme nuovaMarcaGomme);

}