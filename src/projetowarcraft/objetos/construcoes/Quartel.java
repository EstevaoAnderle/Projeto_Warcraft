package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Arqueiro;
import projetowarcraft.objetos.unidades.Cavaleiro;
import projetowarcraft.objetos.unidades.Grifo;
import projetowarcraft.objetos.unidades.Guerreiro;
import projetowarcraft.racas.Raca;

public class Quartel extends Construcao {

    public Quartel(Raca raca, Posicao posicao) {
        super("ImagemQuartel.jpg", new Custo(0, 125, 0, 0), true, 350, 0, 0, raca, posicao);
    }

    void criaGuerreiro() {
        if (estado) {
            Guerreiro guerreiro = new Guerreiro(raca, posicao);
            if (raca.getCusto().compararCustos(guerreiro.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Guerreiro(raca, new Posicao(x, y)));
                    System.out.println("Guerreiro criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(guerreiro.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

    void criaCavaleiro() {
        if (estado) {
            Cavaleiro cavaleiro = new Cavaleiro(raca, posicao);
            if (raca.getCusto().compararCustos(cavaleiro.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Cavaleiro(raca, new Posicao(x, y)));
                    System.out.println("Guerreiro criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(cavaleiro.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

    void criaArqueiro() {
        if (estado) {
            Arqueiro arqueiro = new Arqueiro(raca, posicao);
            if (raca.getCusto().compararCustos(arqueiro.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Arqueiro(raca, new Posicao(x, y)));
                    System.out.println("Arqueiro criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(arqueiro.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

    //ADICIONAR VALIDAÇÃO PARA VER SE É HUMANO OU NÃO
    void criaGrifo() {
        if (estado) {
            Grifo grifo = new Grifo(raca, posicao);
            if (raca.getCusto().compararCustos(grifo.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Grifo(raca, new Posicao(x, y)));
                    System.out.println("Grifo criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(grifo.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

}
