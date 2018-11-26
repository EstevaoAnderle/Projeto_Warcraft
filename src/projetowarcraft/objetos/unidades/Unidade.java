package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public class Unidade extends Objeto {

    private double velocidade;
    private int armadura;

    public Unidade(String imagem, Custo custo, boolean estado, int hp,
            int pontosAtaque, double alcance, Raca raca, Posicao posicao,
            double velocidade, int armadura) {
        super(imagem, custo, estado, hp, pontosAtaque, alcance, raca, posicao);
        this.velocidade = velocidade;
        this.armadura = armadura;
    }

    /**
     * Move a unidade conforme direcao informada,
     * levando em consideração velocidade da mesma.
     *
     * @param direcao
     */
    public void mover(String direcao) {

        if (estado) {
            switch (direcao.toLowerCase()) {
                case "norte":
                    posicao = posicao.moverParaNorte(velocidade);
                case "sul":
                    posicao = posicao.moverParaSul(velocidade);
                case "leste":
                    posicao = posicao.moverParaLeste(velocidade);
                case "oeste":
                    posicao = posicao.moverParaOeste(velocidade);
                default:
                    System.out.println("Verifica a opcao informada.");
            }
        } else {
            System.out.println("Voce esta tentando mover algo que esta morto.");
        }

    }


}
