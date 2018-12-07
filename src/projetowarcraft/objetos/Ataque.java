package projetowarcraft.objetos;

import projetowarcraft.objetos.unidades.Grifo;

/**
 * Trata os metodos de ataque e retirada de vida de construcoes e unidades.
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public interface Ataque {

    /**
     * Método que verifica a possibilidade de atacar, tendo como entrada um
     * objeto que irá atacar e o objeto que será atacado.
     *
     * @param atacante - objeto que irá atacar
     * @param alvo - objeto que será atacado
     */
    default void atacar(Objeto atacante, Objeto alvo) {
        if (atacante.getPontosAtaque() == 0) {
            System.out.println("Esta unidade nao esta apta a atacar.");
            return;
        }
        if (alvo instanceof Grifo) {
            if (atacante.getAlcance() == 0) {
                System.out.println("Apenas unidades que atacam a distancia podem atacar o grifo.");
                return;
            }
        }

        double distancia = atacante.getPosicao().distance(alvo.getPosicao());
        if (atacante.getAlcance() >= distancia || distancia <= 2) {
            alvo.recebeDano(atacante.getPontosAtaque());
        }
    }

    /**
     * Método que foi criado com o intuito de ser sobreescrito a fim de
     * solicitar, apenas, o alvo.
     *
     * @param alvo - objeto que será o alvo
     */
    public void atacar(Objeto alvo);

}
