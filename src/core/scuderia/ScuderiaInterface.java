package core.scuderia;

import core.moto.Moto;

public interface ScuderiaInterface {

	String getNome();

	boolean isMotoIn(Moto moto);

	Moto getMoto(int index);

}