package br.puc.ed.ex3;

import br.puc.ed.game.RegistroPontuacao;

public class PainelPontuacaoSemOrdem {

    private RegistroPontuacao[] registros;
    private int quantidadeRegistros;

    public PainelPontuacaoSemOrdem(int capacidade) {
        registros = new RegistroPontuacao[capacidade];
        quantidadeRegistros = 0;
    }

    /**
     * Exercício 3
     * @param novaPontuacao
     */
    public void adicionar(RegistroPontuacao novaPontuacao){
        // Inclusão na primeira posição livre do array caso a lista esteja não esteja cheia
        if(quantidadeRegistros < registros.length){
            registros[quantidadeRegistros++] = novaPontuacao;
        } else {
            int indiceMenorPontuacao = 0;
            // Iteração sobre a lista para descobrir qual o índice da menor pontuação
            for (int i = 1; i < registros.length; i++) {
                if (registros[i].getPontuacao() < registros[indiceMenorPontuacao].getPontuacao()) {
                    indiceMenorPontuacao = i;
                }
            }
            // Caso a menor pontuação seja menor do que a nova pontuação, ela será substituída
            // nessa posição
            if (novaPontuacao.getPontuacao() > registros[indiceMenorPontuacao].getPontuacao()) {
                registros[indiceMenorPontuacao] = novaPontuacao;
            }
        }
    }

    /**
     * Exercício 1
     * @param indice índice que será excluído
     * @return
     */
    public RegistroPontuacao excluir(int indice){
        // Validação
        if(indice < 0 || indice >= quantidadeRegistros){
            throw new ArrayIndexOutOfBoundsException("Índice inválido para exclusão.");
        }
        // Primeiro separamos o elemento que será excluído para retorná-lo ao final do método
        RegistroPontuacao registroExcluido = registros[indice];
        // Começamos a deslocar os registros com pontuação inferior 1 posição para cima
        for(int i = indice; i < registros.length - 1; i++){
            registros[i] = registros[i + 1];
        }
        // Setamos o último registro (que já foi movido para cima) para null, liberando memória.
        registros[quantidadeRegistros - 1] = null;
        quantidadeRegistros--;
        return registroExcluido;
    }

    public void imprimir() {
        for (int i = 0; i < quantidadeRegistros; i++) {
            System.out
                .println(i + ": " + registros[i].getNome() + " / " + registros[i].getPontuacao());
        }
        System.out.println();
    }

    public int getQuantidadeRegistros() {
        return quantidadeRegistros;
    }
}
