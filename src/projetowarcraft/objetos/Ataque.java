package projetowarcraft.objetos;

/**
 * Trata os metodos de ataque e retirada de
 * vida de construcoes e unidades.
 * @author Estevao Anderle, Rafael de Paula
 */
public interface Ataque {
	
	default void atacar(Objeto atacante, Objeto alvo) {
		double distancia = atacante.getPosicao().distance(alvo.getPosicao());
		if(atacante.getAlcance() >= distancia || distancia <= 2) {
			alvo.recebeDano(atacante.getPontosAtaque());
		}
	}
	
}
