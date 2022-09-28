package game.moto.componente;

import game.utils.GameConstants;

public class ComponenteFacile extends Componente {

	public ComponenteFacile(String nome) {
		super(nome, GameConstants.difficolta.GRADO_COMPONENTE_FACILE, GameConstants.difficolta.RESISTENZA_COMPONENTE_FACILE);
	}

}
