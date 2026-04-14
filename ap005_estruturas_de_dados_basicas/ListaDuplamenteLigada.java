package ap005_estruturas_de_dados_basicas;

public class ListaDuplamenteLigada {
  private static class No{
    int valor;
    No anterior;
    No proximo;

    No (int valor){
      this.valor = valor;
      this.anterior = null;
      this.proximo = null;
    }
  }

  private No primeiro, ultimo;
  private int quantidade;
  public ListaDuplamenteLigada(){
    primeiro = ultimo = null;
    quantidade = 0;
  }

  public void inserirNoInicio(int valor){
    var novo = new No(valor);
    novo.proximo = primeiro;
    if(primeiro != null)
      primeiro.anterior = novo;
    else
      ultimo = novo;
    primeiro = novo;
    quantidade = quantidade + 1;
  }

  public void inserirNoFinal(int valor){
    var novo = new No(valor);
    novo.anterior = ultimo;
    if(ultimo != null){
      ultimo.proximo = novo;
    }
    else{
      primeiro = novo;
    }
    ultimo = novo;
    quantidade++;
  }

  //desafio: implementar esse método minimizando o número de iterações
  //considere que é possível iterar do início para o fim e do fim para o início
  public int acessar(int indice){
    if(indice < 0 || indice >= quantidade)
      throw new IndexOutOfBoundsException();
    No atual;
    if(indice < quantidade / 2){
      atual = primeiro;
      for(int i = 0; i < indice; i++)
        atual = atual.proximo;
    }
    else{
      atual = ultimo;
      for(int i = quantidade - 1; i > indice; i--){
        atual = atual.anterior;
      }
    }
    return atual.valor;
  }
}
