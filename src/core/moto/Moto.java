package core.moto;

import java.util.Objects;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import Exceptions.ObjectNotInitializedException;
import core.meteo.MeteoInterface;
import core.moto.componente.Componente;
import core.moto.componente.ComponenteInterface;
import core.moto.componente.ComponenteModifiableInterface;
import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.pilota.PilotaInterface;
import core.scuderia.ScuderiaInterface;
import core.utils.difficolta.Difficolta;


public final class Moto implements MotoModifiableInterface {
	
	private static int progressivo = 0;
	
	private int id;
	private ScuderiaInterface scuderia;
	private PilotaInterface pilota;

	private ComponenteModifiableInterface motore, aerodinamica, ciclistica, freni;
	private MarcaGomme marcaGomme;
	
	private Gomma gommaScelta;
	private boolean guasto, incidentata;
	
	public Moto(ScuderiaInterface scuderia, Difficolta difficolta) {
		this.id = ++progressivo;
		
		this.scuderia = scuderia;
		this.pilota = null;
		
		motore = new Componente("Motore", difficolta);
		aerodinamica = new Componente("Aerodinamica", difficolta);
		ciclistica = new Componente("Ciclistica", difficolta);
		freni = new Componente("Freni", difficolta);
		marcaGomme = difficolta.getMarcaGomme();
	}	
	
	@Override
	public void preGara(Gomma gommaScelta, MeteoInterface meteo, int nGiri) throws Exception{
		if(Objects.isNull(pilota)) throw new ObjectNotInitializedException("Pilota has to be initialized");
		if(!scuderia.isMotoIn(this)) throw new Exception("This object should not exist");
		if(!marcaGomme.getGommeDisponibili().contains(gommaScelta)) throw new GommaSceltaNotInMarcaGommeException("Gomma selezionata: "+gommaScelta);
		
		this.gommaScelta = gommaScelta;
		gommaScelta.preGara(nGiri, meteo);
		incidentata = false;
		guasto = false;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public ScuderiaInterface getScuderia() {
		return scuderia;
	}

	@Override
	public ComponenteInterface getMotore() {
		return motore;
	}

	@Override
	public ComponenteInterface getAerodinamica() {
		return aerodinamica;
	}

	@Override
	public ComponenteInterface getCiclistica() {
		return ciclistica;
	}

	@Override
	public ComponenteInterface getFreni() {
		return freni;
	}

	@Override
	public MarcaGomme getMarcaGomme() {
		return marcaGomme;
	}

	@Override
	public Gomma getGommaScelta() {
		return gommaScelta;
	}
	
	@Override
	public PilotaInterface getPilota() {
		return pilota;
	}

	@Override
	public void setPilota(PilotaInterface pilota) {
		this.pilota = pilota;
	}
	
	@Override
	public boolean isGuasta() {
		return guasto;
	}
	
	@Override
	public void notifyGuasto() {
		guasto = true;
	}
	
	@Override
	public boolean isIncidentata() {
		return incidentata;
	}
	
	@Override
	public void notifyIncidente() {
		incidentata = true;
	}
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		MotoInterface other_moto;
		
		try {
			other_moto = (MotoInterface) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return id == other_moto.getId();
	}

	@Override
	public void upgradeMotoreGrado() {
		motore.upgradeGrado();
	}

	@Override
	public void upgradeMotoreResistenza() {
		motore.upgradeResistenza();
	}

	@Override
	public void upgradeAeroidinamicaGrado() {
		aerodinamica.upgradeGrado();
	}

	@Override
	public void upgradeAeroidinamicaResistenza() {
		aerodinamica.upgradeResistenza();
	}

	@Override
	public void upgradeCiclisticaGrado() {
		ciclistica.upgradeGrado();
	}

	@Override
	public void upgradeCiclisticaResistenza() {
		ciclistica.upgradeResistenza();
	}

	@Override
	public void upgradeFreniGrado() {
		freni.upgradeGrado();
	}

	@Override
	public void upgradeFreniResistenza() {
		freni.upgradeResistenza();
	}

	@Override
	public void setMarcaGomme(MarcaGomme nuovaMarcaGomme) {
		marcaGomme = nuovaMarcaGomme;
	}
	
}
