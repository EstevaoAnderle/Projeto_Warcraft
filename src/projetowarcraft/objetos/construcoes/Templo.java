package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Andarilho;
import projetowarcraft.objetos.unidades.Sacerdote;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos da construção "Templo".
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Templo extends Construcao {

    public Templo(Raca raca, Posicao posicao) {
        super("ImagemTemplo.jpg", new Custo(0, 250, 0, 0), true, 350, raca, posicao);
    }

    /**
     * Cria sacerdotes, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos.
     */
    public void criaSacerdote() {
        Sacerdote unidade = new Sacerdote(raca, posicao);
        this.cria(unidade);
    }

    /**
     * Cria andarilhos, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos. Também, é verificado se o tipo do
     * objeto que está tentando criar é um orc.
     */
    public void criaAndarilho() {
        if (this.raca.getTipo() != 'O') {
            System.out.println("Apenas orcs podem gerar unidades do tipo Andarilho Espiritual.");
            return;
        }
        this.cria((new Andarilho(raca, posicao)));
    }

}
