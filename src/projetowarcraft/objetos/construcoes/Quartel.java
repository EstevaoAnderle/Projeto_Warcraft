package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.objetos.unidades.Arqueiro;
import projetowarcraft.objetos.unidades.Cavaleiro;
import projetowarcraft.objetos.unidades.Grifo;
import projetowarcraft.objetos.unidades.Guerreiro;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public class Quartel extends Construcao {

    public Quartel(Raca raca, Posicao posicao) {
        super("ImagemQuartel.jpg", new Custo(0, 125, 0, 0), true, 350, raca, posicao);
    }
    
    /**
     * Cria guerreiros, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    Guerreiro criaGuerreiro() {
    	Guerreiro unidade = new Guerreiro(raca, posicao); 
        this.cria(unidade);
        return unidade;
    }

    /**
     * Cria cavaleiros, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    Cavaleiro criaCavaleiro() {
    	Cavaleiro unidade = new Cavaleiro(raca, posicao); 
        this.cria(unidade);
        return unidade;
    }

    /**
     * Cria arqueiros, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaArqueiro() {
    	Arqueiro unidade = new Arqueiro(raca, posicao);
        this.cria(unidade);
    }

    
    /**
     * Cria grifos, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaGrifo() {
    	if(this.raca.getTipo() != 'H') {
    		System.out.println("Apenas humanos podem gerar unidades do tipo Grifo.");
    		return;
    	}
        this.cria((new Grifo(raca, posicao)));
    }

}
