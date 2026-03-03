package ap003_insertion_sort;
import java.util.Arrays;
public class InsertionSort {

    public static void sort(int [] A){
        int n = A.length;
        for(int j = 1; j < n; j++){
            int chave = A[j];
            //eu não olhei para todas na minha mão esquerda
            //e não encontrei onde parar
            int i = j - 1;
            while (i >= 0 && A[i] > chave){
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = chave;

        }
    }

    public static void testar(){
        //gerar um vetor de um milhão de elementos preenchido aleatoriamente com valores entre 1 e 100 (use a classe Random)
        //execute o algoritmo, calculando seu tempo de execução (use System.currentTimeInMillis)
        //execute o algorimo novamente, calculando seu tempo de execução
    }
    public static void main(String[] args) {
       int [] A = {6, 5, 4, 7, 8, 2, 2, 5};
       sort(A);
       System.out.println(Arrays.toString(A));
    }
}
