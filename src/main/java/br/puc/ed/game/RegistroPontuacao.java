package br.puc.ed.game;

public class RegistroPontuacao {
  private String nome;
  private int pontuacao;

  public RegistroPontuacao(String nome, int pontuacao){
    this.nome = nome;
    this.pontuacao = pontuacao;
  }

  public String getNome() {
    return nome;
  }

  public int getPontuacao() {
    return pontuacao;
  }
}
