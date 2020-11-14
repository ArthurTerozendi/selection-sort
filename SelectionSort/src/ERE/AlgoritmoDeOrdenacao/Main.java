package ERE.AlgoritmoDeOrdenacao;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Leitura leitura = new Leitura();
        Escrever escrever = new Escrever();
        Bench bench = new Bench();

        float cotacao[] = leitura.lerCotacao();
        //PrintArray(cotacao);
        //bench.CreateBench("cotação SelectionSort", () -> SelectionSort(cotacao));

        SelectionSort(cotacao);

        PrintArray(cotacao);


        //String nomes[] = leitura.lerNomes();
        //PrintArray(nomes);
        //bench.SetBenchConfig(4000, 2, 3, 1);
        //bench.CreateBench("nomes SelectionSort", () -> SelectionSort(nomes));
        //PrintArray(nomes);

        escrever.escrever("cotacaoEMBR3.csv", cotacao);
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
