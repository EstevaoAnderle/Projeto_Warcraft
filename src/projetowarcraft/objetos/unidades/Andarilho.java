package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos e funcionalidades da unidade
 * "Andarilho"
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Andarilho extends Unidade {

    public Andarilho(Raca raca, Posicao posicao) {
        super("ImagemAndarilho.jpg", new Custo(170, 0, 40, 0), true, 100, 2, 10, raca, posicao, 1.0, 2);
    }

    /**
     * Revive objetos se caso o andarilho estiver vivo e se houver mana
     * suficiente. Também, é verificado se o objeto está próximo do andarilho
     * para ser revivido.
     *
     * @param objeto - unidade que será ressucitada
     */
    public void revive(Unidade objeto) {
        if (!estado) {
            System.out.println("Este andarilho ja esta morto.");
            return;
        }
        if (raca.getMana() < 5) {
            System.out.println("Nao ha mana suficiente!");
            return;
        }
        double distancia = this.getPosicao().distance(objeto.getPosicao());
        if (distancia > 10) {
            System.out.println("O alvo esta muito distante para ser curado!");
            return;
        }
        if (!objeto.getEstado()) {
            objeto.restaurarVida();
            objeto.setEstado(true);
            objeto.getRaca().reviverUnidade(objeto);
        }
        raca.diminuirSuprimentosEspecificos(0, 0, 0, 5);
    }

}
