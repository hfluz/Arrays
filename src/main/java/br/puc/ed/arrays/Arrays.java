package br.puc.ed.arrays;

public class Arrays {

  public static void main(String[] args) {
    int[] intArray;
    intArray = new int[10];
    intArray[0] = 56;
    intArray[1] = 34;
    for(int i = 0; i < intArray.length; i++) {
      System.out.println(i + ": " + intArray[i]);
    }
  }

}
