package core.scuderia;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import core.moto.Moto;
import core.utils.difficolta.Difficolta;

public class Scuderia implements ScuderiaInterface {

	private static final int MAX_MOTO = 2;
	
	private String nome;
	private List<Moto> moto;
	
	public Scuderia(String nome, Difficolta diff) {
		this.nome = nome;
		moto = IntStream.range(1, MAX_MOTO+1)
				.mapToObj((n) -> new Moto(this, diff))
				.collect(Collectors.toList());
	}
	
	@Override
	public final String getNome() {
		return nome;
	}
	
	@Override
	public final boolean isMotoIn(Moto moto) {
		return this.moto.contains(moto);
	}
	
	@Override
	public final Moto getMoto(int index) {
		return moto.get(index);
	}
	
}
