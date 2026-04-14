package ap005_estruturas_de_dados_basicas;

public class FilaArrayaIngenua {
  private int [] dados;
  private int tamanho;

  public FilaArrayaIngenua(int capacidade){
    dados = new int[capacidade];
    tamanho = 0;
  }

  //theta(1)
  public void enqueue(int valor){
    if(tamanho == dados.length)
      throw new RuntimeException("Fila cheia");
    dados[tamanho] = valor;
    tamanho++;
  }

  //theta(n)
  public int dequeue(){
    if(tamanho == 0)
      throw new RuntimeException("Fila vazia");
    int valor = dados[0];
    for(int i = 0; i < tamanho - 1; i++){
      dados[i] = dados[i + 1];
    }
    tamanho--;
    return valor;
  }


}
