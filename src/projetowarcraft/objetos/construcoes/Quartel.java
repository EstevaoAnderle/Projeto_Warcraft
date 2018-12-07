package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Arqueiro;
import projetowarcraft.objetos.unidades.Cavaleiro;
import projetowarcraft.objetos.unidades.Grifo;
import projetowarcraft.objetos.unidades.Guerreiro;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos da construção "Quartel".
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Quartel extends Construcao {

    public Quartel(Raca raca, Posicao posicao) {
        super("ImagemQuartel.jpg", new Custo(0, 125, 0, 0), true, 350, raca, posicao);
    }

    /**
     * Cria guerreiros, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos.
     */
    public void criaGuerreiro() {
        Guerreiro unidade = new Guerreiro(raca, posicao);
        this.cria(unidade);
    }

    /**
     * Cria cavaleiros, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos.
     */
    public void criaCavaleiro() {
        Cavaleiro unidade = new Cavaleiro(raca, posicao);
        this.cria(unidade);
    }

    /**
     * Cria arqueiros, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos.
     */
    public void criaArqueiro() {
        Arqueiro unidade = new Arqueiro(raca, posicao);
        this.cria(unidade);
    }

    /**
     * Cria camponeses, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos. Também, é verificado se o tipo do
     * objeto que está tentando criar é um humano.
     */
    public void criaGrifo() {
        if (this.raca.getTipo() != 'H') {
            System.out.println("Apenas humanos podem gerar unidades do tipo Grifo.");
            return;
        }
        this.cria((new Grifo(raca, posicao)));
    }

}
