package ap005_estruturas_de_dados_basicas;


class Exemplo{
  
}
public class ArrayDinamico {
  private int [] dados;
  private int quantidade;
  
  public ArrayDinamico(int capacidade){
    dados = new int[capacidade];
    quantidade = 0;
  }

  public int acessar(int i){
    if(i < 0 || i >= quantidade)
      throw new IndexOutOfBoundsException();
    return dados[i];
  }
  
  private void redimensionar(int novaCapacidade){
    int[] novo = new int[novaCapacidade];
    for(int i = 0; i < quantidade; i++){
      novo[i] = dados[i];
    }
    dados = novo;
  }

  public int quantidade(){
    return quantidade;
  }

  public void inserirNoFinal(int valor){
    if(quantidade == dados.length)
      redimensionar(2 * dados.length);
    dados[quantidade] = valor;
    quantidade++;
  }

  public void inserirNoInicio(int valor){
    if(quantidade == dados.length)
      redimensionar(2 * dados.length);
    for(int i = quantidade; i > 0; i--){
      dados[i] = dados[i-1];
    }
    dados[0] = valor;
    quantidade++;
  }

  public int buscar(int valor){
    for(int i = 0; i < quantidade; i++){
      if(dados[i] == valor) return i;
    }
    return -1;
  }

  //fazer o removerDoInicio

}
