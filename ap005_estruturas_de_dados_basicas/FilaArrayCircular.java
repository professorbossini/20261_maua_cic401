package ap005_estruturas_de_dados_basicas;

public class FilaArrayCircular {
  private int [] dados;
  private int inicio;
  private int fim;
  private int tamanho;

  public FilaArrayCircular(int capacidade){
    dados = new int[capacidade];
    inicio = 0;
    fim = -1;
    tamanho = 0;
  }

  //theta(1)
  public void enqueue(int valor){
    if(tamanho == dados.length)
      throw new RuntimeException("Fila cheia");
    fim =(fim + 1) % dados.length; //módulo
    dados[fim] = valor;
    tamanho++;
  }

  //theta(1)
  public int  dequeue(){
    if(tamanho == 0)
      throw new RuntimeException("Fila vazia");
    //pegar o valor na posição início
    int valor = dados[inicio];
    //contar módulo n no início
    inicio = (inicio + 1) % dados.length;
    //decrementar o tamanho
    tamanho--;
    //devolver o valor    
    return valor;
  }
}

