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
    	if (estado) {
			if (raca.calculaSuprimentos(unidade.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(unidade);
                    System.out.println("Unidade criada.");
                } else {
                    System.out.println("A quantidade maxima da populacao foi atingida.");
                }
                raca.diminuirSuprimentos(unidade.getCusto());
            } else {
                System.out.println("Recursos nao sao suficientes!");
            }
        } else {
            System.out.println("Essa construcao ja esta destruida.");
        }
    }
}
