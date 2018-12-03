package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.objetos.unidades.Andarilho;
import projetowarcraft.objetos.unidades.Sacerdote;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public abstract class Construcao extends Objeto {

    public Construcao(String imagem, Custo custo, boolean estado, int hp, Raca raca, Posicao posicao) {
        super(imagem, custo, estado, hp, raca, posicao);
    }
    
    public Construcao(String imagem, Custo custo, boolean estado, int hp, Raca raca, Posicao posicao,
    		int pontosAtaque, double alcance) {
        super(imagem, custo, estado, hp, raca, posicao, pontosAtaque, alcance);
    }

    protected void cria(Unidade unidade) {
    	
    	if (!raca.podeCriar(unidade)) {
        	return;
        }
    	if (!estado) {
    		System.out.println("Essa construcao ja esta destruida.");
    		return;
    	}
 
        raca.adicionarUnidade(unidade);
        System.out.println("Unidade criada.");
    
    }
    
    @Override
    public void verificaMorte() {
    	if(this.hp <= 0) {
    		raca.removerConstrucao(this);
    	}
    }
    
}
