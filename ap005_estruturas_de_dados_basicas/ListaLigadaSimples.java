package ap005_estruturas_de_dados_basicas;

public class ListaLigadaSimples {
  private static class No{
    int valor;
    No proximo;
    
    No(int valor){
      this.valor = valor;
      this.proximo = null;
    }
  }

  private No inicio, fim;
  private int quantidade;

  public ListaLigadaSimples(){
    inicio = null;
    fim = null;
    quantidade = 0;
  }

  public void inserirNoInicio(int valor){
    var novo = new No(valor);
    novo.proximo = inicio;
    inicio = novo;
    if(fim == null)
      fim = novo;
    quantidade++;
  }

  public void inserirNoFinal(int valor){
    var novo = new No(valor);
    if(fim == null){
      inicio = novo;
      fim = novo;
    }
    else{
      fim.proximo = novo;
      fim = novo;
    }
    quantidade++;
  }

  public int acessar(int indice){
    if(indice < 0 || indice >= quantidade)
      throw new ArrayIndexOutOfBoundsException();
    No atual = inicio;
    for(int i = 0; i < indice; i++)
      atual = atual.proximo;
    return atual.valor;
  }

  public boolean buscar(int valor){
    No atual = inicio;
    while (atual != null){
      if(atual.valor == valor) return true;
      atual = atual.proximo;  
    }
    return false;
  }

  public int removerDoInicio(){
    if(inicio == null)
      throw new RuntimeException("Lista vazia");
    int valor = inicio.valor;
    inicio = inicio.proximo;
    if(inicio == null)
      fim = null;
    quantidade--;
    return valor;
  }

  public int removerDoFinal(){
    if(inicio == null)
      throw new RuntimeException("Lista vazia");
    int valor;
    if(inicio == fim){
      valor = inicio.valor;
      inicio = null;
      fim = null;
    }
    else{
      No atual = inicio;
      // while(atual.proximo.proximo != null){
      while(atual.proximo != fim){
        atual = atual.proximo;
      }
      valor = fim.valor;
      atual.proximo = null;
      fim = atual;
    }
    quantidade--;
    return valor;
  }
}
