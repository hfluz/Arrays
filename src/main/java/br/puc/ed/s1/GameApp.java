package br.puc.ed.s1;

public class GameApp {

  public static void main(String[] args) {
    PainelPontuacao painelPontuacao = new PainelPontuacao(5);
    painelPontuacao.adicionar(new RegistroPontuacao("João", 4));
    painelPontuacao.imprimir();
  }
}
