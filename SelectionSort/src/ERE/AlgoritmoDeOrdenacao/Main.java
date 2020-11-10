package ERE.AlgoritmoDeOrdenacao;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        Leitura leitura = new Leitura();
        float cotacao[] = leitura.lerCotacao();

        for (int i = 0; i < cotacao.length; i++) {
            System.out.print(cotacao[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < cotacao.length - 1; i++) {
            int menorIndex = i;
            for (int j = i; j < cotacao.length; j++) {
                if (cotacao[menorIndex] > cotacao[j]) {
                    menorIndex = j;
                }
            }
            if (cotacao[i] > cotacao[menorIndex]){
                float aux = cotacao[i];
                cotacao[i] = cotacao[menorIndex];
                cotacao[menorIndex] = aux;
            }
        }

        for (int i = 0; i < cotacao.length; i++) {
            System.out.print(cotacao[i] + " ");
        }

        System.out.println();

        String nomes[] = leitura.lerNomes();

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nomes.length - 1; i++) {
            int menorIndex = i;
            for (int j = i; j < nomes.length; j++) {
                if (nomes[menorIndex].compareTo(nomes[j]) > 0) {
                    menorIndex = j;
                }
            }
            if (nomes[i].compareTo(nomes[menorIndex]) > 0){
                String aux = nomes[i];
                nomes[i] = nomes[menorIndex];
                nomes[menorIndex] = aux;
            }
        }

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i] + " ");
        }

        System.out.println();
    }
}
