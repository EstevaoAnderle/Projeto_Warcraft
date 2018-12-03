package projetowarcraft.objetos;

import projetowarcraft.objetos.unidades.Grifo;

/**
 * Trata os metodos de ataque e retirada de
 * vida de construcoes e unidades.
 * @author Estevao Anderle, Rafael de Paula
 */
public interface Ataque {
	
	default void atacar(Objeto atacante, Objeto alvo) {
		if(atacante.getPontosAtaque() == 0) {
			System.out.println("Esta unidade nao esta apta a atacar.");
			return;
		}
		if(alvo instanceof Grifo) {
			if(atacante.getAlcance() == 0) {
				System.out.println("Apenas unidades que atacam a distancia podem atacar o grifo.");
				return;
			}
		}
		
		
		double distancia = atacante.getPosicao().distance(alvo.getPosicao());
		if(atacante.getAlcance() >= distancia || distancia <= 2) {
			alvo.recebeDano(atacante.getPontosAtaque());
		}
	}
	
	public void atacar(Objeto alvo);
	
}
