package br.puc.ed.game;

import br.puc.ed.ex3.PainelPontuacaoSemOrdem;
import java.util.Random;

public class GameApp {

    public static void main(String[] args) {
        PainelPontuacao painelPontuacao = new PainelPontuacao(5);
        painelPontuacao.adicionar(new RegistroPontuacao("Lúcia", 57));
        painelPontuacao.adicionar(new RegistroPontuacao("Ricardo", 79));
        painelPontuacao.adicionar(new RegistroPontuacao("Maria", 42));
        painelPontuacao.adicionar(new RegistroPontuacao("Erick", 50));
        painelPontuacao.imprimir();
        painelPontuacao.adicionar(new RegistroPontuacao("Vinícius", 55));
        painelPontuacao.imprimir();
        painelPontuacao.adicionar(new RegistroPontuacao("João", 43));
        painelPontuacao.imprimir();
        painelPontuacao.adicionar(new RegistroPontuacao("Rafael", 35));
        painelPontuacao.imprimir();

        // Exercício 1 - Reprodução do exemplo de exclusão do slide.
        RegistroPontuacao registroExcluido = painelPontuacao.excluir(2);
        System.out.println("Registro excluído: " + registroExcluido);
        painelPontuacao.imprimir();

        // Exercício 2
        exclusaoAleatoria(painelPontuacao);
        System.out.println("Quantidade de elementos na lista: " + painelPontuacao.getQuantidadeRegistros());

        // Exercício 3
        PainelPontuacaoSemOrdem painelPontuacaoSemOrdem = new PainelPontuacaoSemOrdem(5);
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Lúcia", 57));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Ricardo", 79));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Maria", 42));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Erick", 50));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Vinícius", 55));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("João", 43));
        painelPontuacaoSemOrdem.adicionar(new RegistroPontuacao("Rafael", 35));
        painelPontuacaoSemOrdem.imprimir();
    }

    /**
     * Exercício 2
     * @param painelPontuacao
     */
    private static void exclusaoAleatoria(PainelPontuacao painelPontuacao) {
        Random random = new Random();
        // Repetição da exclusão aleatória enquanto o painel tiver registros.
        while (painelPontuacao.getQuantidadeRegistros() > 0) {
            // Obtenção do índice aleatório baseado no tamanho do painel.
            int indiceAleatorio = random.nextInt(painelPontuacao.getQuantidadeRegistros());
            // Exclusão do registro no painel e impressão no console
            RegistroPontuacao registroExcluido = painelPontuacao.excluir(indiceAleatorio);
            System.out.println("Registro aleatório excluído: " + registroExcluido);
        }
    }
}
