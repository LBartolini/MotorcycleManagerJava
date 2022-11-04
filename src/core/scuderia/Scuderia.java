package core.scuderia;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import core.moto.Moto;
import core.moto.MotoInterface;
import core.utils.difficolta.Difficolta;

public class Scuderia implements ScuderiaInterface {

	private static final int MAX_MOTO = 2;
	
	public static Scuderia create(String nome, Difficolta diff) {
		return new Scuderia(nome, diff);
	}

	private String nome;
	private List<Moto> moto;
	
	private Scuderia(String nome, Difficolta diff) {
		this.nome = nome;
		moto = IntStream.range(1, MAX_MOTO+1)
				.mapToObj((n) -> Moto.createMoto(this, diff))
				.collect(Collectors.toList());
	}
	
	@Override
	public final String getNome() {
		return nome;
	}
	
	@Override
	public final boolean isMotoIn(MotoInterface moto) {
		return this.moto.contains(moto);
	}
	
	@Override
	public final Moto getMoto(int index) {
		return moto.get(index);
	}
	
}
