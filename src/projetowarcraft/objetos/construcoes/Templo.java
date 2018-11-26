package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Andarilho;
import projetowarcraft.objetos.unidades.Sacerdote;
import projetowarcraft.racas.Raca;

public class Templo extends Construcao {

    public Templo(Raca raca, Posicao posicao) {
        super("ImagemTemplo.jpg", new Custo(0, 250, 0, 0), true, 350, 0, 0, raca, posicao);
    }

    /**
     * Cria sacerdotes, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaSacerdote() {
        if (estado) {
            Sacerdote sacerdote = new Sacerdote(raca, posicao);
            if (raca.getCusto().compararCustos(sacerdote.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Sacerdote(raca, posicao));
                    System.out.println("Sacerdote criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(sacerdote.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

    //ADICIONAR VALIDAÇÃO PARA VER SE É ORC OU NÃO
    
    /**
     * Cria andarilhos, verificando primeiramente se a construção está em pé e após,
     * verificando se há recursos.
     */
    void criaAndarilho() {
        if (estado) {
            Andarilho andarilho = new Andarilho(raca, posicao);
            if (raca.getCusto().compararCustos(andarilho.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Andarilho(raca, posicao));
                    System.out.println("Andarilho criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(andarilho.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

}
