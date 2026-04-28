package ap006_algoritmos_gulosos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SelecaoIntervalos {
  static class Tarefa{
    int id;
    int inicio;
    int fim;

    Tarefa(int id, int inicio, int fim){
      this.id = id;
      this.inicio = inicio;
      this.fim = fim;
    }

    @Override
    public String toString() {
      return String.format("T%d [%d, %d)", id, inicio, fim);
    }
  }

  public static java.util.List <Tarefa> selecionar( Tarefa [] tarefas){
    Arrays.sort(tarefas, Comparator.comparingInt(t -> t.fim));
    java.util.List <Tarefa> selecionadas = new ArrayList<>();
    int ultimoFim = Integer.MIN_VALUE;
    for(Tarefa t : tarefas){
      //é compatível
      if(t.inicio >= ultimoFim){
        selecionadas.add(t);
        ultimoFim = t.fim;
      }
    }
    return selecionadas;
  }

  public static void main(String[] args) {
    
    Tarefa [] tarefas = {
      new Tarefa(1, 1, 4),
      new Tarefa(2, 3, 5),
      new Tarefa(3, 0, 6),
      new Tarefa(4, 5, 7),
      new Tarefa(5, 3, 8),
      new Tarefa(6, 5, 9),
      new Tarefa(7, 6, 10),
      new Tarefa(8, 8, 11)
    };

    java.util.List<Tarefa> resultado = selecionar(tarefas);
    int quantas =  resultado.size();
    System.out.println("Selecionadas: " + quantas);
    for(Tarefa t : resultado){
      System.out.println(t + " ");
    }
  }
}
