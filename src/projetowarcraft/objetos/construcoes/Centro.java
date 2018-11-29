package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.racas.Raca;

public class Centro extends Construcao implements Ataque {

    public Centro(Posicao posicao, Raca raca) {
        super("ImagemCentro.jpg", new Custo(0, 200, 0, 0), true, 600, raca, posicao, 10, 8);
    }

    /**
     * Cria camponeses, verificando primeiramente se a construcao esta em pe e apos,
     * verificando se ha recursos.
     */
    Campones criaCampones() {
    	Campones unidade = new Campones(raca, posicao); 
        this.cria(unidade);
        return unidade;
    }

}
