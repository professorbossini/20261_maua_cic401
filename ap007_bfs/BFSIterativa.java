package ap007_bfs;
import java.util.*;
public class BFSIterativa {
  private List < List<Integer> > vizinhos;
  private int n;

  public BFSIterativa(int n){
    this.n = n;
    this.vizinhos = new ArrayList<>(n);
    for(int i = 0; i < n; i++){
      vizinhos.add(new ArrayList<>());
    }
  }

  public void adicionarAresta(int u, int v){
    vizinhos.get(u).add(v);
    vizinhos.get(v).add(u);  
  }

  public void bfs(int s, int [] d, int [] pi){
    int [] cor = new int[n];
    for(int u = 0; u < n; u++){
      cor[u] = 0;
      d[u] = Integer.MAX_VALUE;
      pi[u] = -1;
    }
    cor[s] = 1;
    d[s] = 0;

    Queue <Integer> fila = new LinkedList<>();
    fila.add(s);
    while(!fila.isEmpty()){
      int u = fila.poll();  
      for(int v : vizinhos.get(u)){
        if(cor[v] == 0){
          cor[v] = 1;
          d[v] = d[u] + 1;
          pi[v] = u;
          fila.add(v);
        }
      }
      cor[u] = 2;
    }
  }

  public static void main(String[] args) {
    BFSIterativa g = new BFSIterativa(7);
    g.adicionarAresta(1, 2);
    g.adicionarAresta(1, 3);
    g.adicionarAresta(2, 4);
    g.adicionarAresta(3, 4);
    g.adicionarAresta(3, 5);
    g.adicionarAresta(4, 6);
    g.adicionarAresta(5, 6);

    int [] d = new int [7];
    int [] pi = new int[7];
    g.bfs(1, d, pi);

    System.out.println("v\td[v]\tpi[v]");
    for(int v = 1; v <= 6; v++){
      System.out.printf("%d\t%2d\t%2d\n", v, d[v], pi[v]);
    }
  }

}
