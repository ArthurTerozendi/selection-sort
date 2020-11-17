package ERE.AlgoritmoDeOrdenacao;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        Leitura leitura = new Leitura();
        Bench bench = new Bench();

        float cotacao[] = leitura.lerCotacao();
        //PrintArray(cotacao);
        /**
         * Eu uso cotacao clone, pois no primeiro bench já pode organizar a array, e passar a ser um caso
         * distindo do caso inicial. Ex: Era pra ser um average, mas no primeiro bench ele ja ordena,
         * entao nos testes subsequentes será outro caso.
         */

        //Caso medio, vou considerar que seja uma array bagunçada
        bench.CreateBench("cotação SelectionSort | Average Case", () -> SelectionSort(cotacao.clone()));

        //Melhor caso, array ordenada de forma crescente
        SelectionSort(cotacao);
        bench.CreateBench("cotação SelectionSort | Best Case", () -> SelectionSort(cotacao.clone()));

        //Pior caso, array ordenada de forma decrescente
        Reverse(cotacao);
        bench.CreateBench("cotação SelectionSort | Worst Case", () -> SelectionSort(cotacao.clone()));

        //PrintArray(cotacao);


        String nomes[] = leitura.lerNomes();
        PrintArray(nomes);
        bench.SetBenchConfig(4000, 2, 3, 1);
        bench.CreateBench("nomes SelectionSort", () -> SelectionSort(nomes));
        PrintArray(nomes);
    }

    /**
     * Ordena de forma reversa uma array.
     * @param arr A array a ser revertida
     */
    public static void Reverse(float[] arr){
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            float temp = arr[left];
            arr[left]  = arr[right];
            arr[right] = temp;
        }
    }
    /**
     * Utilizando o algoritmo SelectionSort, a cadeia é ordenada de forma alfabetica
     * @param arr A array a ser ordenada
     */
    public static void SelectionSort(String arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int menorIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[menorIndex].compareTo(arr[j]) > 0) {
                    menorIndex = j;
                }
            }
            if (arr[i].compareTo(arr[menorIndex]) > 0) {
                String _aux = arr[i];
                arr[i] = arr[menorIndex];
                arr[menorIndex] = _aux;
            }
        }
    }

    /**
     * Utilizando o algoritmo SelectionSort, a cadeia é ordenada de crescente
     * @param arr A array a ser ordenada
     */
    public static void SelectionSort(float[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int menorIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[menorIndex] > arr[j]) {
                    menorIndex = j;
                }
            }
            if (arr[i] > arr[menorIndex]){
                float _aux = arr[i];
                arr[i] = arr[menorIndex];
                arr[menorIndex] = _aux;
            }
        }
    }

    /**
     * Imprime uma array de Strings para o usuario.
     * @param arr A array a ser imprimida
     */
    public static void PrintArray(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /**
     * Imprime uma array de float para o usuario.
     * @param arr A array a ser imprimida
     */
    public static void PrintArray(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
