package core.scuderia;

import core.moto.Moto;
import core.moto.MotoInterface;

public interface ScuderiaInterface {

	String getNome();

	boolean isMotoIn(MotoInterface moto);

	Moto getMoto(int index);

}