package core.moto;

import java.util.Objects;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import Exceptions.ObjectNotInitializedException;
import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.pilota.PilotaInterface;
import core.scuderia.ScuderiaInterface;
import core.utils.difficolta.Difficolta;


public final class Moto {
	
	private static int progressivo = 0;
	
	private int id;
	private ScuderiaInterface scuderia;
	private PilotaInterface pilota;

	private Componente motore, aerodinamica, ciclistica, freni;
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
	
	public void preGara(Gomma gommaScelta, MeteoInterface meteo, int nGiri) throws Exception{
		if(Objects.isNull(pilota)) throw new ObjectNotInitializedException("Pilota has to be initialized");
		if(!scuderia.isMotoIn(this)) throw new Exception("This object should not exist");
		if(!marcaGomme.getGommeDisponibili().contains(gommaScelta)) throw new GommaSceltaNotInMarcaGommeException("Gomma selezionata: "+gommaScelta);
		
		this.gommaScelta = gommaScelta;
		gommaScelta.preGara(nGiri, meteo);
		incidentata = false;
		guasto = false;
	}

	public int getId() {
		return id;
	}

	public ScuderiaInterface getScuderia() {
		return scuderia;
	}

	public Componente getMotore() {
		return motore;
	}

	public Componente getAerodinamica() {
		return aerodinamica;
	}

	public Componente getCiclistica() {
		return ciclistica;
	}

	public Componente getFreni() {
		return freni;
	}

	public MarcaGomme getMarcaGomme() {
		return marcaGomme;
	}

	public Gomma getGommaScelta() {
		return gommaScelta;
	}
	
	public PilotaInterface getPilota() {
		return pilota;
	}

	public void setPilota(PilotaInterface pilota) {
		this.pilota = pilota;
	}
	
	public boolean isGuasta() {
		return guasto;
	}
	
	public void notifyGuasto() {
		guasto = true;
	}
	
	public boolean isIncidentata() {
		return incidentata;
	}
	
	public void notifyIncidente() {
		incidentata = true;
	}
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		Moto other_moto;
		
		try {
			other_moto = (Moto) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return id == other_moto.getId();
	}
	
}
