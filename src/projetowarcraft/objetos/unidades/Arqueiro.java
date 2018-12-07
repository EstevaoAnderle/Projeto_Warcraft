package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos e funcionalidades da unidade
 * "Arqueiro"
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Arqueiro extends Unidade {

    public Arqueiro(Raca raca, Posicao posicao) {
        super("ImagemArqueiro.jpg", new Custo(40, 0, 20, 0), true, 45, 5, 7, raca, posicao, 2.0, 0);
    }

}
