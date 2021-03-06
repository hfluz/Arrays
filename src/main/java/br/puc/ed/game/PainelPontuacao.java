package br.puc.ed.game;

public class PainelPontuacao {

    private RegistroPontuacao[] registros;
    private int quantidadeRegistros;

    public PainelPontuacao(int capacidade) {
        registros = new RegistroPontuacao[capacidade];
        quantidadeRegistros = 0;
    }

    public void adicionar(RegistroPontuacao rp) {
        int novaPontuacao = rp.getPontuacao();
        if (quantidadeRegistros < registros.length
            || novaPontuacao > registros[quantidadeRegistros - 1]
            .getPontuacao()) {
            if (quantidadeRegistros < registros.length) {
                quantidadeRegistros++;
            }
            int j = quantidadeRegistros - 1;
            while (j > 0 && registros[j - 1].getPontuacao() < novaPontuacao) {
                registros[j] = registros[j - 1];
                j--;
            }
            registros[j] = rp;
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
