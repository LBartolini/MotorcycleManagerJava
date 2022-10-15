package core.moto;

import java.util.Objects;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import Exceptions.ValueNotInRangeException;
import core.Meteo;
import core.Scuderia;
import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.utils.difficolta.Difficolta;


public class Moto {
	
	private static int progressivo = 0;
	
	private int id;
	private Scuderia scuderia;
	
	private Componente motore, aerodinamica, ciclistica, freni;
	private MarcaGomme marcaGomme;
	
	// TODO aggiungere riferimento al pilota che guida la moto
	
	private Gomma gommaScelta;
	private boolean guasto, incidentata;
	
	public Moto(Scuderia scuderia, Difficolta difficolta) throws ValueNotInRangeException {
		this.id = ++progressivo;
		
		this.scuderia = scuderia;
		scuderia.addMoto(this);
		
		initByDifficolta(difficolta);
		
	}
	
	public void initByDifficolta(Difficolta diff) {
		motore = new Componente("Motore", diff);
		aerodinamica = new Componente("Aerodinamica", diff);
		ciclistica = new Componente("Ciclistica", diff);
		freni = new Componente("Freni", diff);
		marcaGomme = diff.getMarcaGomme();
		
	}	
	
	public void preGara(Gomma gommaScelta, Meteo meteo, int nGiri) throws GommaSceltaNotInMarcaGommeException{
		if(!marcaGomme.getGommeDisponibili().contains(gommaScelta)) throw new GommaSceltaNotInMarcaGommeException("Gomma selezionata: "+gommaScelta);
		
		this.gommaScelta = gommaScelta;
		gommaScelta.initPreGara(nGiri, meteo);
		incidentata = false;
		guasto = false;
	}

	public int getId() {
		return id;
	}

	public Scuderia getScuderia() {
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
