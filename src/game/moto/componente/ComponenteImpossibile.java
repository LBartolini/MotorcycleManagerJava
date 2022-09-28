package game.moto.componente;

import game.utils.GameConstants;

public class ComponenteImpossibile extends Componente {

	public ComponenteImpossibile(String nome) {
		super(nome, GameConstants.difficolta.GRADO_COMPONENTE_IMPOSSIBILE, GameConstants.difficolta.RESISTENZA_COMPONENTE_IMPOSSIBILE);
	}

}
