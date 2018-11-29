package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Andarilho;
import projetowarcraft.objetos.unidades.Arqueiro;
import projetowarcraft.objetos.unidades.Cavaleiro;
import projetowarcraft.objetos.unidades.Grifo;
import projetowarcraft.objetos.unidades.Guerreiro;
import projetowarcraft.objetos.unidades.Sacerdote;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public class Templo extends Construcao {

    public Templo(Raca raca, Posicao posicao) {
        super("ImagemTemplo.jpg", new Custo(0, 250, 0, 0), true, 350, raca, posicao);
    }
    
    

    /**
     * Cria sacerdotes, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaSacerdote() {
        this.cria((new Sacerdote(raca, posicao)));
    }

    
    /**
     * Cria andarilhos, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaAndarilho() {
    	if(this.raca.getTipo() != 'O') {
    		System.out.println("Apenas orcs podem gerar unidades do tipo Andarilho Espiritual.");
    		return;
    	}
        this.cria((new Andarilho(raca, posicao)));
    }

}
