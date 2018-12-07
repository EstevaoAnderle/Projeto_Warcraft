package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.construcoes.*;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos e funcionalidades da unidade
 * "Campones"
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Campones extends Unidade {

    public Campones(Raca raca, Posicao posicao) {
        super("ImagemCampones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 0, raca, posicao, 2.0, 0);
    }

    /**
     * Método que realiza verificação sobre qual construção está tentando ser
     * criada. Só é possível a criação se caso existirem recursos suficientes e,
     * também, se o camponês estiver vivo.
     *
     * @param posicao - posicao do objeto
     * @param tipo - tipo da construcao
     */
    public void constroi(Posicao posicao, String tipo) {
        Construcao construcao;
        tipo = tipo.toLowerCase();
        if (tipo == "casa") {
            construcao = new Casa(raca, posicao);
        } else if (tipo == "centro") {
            construcao = new Centro(raca, posicao);
        } else if (tipo == "templo") {
            construcao = new Templo(raca, posicao);
        } else if (tipo == "quartel") {
            construcao = new Quartel(raca, posicao);
        } else if (tipo == "torre") {
            construcao = new Torre(raca, posicao);
        } else {
            System.out.println("Construcao invalida!");
            return;
        }

        if (!raca.podeConstruir(construcao)) {
            return;
        }
        if (!estado) {
            System.out.println("Este campones ja esta morto.");
            return;
        }

        raca.adicionarConstrucao(construcao);
        System.out.println("Construcao do tipo " + tipo + " criada.");
    }

    /**
     * Primeiramente, é verificado se o camponês está vivo. Caso sim, ele gera
     * suprimento.
     */
    public void colhe() {
        if (estado) {
            raca.adicionarSuprimentos(1, 0, 0, 0);
        } else {
            System.out.println("Este campones ja esta morto.");
        }
    }

    /**
     * Primeiramente, é verificado se o camponês está vivo. Caso sim, ele gera
     * suprimento.
     */
    public void corte() {
        if (estado) {
            raca.adicionarSuprimentos(0, 1, 0, 0);
        } else {
            System.out.println("Este campones ja esta morto.");
        }
    }

    /**
     * Primeiramente, é verificado se o camponês está vivo. Caso sim, ele gera
     * suprimento.
     */
    public void minera() {
        if (estado) {
            raca.adicionarSuprimentos(0, 0, 1, 0);
        } else {
            System.out.println("Este campones ja esta morto.");
        }
    }

}
